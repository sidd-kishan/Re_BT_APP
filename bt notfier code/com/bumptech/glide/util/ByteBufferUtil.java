/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.ByteBufferUtil$ByteBufferStream
 *  com.bumptech.glide.util.ByteBufferUtil$SafeArray
 */
package com.bumptech.glide.util;

import com.bumptech.glide.util.ByteBufferUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = new AtomicReference();
    private static final int BUFFER_SIZE = 16384;

    private ByteBufferUtil() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public static ByteBuffer fromFile(File var0) throws IOException {
        block19: {
            block18: {
                block17: {
                    var4_4 = null;
                    var5_6 = null;
                    var1_8 = var0.length();
                    if (var1_8 > 0x7FFFFFFFL) ** GOTO lbl38
                    if (var1_8 == 0L) ** GOTO lbl36
                    var3_9 = new RandomAccessFile((File)var0, "r");
                    var0 = var5_6;
                    var0 = var4_4 = var3_9.getChannel();
                    var5_6 = var4_4.map(FileChannel.MapMode.READ_ONLY, 0L, var1_8).load();
                    if (var4_4 == null) break block17;
                    try {
                        var4_4.close();
                    }
                    catch (IOException var0_2) {
                        ** continue;
                    }
                }
lbl16:
                // 2 sources

                while (true) {
                    try {}
                    catch (IOException var0_3) {}
                    break block18;
lbl20:
                    // 2 sources

                    return var5_6;
                }
lbl22:
                // 1 sources

                throw var0;
            }
            var3_9.close();
            ** while (true)
            catch (Throwable var0_1) {
                var3_9 = null;
            }
            break block19;
            catch (Throwable var5_7) {
                var4_4 = var0;
                var0 = var5_7;
            }
            {
                break block19;
lbl36:
                // 1 sources

                var0 = new IOException("File unsuitable for memory mapping");
                throw var0;
lbl38:
                // 1 sources

                var0 = new IOException("File too large to map into memory");
                throw var0;
            }
        }
        if (var4_4 != null) {
            try {
                var4_4.close();
            }
            catch (IOException var4_5) {
                // empty catch block
            }
        }
        if (var3_9 == null) throw var0;
        {
            var3_9.close();
            ** continue;
        }
    }

    public static ByteBuffer fromStream(InputStream object) throws IOException {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] byArray2 = byArray = (byte[])BUFFER_REF.getAndSet(null);
        if (byArray == null) {
            byArray2 = new byte[16384];
        }
        while (true) {
            int n;
            if ((n = ((InputStream)object).read(byArray2)) < 0) {
                BUFFER_REF.set(byArray2);
                object = byteArrayOutputStream.toByteArray();
                return (ByteBuffer)ByteBuffer.allocateDirect(((Object)object).length).put((byte[])object).position(0);
            }
            byteArrayOutputStream.write(byArray2, 0, n);
        }
    }

    private static SafeArray getSafeArray(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) return null;
        if (!byteBuffer.hasArray()) return null;
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] toBytes(ByteBuffer object) {
        Object object2 = ByteBufferUtil.getSafeArray((ByteBuffer)object);
        if (object2 != null && ((SafeArray)object2).offset == 0 && ((SafeArray)object2).limit == ((SafeArray)object2).data.length) {
            object = ((ByteBuffer)object).array();
        } else {
            object2 = ((ByteBuffer)object).asReadOnlyBuffer();
            object = new byte[((Buffer)object2).limit()];
            ((Buffer)object2).position(0);
            ((ByteBuffer)object2).get((byte[])object);
        }
        return object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static void toFile(ByteBuffer byteBuffer, File object) throws IOException {
        RandomAccessFile randomAccessFile;
        block13: {
            void var0_3;
            Object object2;
            block14: {
                byteBuffer.position(0);
                object2 = null;
                Object var4_10 = null;
                randomAccessFile = new RandomAccessFile((File)object, "rw");
                object = var4_10;
                object = object2 = randomAccessFile.getChannel();
                ((FileChannel)object2).write(byteBuffer);
                object = object2;
                ((FileChannel)object2).force(false);
                object = object2;
                ((AbstractInterruptibleChannel)object2).close();
                object = object2;
                randomAccessFile.close();
                if (object2 == null) break block13;
                try {
                    ((AbstractInterruptibleChannel)object2).close();
                    break block13;
                }
                catch (IOException iOException) {}
                catch (Throwable throwable) {
                    object2 = object;
                    object = randomAccessFile;
                }
                break block14;
                catch (Throwable throwable) {
                    object = null;
                }
            }
            if (object2 != null) {
                try {
                    ((AbstractInterruptibleChannel)object2).close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            if (object == null) throw var0_3;
            try {
                ((RandomAccessFile)object).close();
            }
            catch (IOException iOException) {
                throw var0_3;
            }
            throw var0_3;
        }
        try {
            randomAccessFile.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    public static void toStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        Object object = ByteBufferUtil.getSafeArray(byteBuffer);
        if (object != null) {
            outputStream.write(object.data, object.offset, object.offset + object.limit);
        } else {
            byte[] byArray = BUFFER_REF.getAndSet(null);
            object = byArray;
            if (byArray == null) {
                object = new byte[16384];
            }
            while (byteBuffer.remaining() > 0) {
                int n = Math.min(byteBuffer.remaining(), ((SafeArray)object).length);
                byteBuffer.get((byte[])object, 0, n);
                outputStream.write((byte[])object, 0, n);
            }
            BUFFER_REF.set((byte[])object);
        }
    }
}
