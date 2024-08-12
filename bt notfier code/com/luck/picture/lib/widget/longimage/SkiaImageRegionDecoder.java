/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.widget.longimage.ImageRegionDecoder
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.longimage.ImageRegionDecoder;
import java.io.InputStream;

public class SkiaImageRegionDecoder
implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private BitmapRegionDecoder decoder;
    private final Object decoderLock = new Object();

    public Bitmap decodeRegion(Rect object, int n) {
        Object object2 = this.decoderLock;
        synchronized (object2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = n;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            object = this.decoder.decodeRegion(object, options);
            if (object != null) {
                return object;
            }
            object = new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            throw object;
        }
    }

    /*
     * Unable to fully structure code
     */
    public Point init(Context var1_1, Uri var2_4) throws Exception {
        block15: {
            block16: {
                block18: {
                    block17: {
                        var4_7 = var2_4.toString();
                        if (!var4_7.startsWith("android.resource://")) break block16;
                        var5_8 = var2_4.getAuthority();
                        var4_7 = var1_1.getPackageName().equals(var5_8) != false ? var1_1.getResources() : var1_1.getPackageManager().getResourcesForApplication(var5_8);
                        var3_9 = (var2_4 = var2_4.getPathSegments()).size();
                        if (var3_9 != 2 || !((String)var2_4.get(0)).equals("drawable")) break block17;
                        var3_9 = var4_7.getIdentifier((String)var2_4.get(1), "drawable", var5_8);
                        ** GOTO lbl17
                    }
                    if (var3_9 != 1 || !TextUtils.isDigitsOnly((CharSequence)((CharSequence)var2_4.get(0)))) break block18;
                    var3_9 = ValueOf.toInt(var2_4.get(0));
                    ** GOTO lbl17
                }
lbl15:
                // 2 sources

                while (true) {
                    var3_9 = 0;
lbl17:
                    // 3 sources

                    this.decoder = BitmapRegionDecoder.newInstance((InputStream)var1_1.getResources().openRawResource(var3_9), (boolean)false);
                    break block15;
                    break;
                }
            }
            if (var4_7.startsWith("file:///android_asset/")) {
                var2_4 = var4_7.substring(22);
                this.decoder = BitmapRegionDecoder.newInstance((InputStream)var1_1.getAssets().open((String)var2_4, 1), (boolean)false);
            } else if (var4_7.startsWith("file://")) {
                this.decoder = BitmapRegionDecoder.newInstance((String)var4_7.substring(7), (boolean)false);
            } else {
                var4_7 = null;
                var1_1 = var1_1.getContentResolver().openInputStream((Uri)var2_4);
                var4_7 = var1_1;
                this.decoder = BitmapRegionDecoder.newInstance((InputStream)var1_1, (boolean)false);
                if (var1_1 == null) return new Point(this.decoder.getWidth(), this.decoder.getHeight());
                var1_1.close();
            }
        }
lbl36:
        // 2 sources

        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
        catch (Throwable var1_2) {
            block19: {
                if (var4_7 == null) throw var1_2;
                try {}
                catch (Exception var2_6) {}
                break block19;
lbl43:
                // 2 sources

                throw var1_2;
                catch (Exception var1_3) {
                    ** continue;
                }
                catch (NumberFormatException var2_5) {
                    ** continue;
                }
            }
            var4_7.close();
            ** continue;
        }
    }

    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        boolean bl = bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled();
        return bl;
    }

    public void recycle() {
        this.decoder.recycle();
    }
}
