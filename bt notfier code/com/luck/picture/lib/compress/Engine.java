/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.text.TextUtils
 *  com.luck.picture.lib.compress.Checker
 *  com.luck.picture.lib.compress.InputStreamProvider
 *  com.luck.picture.lib.tools.BitmapUtils
 */
package com.luck.picture.lib.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.compress.InputStreamProvider;
import com.luck.picture.lib.tools.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class Engine {
    private static final int DEFAULT_QUALITY = 80;
    private int compressQuality;
    private final Context context;
    private final boolean focusAlpha;
    private final boolean isAutoRotating;
    private int srcHeight;
    private final InputStreamProvider srcImg;
    private int srcWidth;
    private final File tagImg;

    Engine(Context context, InputStreamProvider inputStreamProvider, File file, boolean bl, int n, boolean bl2) throws IOException {
        this.tagImg = file;
        this.srcImg = inputStreamProvider;
        this.context = context;
        this.focusAlpha = bl;
        this.isAutoRotating = bl2;
        int n2 = n;
        if (n <= 0) {
            n2 = 80;
        }
        this.compressQuality = n2;
        if (inputStreamProvider.getMedia().getWidth() > 0 && inputStreamProvider.getMedia().getHeight() > 0) {
            this.srcWidth = inputStreamProvider.getMedia().getWidth();
            this.srcHeight = inputStreamProvider.getMedia().getHeight();
        } else {
            context = new BitmapFactory.Options();
            context.inJustDecodeBounds = true;
            context.inSampleSize = 1;
            BitmapFactory.decodeStream((InputStream)inputStreamProvider.open(), null, (BitmapFactory.Options)context);
            this.srcWidth = context.outWidth;
            this.srcHeight = context.outHeight;
        }
    }

    private int computeSize() {
        int n = this.srcWidth;
        int n2 = 1;
        int n3 = n;
        if (n % 2 == 1) {
            n3 = n + 1;
        }
        this.srcWidth = n3;
        n3 = n = this.srcHeight;
        if (n % 2 == 1) {
            n3 = n + 1;
        }
        this.srcHeight = n3;
        n3 = Math.max(this.srcWidth, n3);
        float f = (float)Math.min(this.srcWidth, this.srcHeight) / (float)n3;
        if (f <= 1.0f && (double)f > 0.5625) {
            if (n3 < 1664) {
                return 1;
            }
            if (n3 < 4990) {
                return 2;
            }
            if (n3 <= 4990) return n3 / 1280;
            if (n3 >= 10240) return n3 / 1280;
            return 4;
        }
        double d = f;
        if (d <= 0.5625 && d > 0.5) {
            if ((n3 /= 1280) != 0) return n3;
            n3 = n2;
            return n3;
        }
        double d2 = n3;
        Double.isNaN(d);
        d = 1280.0 / d;
        Double.isNaN(d2);
        return (int)Math.ceil(d2 / d);
    }

    File compress() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        Object object;
        block6: {
            int n;
            Bitmap bitmap;
            block8: {
                block7: {
                    object = new BitmapFactory.Options();
                    ((BitmapFactory.Options)object).inSampleSize = this.computeSize();
                    bitmap = BitmapFactory.decodeStream((InputStream)this.srcImg.open(), null, (BitmapFactory.Options)object);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    object = bitmap;
                    if (this.isAutoRotating) {
                        object = bitmap;
                        if (Checker.SINGLE.isJPG(this.srcImg.getMedia().getMimeType())) {
                            n = this.srcImg.getMedia().isCut() && !TextUtils.isEmpty((CharSequence)this.srcImg.getMedia().getCutPath()) ? 1 : 0;
                            Context context = this.context;
                            object = n != 0 ? this.srcImg.getMedia().getCutPath() : this.srcImg.getMedia().getPath();
                            n = BitmapUtils.readPictureDegree((Context)context, (String)object);
                            object = bitmap;
                            if (n > 0) {
                                object = BitmapUtils.rotatingImage((Bitmap)bitmap, (int)n);
                            }
                        }
                    }
                    if (object == null) break block6;
                    int n2 = this.compressQuality;
                    if (n2 <= 0) break block7;
                    n = n2;
                    if (n2 <= 100) break block8;
                }
                n = 80;
            }
            this.compressQuality = n;
            bitmap = this.focusAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
            object.compress((Bitmap.CompressFormat)bitmap, this.compressQuality, (OutputStream)byteArrayOutputStream);
            object.recycle();
        }
        object = new FileOutputStream(this.tagImg);
        ((FileOutputStream)object).write(byteArrayOutputStream.toByteArray());
        ((OutputStream)object).flush();
        ((FileOutputStream)object).close();
        byteArrayOutputStream.close();
        return this.tagImg;
    }
}
