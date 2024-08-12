/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Log
 *  androidx.core.os.TraceCompat
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.Option
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.LogTime
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.core.os.TraceCompat;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BitmapEncoder
implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT;
    public static final Option<Integer> COMPRESSION_QUALITY;
    private static final String TAG = "BitmapEncoder";

    static {
        COMPRESSION_QUALITY = Option.memory((String)"com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", (Object)90);
        COMPRESSION_FORMAT = Option.memory((String)"com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        if ((options = (Bitmap.CompressFormat)options.get(COMPRESSION_FORMAT)) != null) {
            return options;
        }
        if (!bitmap.hasAlpha()) return Bitmap.CompressFormat.JPEG;
        return Bitmap.CompressFormat.PNG;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public boolean encode(Resource<Bitmap> var1_1, File var2_6, Options var3_10) {
        block19: {
            block20: {
                var13_11 = (Bitmap)var1_1.get();
                var14_12 = this.getFormat(var13_11, var3_10);
                var1_1 = new StringBuilder();
                var1_1.append("encode: [");
                var1_1.append(var13_11.getWidth());
                var1_1.append("x");
                var1_1.append(var13_11.getHeight());
                var1_1.append("] ");
                var1_1.append(var14_12);
                TraceCompat.beginSection((String)var1_1.toString());
                var5_13 = LogTime.getLogTime();
                var4_14 = (Integer)var3_10.get(BitmapEncoder.COMPRESSION_QUALITY);
                var9_15 = false;
                var8_16 = false;
                var11_17 = null;
                var12_18 = null;
                var1_1 = var12_18;
                var1_1 = var12_18;
                var10_19 = new FileOutputStream((File)var2_6);
                var13_11.compress(var14_12, var4_14, (OutputStream)var10_19);
                var10_19.close();
                var7_21 = true;
                var8_16 = true;
                var10_19.close();
                var7_21 = var8_16;
                ** GOTO lbl62
                catch (Throwable var2_7) {
                    var1_1 = var10_19;
                    break block19;
                }
                catch (IOException var1_2) {
                    var2_6 = var10_19;
                    var10_19 = var1_2;
                    break block20;
                }
                catch (Throwable var2_8) {
                    break block19;
                }
                catch (IOException var10_20) {
                    var2_6 = var11_17;
                }
            }
            var1_1 = var2_6;
            {
                if (Log.isLoggable((String)"BitmapEncoder", (int)3)) {
                    var1_1 = var2_6;
                    Log.d((String)"BitmapEncoder", (String)"Failed to encode Bitmap", (Throwable)var10_19);
                }
                var7_21 = var8_16;
                if (var2_6 == null) ** GOTO lbl62
                var7_21 = var9_15;
            }
            var2_6.close();
            var7_21 = var8_16;
lbl62:
            // 4 sources

            while (true) {
                if (Log.isLoggable((String)"BitmapEncoder", (int)2) == false) return var7_21;
                var1_1 = new StringBuilder();
                var1_1.append("Compressed with type: ");
                var1_1.append(var14_12);
                var1_1.append(" of size ");
                var1_1.append(Util.getBitmapByteSize((Bitmap)var13_11));
                var1_1.append(" in ");
                var1_1.append(LogTime.getElapsedMillis((long)var5_13));
                var1_1.append(", options format: ");
                var1_1.append(var3_10.get(BitmapEncoder.COMPRESSION_FORMAT));
                var1_1.append(", hasAlpha: ");
                var1_1.append(var13_11.hasAlpha());
                Log.v((String)"BitmapEncoder", (String)var1_1.toString());
                return var7_21;
            }
        }
        if (var1_1 == null) throw var2_9;
        try {
            var1_1.close();
            throw var2_9;
        }
        catch (Throwable var1_3) {}
        throw var1_3;
        catch (IOException var1_4) {
            ** continue;
        }
        finally {
            TraceCompat.endSection();
        }
        catch (IOException var1_5) {
            throw var2_9;
        }
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
