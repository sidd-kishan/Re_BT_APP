/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.net.Uri
 *  android.util.Log
 *  android.view.WindowManager
 *  com.yalantis.ucrop.callback.BitmapLoadCallback
 *  com.yalantis.ucrop.task.BitmapLoadTask
 *  com.yalantis.ucrop.util.EglUtils
 *  com.yalantis.ucrop.util.ImageHeaderParser
 */
package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import com.yalantis.ucrop.util.EglUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    public static int calculateInSampleSize(BitmapFactory.Options options, int n, int n2) {
        int n3;
        int n4 = options.outHeight;
        int n5 = options.outWidth;
        int n6 = 1;
        int n7 = n3 = 1;
        if (n4 <= n2) {
            if (n5 <= n) return n6;
            n7 = n3;
        }
        while (true) {
            if (n4 / n7 <= n2) {
                n6 = n7;
                if (n5 / n7 <= n) return n6;
            }
            n7 *= 2;
        }
    }

    public static int calculateMaxBitmapSize(Context object) {
        WindowManager windowManager = (WindowManager)object.getSystemService("window");
        object = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize((Point)object);
        }
        int n = ((Point)object).x;
        int n2 = ((Point)object).y;
        n = (int)Math.sqrt(Math.pow(n, 2.0) + Math.pow(n2, 2.0));
        object = new Canvas();
        int n3 = Math.min(object.getMaximumBitmapWidth(), object.getMaximumBitmapHeight());
        n2 = n;
        if (n3 > 0) {
            n2 = Math.min(n, n3);
        }
        n3 = EglUtils.getMaxTextureSize();
        n = n2;
        if (n3 > 0) {
            n = Math.min(n2, n3);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("maxBitmapSize: ");
        ((StringBuilder)object).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return n;
    }

    /*
     * Enabled force condition propagation
     */
    public static void close(Closeable closeable) {
        if (!(closeable instanceof Closeable)) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int n, int n2, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, n, n2, bitmapLoadCallback).executeOnExecutor((Executor)Executors.newCachedThreadPool(), (Object[])new Void[0]);
    }

    public static int exifToDegrees(int n) {
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

    public static int exifToTranslation(int n) {
        n = n != 2 && n != 7 && n != 4 && n != 5 ? 1 : -1;
        return n;
    }

    public static int getExifOrientation(Context object, Uri uri) {
        int n;
        int n2 = n = 0;
        try {
            InputStream inputStream = object.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return 0;
            }
            n2 = n;
            n2 = n;
            object = new ImageHeaderParser(inputStream);
            n2 = n;
            n2 = n = object.getOrientation();
            BitmapLoadUtils.close(inputStream);
            n2 = n;
        }
        catch (IOException iOException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getExifOrientation: ");
            ((StringBuilder)object).append(uri.toString());
            Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)iOException);
        }
        return n2;
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            matrix = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
            boolean bl = bitmap.sameAs((Bitmap)matrix);
            if (bl) return bitmap;
            bitmap = matrix;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            Log.e((String)TAG, (String)"transformBitmap: ", (Throwable)outOfMemoryError);
        }
        return bitmap;
    }
}
