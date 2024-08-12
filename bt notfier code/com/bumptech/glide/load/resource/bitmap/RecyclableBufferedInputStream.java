/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream$InvalidMarkException
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream
extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos = -1;
    private int pos;

    public RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool, int n) {
        super(inputStream);
        this.byteArrayPool = arrayPool;
        this.buf = (byte[])arrayPool.get(n, byte[].class);
    }

    private int fillbuf(InputStream inputStream, byte[] byArray) throws IOException {
        int n;
        int n2;
        int n3 = this.markpos;
        if (n3 != -1 && (n2 = this.pos) - n3 < (n = this.marklimit)) {
            byte[] byArray2;
            if (n3 == 0 && n > byArray.length && this.count == byArray.length) {
                n2 = byArray.length * 2;
                if (n2 <= n) {
                    n = n2;
                }
                byArray2 = (byte[])this.byteArrayPool.get(n, byte[].class);
                System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
                this.buf = byArray2;
                this.byteArrayPool.put((Object)byArray);
            } else {
                n = this.markpos;
                byArray2 = byArray;
                if (n > 0) {
                    System.arraycopy(byArray, n, byArray, 0, byArray.length - n);
                    byArray2 = byArray;
                }
            }
            this.pos = n = this.pos - this.markpos;
            this.markpos = 0;
            this.count = 0;
            n2 = inputStream.read(byArray2, n, byArray2.length - n);
            n = this.pos;
            if (n2 > 0) {
                n += n2;
            }
            this.count = n;
            return n2;
        }
        n = inputStream.read(byArray);
        if (n <= 0) return n;
        this.markpos = -1;
        this.pos = 0;
        this.count = n;
        return n;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    @Override
    public int available() throws IOException {
        synchronized (this) {
            InputStream inputStream = this.in;
            if (this.buf == null) throw RecyclableBufferedInputStream.streamClosed();
            if (inputStream == null) throw RecyclableBufferedInputStream.streamClosed();
            int n = this.count;
            int n2 = this.pos;
            int n3 = inputStream.available();
            return n - n2 + n3;
        }
    }

    @Override
    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put((Object)this.buf);
            this.buf = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream == null) return;
        inputStream.close();
    }

    public void fixMarkLimit() {
        synchronized (this) {
            this.marklimit = this.buf.length;
            return;
        }
    }

    @Override
    public void mark(int n) {
        synchronized (this) {
            this.marklimit = Math.max(this.marklimit, n);
            this.markpos = this.pos;
            return;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    @Override
    public int read() throws IOException {
        synchronized (this) {
            Object object;
            Object object2;
            byte[] byArray;
            block6: {
                byArray = this.buf;
                object2 = this.in;
                if (byArray == null) throw RecyclableBufferedInputStream.streamClosed();
                if (object2 == null) throw RecyclableBufferedInputStream.streamClosed();
                if (this.pos < this.count || (object = this.fillbuf((InputStream)object2, byArray)) != -1) break block6;
                return -1;
            }
            object2 = byArray;
            {
                if (byArray != this.buf) {
                    object2 = this.buf;
                    if (object2 == null) throw RecyclableBufferedInputStream.streamClosed();
                }
                if (this.count - this.pos <= 0) return -1;
                object = this.pos;
                this.pos = object + 1;
            }
            object = object2[object];
            return object & 0xFF;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public int read(byte[] var1_1, int var2_3, int var3_4) throws IOException {
        synchronized (this) {
            block16: {
                block13: {
                    block14: {
                        block15: {
                            block12: {
                                var9_5 = this.buf;
                                if (var9_5 == null) throw RecyclableBufferedInputStream.streamClosed();
                                if (var3_4 != 0) break block12;
                                return 0;
                            }
                            var10_6 = this.in;
                            if (var10_6 == null) break block13;
                            if (this.pos >= this.count) break block14;
                            var4_7 = this.count - this.pos >= var3_4 ? var3_4 : this.count - this.pos;
                            System.arraycopy(var9_5, this.pos, var1_1, var2_3, var4_7);
                            this.pos += var4_7;
                            if (var4_7 == var3_4) return var4_7;
                            var5_8 = var10_6.available();
                            if (var5_8 == 0) break block15;
                            var5_8 = var2_3 + var4_7;
                            var2_3 = var3_4 - var4_7;
                            var4_7 = var5_8;
                            break block16;
                        }
                        return var4_7;
                    }
                    var5_8 = var3_4;
                    var4_7 = var2_3;
                    var2_3 = var5_8;
                    break block16;
                }
                throw RecyclableBufferedInputStream.streamClosed();
            }
            while (true) lbl-1000:
            // 2 sources

            {
                var5_8 = this.markpos;
                var6_9 = -1;
                if (var5_8 != -1 || var2_3 < var9_5.length) break block17;
                var7_10 = var10_6.read(var1_1, var4_7, var2_3);
                var8_11 = var9_5;
                var5_8 = var7_10;
                if (var7_10 != -1) break block18;
                if (var2_3 != var3_4) return var3_4 - var2_3;
                break;
            }
            {
                block20: {
                    block18: {
                        block19: {
                            block17: {
                                return var6_9;
                            }
                            var5_8 = this.fillbuf(var10_6, var9_5);
                            if (var5_8 != -1) break block19;
                            if (var2_3 != var3_4) return var3_4 - var2_3;
                            return var6_9;
                        }
                        var8_11 = var9_5;
                        if (var9_5 != this.buf) {
                            var8_11 = this.buf;
                            if (var8_11 == null) throw RecyclableBufferedInputStream.streamClosed();
                        }
                        var5_8 = this.count - this.pos >= var2_3 ? var2_3 : this.count - this.pos;
                        System.arraycopy(var8_11, this.pos, var1_1, var4_7, var5_8);
                        this.pos += var5_8;
                    }
                    if ((var2_3 -= var5_8) == 0) {
                        return var3_4;
                    }
                    var6_9 = var10_6.available();
                    if (var6_9 != 0) break block20;
                    return var3_4 - var2_3;
                }
                var4_7 += var5_8;
                var9_5 = var8_11;
                ** while (true)
            }
        }
    }

    public void release() {
        synchronized (this) {
            if (this.buf == null) return;
            this.byteArrayPool.put((Object)this.buf);
            this.buf = null;
            return;
        }
    }

    @Override
    public void reset() throws IOException {
        synchronized (this) {
            if (this.buf == null) {
                IOException iOException = new IOException("Stream is closed");
                throw iOException;
            }
            if (-1 != this.markpos) {
                this.pos = this.markpos;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Mark has been invalidated, pos: ");
            stringBuilder.append(this.pos);
            stringBuilder.append(" markLimit: ");
            stringBuilder.append(this.marklimit);
            InvalidMarkException invalidMarkException = new InvalidMarkException(stringBuilder.toString());
            throw invalidMarkException;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public long skip(long l) throws IOException {
        synchronized (this) {
            if (l < 1L) {
                return 0L;
            }
            byte[] byArray = this.buf;
            if (byArray == null) throw RecyclableBufferedInputStream.streamClosed();
            InputStream inputStream = this.in;
            if (inputStream == null) throw RecyclableBufferedInputStream.streamClosed();
            if ((long)(this.count - this.pos) >= l) {
                this.pos = (int)((long)this.pos + l);
                return l;
            }
            long l2 = (long)this.count - (long)this.pos;
            this.pos = this.count;
            if (this.markpos != -1 && l <= (long)this.marklimit) {
                int n = this.fillbuf(inputStream, byArray);
                if (n == -1) {
                    return l2;
                }
                if ((long)(this.count - this.pos) >= l - l2) {
                    this.pos = (int)((long)this.pos + l - l2);
                    return l;
                }
                long l3 = this.count;
                l = this.pos;
                this.pos = this.count;
                return l2 + l3 - l;
            }
            l = inputStream.skip(l - l2);
            return l2 + l;
        }
    }
}
