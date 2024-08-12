/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.Xfermode
 *  android.os.Build
 *  android.util.Log
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.TransformationUtils$NoLock
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT;
    private static final Paint DEFAULT_PAINT;
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    static {
        DEFAULT_PAINT = new Paint(6);
        CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        Object object = new HashSet<String>(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        MODELS_REQUIRING_BITMAP_LOCK = object;
        object = object.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        BITMAP_DRAWABLE_LOCK = object;
        object = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = object;
        object.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    private static void applyMatrix(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        BITMAP_DRAWABLE_LOCK.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, DEFAULT_PAINT);
            TransformationUtils.clear(canvas);
            return;
        }
        finally {
            BITMAP_DRAWABLE_LOCK.unlock();
        }
    }

    public static Bitmap centerCrop(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        float f;
        float f2;
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int n3 = bitmap.getWidth();
        int n4 = bitmap.getHeight();
        float f3 = 0.0f;
        if (n3 * n2 > n4 * n) {
            f2 = (float)n2 / (float)bitmap.getHeight();
            f3 = ((float)n - (float)bitmap.getWidth() * f2) * 0.5f;
            f = 0.0f;
        } else {
            f2 = (float)n / (float)bitmap.getWidth();
            f = ((float)n2 - (float)bitmap.getHeight() * f2) * 0.5f;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate((float)((int)(f3 + 0.5f)), (float)((int)(f + 0.5f)));
        bitmapPool = bitmapPool.get(n, n2, TransformationUtils.getSafeConfig(bitmap));
        TransformationUtils.setAlpha(bitmap, (Bitmap)bitmapPool);
        TransformationUtils.applyMatrix(bitmap, (Bitmap)bitmapPool, matrix);
        return bitmapPool;
    }

    public static Bitmap centerInside(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        if (bitmap.getWidth() <= n && bitmap.getHeight() <= n2) {
            if (!Log.isLoggable((String)TAG, (int)2)) return bitmap;
            Log.v((String)TAG, (String)"requested target size larger or equal to input, returning input");
            return bitmap;
        }
        if (!Log.isLoggable((String)TAG, (int)2)) return TransformationUtils.fitCenter(bitmapPool, bitmap, n, n2);
        Log.v((String)TAG, (String)"requested target size too big for input, fit centering instead");
        return TransformationUtils.fitCenter(bitmapPool, bitmap, n, n2);
    }

    public static Bitmap circleCrop(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        int n3 = Math.min(n, n2);
        float f = n3;
        float f2 = f / 2.0f;
        n = bitmap.getWidth();
        n2 = bitmap.getHeight();
        float f3 = n;
        float f4 = f / f3;
        float f5 = n2;
        f4 = Math.max(f4, f / f5);
        f3 *= f4;
        f5 = f4 * f5;
        f4 = (f - f3) / 2.0f;
        f = (f - f5) / 2.0f;
        RectF rectF = new RectF(f4, f, f3 + f4, f5 + f);
        Bitmap bitmap2 = TransformationUtils.getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap3 = bitmapPool.get(n3, n3, Bitmap.Config.ARGB_8888);
        bitmap3.setHasAlpha(true);
        BITMAP_DRAWABLE_LOCK.lock();
        Canvas canvas = new Canvas(bitmap3);
        canvas.drawCircle(f2, f2, f2, CIRCLE_CROP_SHAPE_PAINT);
        canvas.drawBitmap(bitmap2, null, rectF, CIRCLE_CROP_BITMAP_PAINT);
        TransformationUtils.clear(canvas);
        if (bitmap2.equals(bitmap)) return bitmap3;
        bitmapPool.put(bitmap2);
        return bitmap3;
        finally {
            BITMAP_DRAWABLE_LOCK.unlock();
        }
    }

    private static void clear(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap fitCenter(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        StringBuilder stringBuilder;
        if (bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            if (!Log.isLoggable((String)TAG, (int)2)) return bitmap;
            Log.v((String)TAG, (String)"requested target size matches input, returning input");
            return bitmap;
        }
        float f = Math.min((float)n / (float)bitmap.getWidth(), (float)n2 / (float)bitmap.getHeight());
        int n3 = Math.round((float)bitmap.getWidth() * f);
        int n4 = Math.round((float)bitmap.getHeight() * f);
        if (bitmap.getWidth() == n3 && bitmap.getHeight() == n4) {
            if (!Log.isLoggable((String)TAG, (int)2)) return bitmap;
            Log.v((String)TAG, (String)"adjusted target size matches input, returning input");
            return bitmap;
        }
        bitmapPool = bitmapPool.get((int)((float)bitmap.getWidth() * f), (int)((float)bitmap.getHeight() * f), TransformationUtils.getSafeConfig(bitmap));
        TransformationUtils.setAlpha(bitmap, (Bitmap)bitmapPool);
        if (Log.isLoggable((String)TAG, (int)2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("request: ");
            stringBuilder.append(n);
            stringBuilder.append("x");
            stringBuilder.append(n2);
            Log.v((String)TAG, (String)stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("toFit:   ");
            stringBuilder.append(bitmap.getWidth());
            stringBuilder.append("x");
            stringBuilder.append(bitmap.getHeight());
            Log.v((String)TAG, (String)stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("toReuse: ");
            stringBuilder.append(bitmapPool.getWidth());
            stringBuilder.append("x");
            stringBuilder.append(bitmapPool.getHeight());
            Log.v((String)TAG, (String)stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("minPct:   ");
            stringBuilder.append(f);
            Log.v((String)TAG, (String)stringBuilder.toString());
        }
        stringBuilder = new Matrix();
        stringBuilder.setScale(f, f);
        TransformationUtils.applyMatrix(bitmap, (Bitmap)bitmapPool, (Matrix)stringBuilder);
        return bitmapPool;
    }

    private static Bitmap getAlphaSafeBitmap(BitmapPool bitmapPool, Bitmap bitmap) {
        if (Bitmap.Config.ARGB_8888.equals((Object)bitmap.getConfig())) {
            return bitmap;
        }
        bitmapPool = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)bitmapPool).drawBitmap(bitmap, 0.0f, 0.0f, null);
        return bitmapPool;
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    public static int getExifOrientationDegrees(int n) {
        switch (n) {
            default: {
                n = 0;
                break;
            }
            case 7: 
            case 8: {
                n = 270;
                break;
            }
            case 5: 
            case 6: {
                n = 90;
                break;
            }
            case 3: 
            case 4: {
                n = 180;
            }
        }
        return n;
    }

    private static Bitmap.Config getSafeConfig(Bitmap bitmap) {
        bitmap = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        return bitmap;
    }

    static void initializeMatrixForRotation(int n, Matrix matrix) {
        switch (n) {
            default: {
                break;
            }
            case 8: {
                matrix.setRotate(-90.0f);
                break;
            }
            case 7: {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 6: {
                matrix.setRotate(90.0f);
                break;
            }
            case 5: {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 4: {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            }
            case 3: {
                matrix.setRotate(180.0f);
                break;
            }
            case 2: {
                matrix.setScale(-1.0f, 1.0f);
            }
        }
    }

    public static boolean isExifOrientationRequired(int n) {
        switch (n) {
            default: {
                return false;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
        }
        return true;
    }

    public static Bitmap rotateImage(Bitmap bitmap, int n) {
        Bitmap bitmap2 = bitmap;
        if (n == 0) return bitmap2;
        try {
            bitmap2 = new Matrix();
            bitmap2.setRotate((float)n);
            bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)bitmap2, (boolean)true);
        }
        catch (Exception exception) {
            bitmap2 = bitmap;
            if (!Log.isLoggable((String)TAG, (int)6)) return bitmap2;
            Log.e((String)TAG, (String)"Exception when trying to orient image", (Throwable)exception);
            bitmap2 = bitmap;
        }
        return bitmap2;
    }

    public static Bitmap rotateImageExif(BitmapPool bitmapPool, Bitmap bitmap, int n) {
        if (!TransformationUtils.isExifOrientationRequired(n)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        TransformationUtils.initializeMatrixForRotation(n, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        bitmapPool = bitmapPool.get(Math.round(rectF.width()), Math.round(rectF.height()), TransformationUtils.getSafeConfig(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        TransformationUtils.applyMatrix(bitmap, (Bitmap)bitmapPool, matrix);
        return bitmapPool;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, int n) {
        boolean bl = n > 0;
        Preconditions.checkArgument((boolean)bl, (String)"roundingRadius must be greater than 0.");
        Bitmap bitmap2 = TransformationUtils.getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap3 = bitmapPool.get(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        bitmap3.setHasAlpha(true);
        BitmapShader bitmapShader = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader((Shader)bitmapShader);
        bitmapShader = new RectF(0.0f, 0.0f, (float)bitmap3.getWidth(), (float)bitmap3.getHeight());
        BITMAP_DRAWABLE_LOCK.lock();
        Canvas canvas = new Canvas(bitmap3);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        float f = n;
        canvas.drawRoundRect((RectF)bitmapShader, f, f, paint);
        TransformationUtils.clear(canvas);
        if (bitmap2.equals(bitmap)) return bitmap3;
        bitmapPool.put(bitmap2);
        return bitmap3;
        finally {
            BITMAP_DRAWABLE_LOCK.unlock();
        }
    }

    @Deprecated
    public static Bitmap roundedCorners(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2, int n3) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, n3);
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
