/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.widget.ImageView
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

class ImageViewUtils {
    private static Field sDrawMatrixField;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    private ImageViewUtils() {
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static void animateTransform(ImageView imageView, Matrix matrix) {
        void var2_10;
        block11: {
            if (Build.VERSION.SDK_INT >= 29) {
                imageView.animateTransform(matrix);
                return;
            }
            if (matrix == null) {
                matrix = imageView.getDrawable();
                if (matrix == null) return;
                matrix.setBounds(0, 0, imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight(), imageView.getHeight() - imageView.getPaddingTop() - imageView.getPaddingBottom());
                imageView.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ImageViewUtils.hiddenAnimateTransform(imageView, matrix);
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) return;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            Object var2_3 = null;
            Matrix matrix2 = null;
            ImageViewUtils.fetchDrawMatrixField();
            Field field = sDrawMatrixField;
            if (field != null) {
                block10: {
                    Matrix matrix3 = matrix2;
                    field = (Matrix)field.get(imageView);
                    if (field != null) break block10;
                    try {
                        Matrix matrix4 = matrix2 = new Matrix();
                    }
                    catch (IllegalAccessException illegalAccessException) {}
                    try {
                        sDrawMatrixField.set(imageView, matrix2);
                        Matrix matrix5 = matrix2;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        // empty catch block
                    }
                    break block11;
                }
                Field field2 = field;
            }
        }
        if (var2_10 != null) {
            var2_10.set(matrix);
        }
        imageView.invalidate();
    }

    /*
     * Unable to fully structure code
     */
    private static void fetchDrawMatrixField() {
        if (ImageViewUtils.sDrawMatrixFieldFetched != false) return;
        try {
            ImageViewUtils.sDrawMatrixField = var0 = ImageView.class.getDeclaredField("mDrawMatrix");
            var0.setAccessible(true);
lbl5:
            // 2 sources

            while (true) {
                ImageViewUtils.sDrawMatrixFieldFetched = true;
                break;
            }
        }
        catch (NoSuchFieldException var0_1) {
            ** continue;
        }
    }

    private static void hiddenAnimateTransform(ImageView imageView, Matrix matrix) {
        if (!sTryHiddenAnimateTransform) return;
        try {
            imageView.animateTransform(matrix);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            sTryHiddenAnimateTransform = false;
        }
    }
}
