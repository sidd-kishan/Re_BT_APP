/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.LightingColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.appcompat.content.res.AppCompatResources
 *  com.qmuiteam.qmui.QMUILog
 */
package com.qmuiteam.qmui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.qmuiteam.qmui.QMUILog;

public class QMUIDrawableHelper {
    private static final String TAG = QMUIDrawableHelper.class.getSimpleName();
    private static final Canvas sCanvas = new Canvas();

    public static Bitmap createBitmapFromView(View view) {
        return QMUIDrawableHelper.createBitmapFromView(view, 1.0f);
    }

    public static Bitmap createBitmapFromView(View view, float f) {
        Drawable drawable;
        if (view instanceof ImageView && (drawable = ((ImageView)view).getDrawable()) != null && drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        view.clearFocus();
        Bitmap bitmap = QMUIDrawableHelper.createBitmapSafely((int)((float)view.getWidth() * f), (int)((float)view.getHeight() * f), Bitmap.Config.ARGB_8888, 1);
        if (bitmap == null) return bitmap;
        drawable = sCanvas;
        synchronized (drawable) {
            Canvas canvas = sCanvas;
            canvas.setBitmap(bitmap);
            canvas.save();
            canvas.drawColor(-1);
            canvas.scale(f, f);
            view.draw(canvas);
            canvas.restore();
            canvas.setBitmap(null);
        }
        return bitmap;
    }

    public static Bitmap createBitmapFromView(View view, int n, int n2, int n3, int n4) {
        Bitmap bitmap = QMUIDrawableHelper.createBitmapFromView(view);
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmap2 = QMUIDrawableHelper.createBitmapSafely(view.getWidth() - n3 - n, view.getHeight() - n2 - n4, Bitmap.Config.ARGB_8888, 1);
        if (bitmap2 == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap2);
        Rect rect = new Rect(n, n2, view.getWidth() - n3, view.getHeight() - n4);
        view = new Rect(0, 0, view.getWidth() - n3 - n, view.getHeight() - n2 - n4);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, rect, (Rect)view, null);
        bitmap.recycle();
        return bitmap2;
    }

    public static Bitmap createBitmapSafely(int n, int n2, Bitmap.Config config, int n3) {
        try {
            Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
            return bitmap;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
            if (n3 <= 0) return null;
            System.gc();
            return QMUIDrawableHelper.createBitmapSafely(n, n2, config, n3 - 1);
        }
    }

    public static GradientDrawable createCircleGradientDrawable(int n, int n2, int n3, float f, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{n, n2});
        gradientDrawable.setGradientType(1);
        gradientDrawable.setGradientRadius((float)n3);
        gradientDrawable.setGradientCenter(f, f2);
        return gradientDrawable;
    }

    public static BitmapDrawable createDrawableWithSize(Resources resources, int n, int n2, int n3, int n4) {
        Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        int n5 = n4;
        if (n4 == 0) {
            n5 = 0;
        }
        if (n3 > 0) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(n5);
            RectF rectF = new RectF(0.0f, 0.0f, (float)n, (float)n2);
            float f = n3;
            canvas.drawRoundRect(rectF, f, f, paint);
        } else {
            canvas.drawColor(n5);
        }
        return new BitmapDrawable(resources, bitmap);
    }

    public static LayerDrawable createItemSeparatorBg(int n, int n2, int n3, boolean bl) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(n);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable2.getPaint().setColor(n2);
        shapeDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, shapeDrawable2});
        n = bl ? n3 : 0;
        n2 = bl ? 0 : n3;
        shapeDrawable.setLayerInset(1, 0, n, 0, n2);
        return shapeDrawable;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        int n = drawable.getIntrinsicWidth();
        int n2 = drawable.getIntrinsicHeight();
        if (n <= 0) return null;
        if (n2 <= 0) return null;
        try {
            Bitmap.Config config = drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            config = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
            Canvas canvas = new Canvas((Bitmap)config);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return config;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
        }
        return null;
    }

    public static Drawable getVectorDrawable(Context context, int n) {
        try {
            Drawable drawable = AppCompatResources.getDrawable((Context)context, (int)n);
            return drawable;
        }
        catch (Exception exception) {
            String string = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error in getVectorDrawable. resVector=");
            stringBuilder.append(n);
            stringBuilder.append(", resName=");
            stringBuilder.append(context.getResources().getResourceName(n));
            stringBuilder.append(exception.getMessage());
            QMUILog.d((String)string, (String)stringBuilder.toString(), (Object[])new Object[0]);
            return null;
        }
    }

    public static ColorFilter setDrawableTintColor(Drawable drawable, int n) {
        LightingColorFilter lightingColorFilter = new LightingColorFilter(Color.argb((int)255, (int)0, (int)0, (int)0), n);
        if (drawable == null) return lightingColorFilter;
        drawable.setColorFilter((ColorFilter)lightingColorFilter);
        return lightingColorFilter;
    }

    public static Bitmap vectorDrawableToBitmap(Context context, int n) {
        if ((context = QMUIDrawableHelper.getVectorDrawable(context, n)) == null) return null;
        Bitmap bitmap = Bitmap.createBitmap((int)context.getIntrinsicWidth(), (int)context.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        context.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        context.draw(canvas);
        return bitmap;
    }
}
