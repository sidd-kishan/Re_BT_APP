/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.Encoder
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 */
package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamEncoder
implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public boolean encode(InputStream closeable, File file, Options object) {
        void var1_4;
        byte[] byArray;
        block17: {
            boolean bl;
            block16: {
                block14: {
                    boolean bl2;
                    boolean bl3;
                    block15: {
                        int n;
                        byArray = (byte[])this.byteArrayPool.get(65536, byte[].class);
                        bl3 = false;
                        bl2 = false;
                        Object var9_15 = null;
                        Object var10_16 = null;
                        object = var10_16;
                        object = var10_16;
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while ((n = ((InputStream)closeable).read(byArray)) != -1) {
                            ((OutputStream)fileOutputStream).write(byArray, 0, n);
                        }
                        ((OutputStream)fileOutputStream).close();
                        bl = true;
                        bl2 = true;
                        try {
                            ((OutputStream)fileOutputStream).close();
                            bl = bl2;
                        }
                        catch (IOException iOException) {}
                        catch (Throwable throwable) {
                            object = fileOutputStream;
                            break block14;
                        }
                        catch (IOException iOException) {
                            closeable = fileOutputStream;
                            break block15;
                        }
                        catch (Throwable throwable) {
                            break block14;
                        }
                        catch (IOException iOException) {
                            closeable = var9_15;
                        }
                    }
                    object = closeable;
                    {
                        if (Log.isLoggable((String)TAG, (int)3)) {
                            void var2_9;
                            object = closeable;
                            Log.d((String)TAG, (String)"Failed to encode data onto the OutputStream", (Throwable)var2_9);
                        }
                        bl = bl2;
                        if (closeable == null) break block16;
                        bl = bl3;
                    }
                    ((OutputStream)closeable).close();
                    bl = bl2;
                    break block16;
                }
                if (object == null) break block17;
                try {
                    ((OutputStream)object).close();
                    break block17;
                }
                catch (IOException iOException) {}
            }
            this.byteArrayPool.put((Object)byArray);
            return bl;
        }
        this.byteArrayPool.put((Object)byArray);
        throw var1_4;
    }
}
