/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.internal.utils.ImageUtil
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class ViewPorts {
    private ViewPorts() {
    }

    public static Map<UseCase, Rect> calculateViewPortRects(Rect rect, boolean bl, Rational object, int n, int n2, int n3, Map<UseCase, Size> object2) {
        RectF rectF;
        Object object3;
        boolean bl2 = rect.width() > 0 && rect.height() > 0;
        Preconditions.checkArgument((boolean)bl2, (Object)"Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF2 = new RectF(rect);
        Object object4 = new HashMap();
        rect = new RectF(rect);
        for (Map.Entry entry : object2.entrySet()) {
            object3 = new Matrix();
            rectF = new RectF(0.0f, 0.0f, (float)((Size)entry.getValue()).getWidth(), (float)((Size)entry.getValue()).getHeight());
            object3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            object4.put((UseCase)entry.getKey(), object3);
            RectF entry2 = new RectF();
            object3.mapRect(entry2, rectF);
            rect.intersect(entry2);
        }
        rect = ViewPorts.getScaledRect((RectF)rect, ImageUtil.getRotatedAspectRatio((int)n, (Rational)object), n2, bl, n3, n);
        object = new HashMap();
        object2 = new RectF();
        rectF2 = new Matrix();
        object4 = object4.entrySet().iterator();
        while (object4.hasNext()) {
            object3 = (Map.Entry)object4.next();
            ((Matrix)object3.getValue()).invert((Matrix)rectF2);
            rectF2.mapRect(object2, (RectF)rect);
            rectF = new Rect();
            object2.round((Rect)rectF);
            object.put((UseCase)object3.getKey(), rectF);
        }
        return object;
    }

    private static RectF correctStartOrEnd(boolean bl, int n, RectF object, RectF rectF) {
        boolean bl2 = true;
        boolean bl3 = n == 0 && !bl;
        boolean bl4 = n == 90 && bl;
        if (bl3) return rectF;
        if (bl4) {
            return rectF;
        }
        bl3 = n == 0 && bl;
        bl4 = n == 270 && !bl;
        if (bl3) return ViewPorts.flipHorizontally(rectF, object.centerX());
        if (bl4) {
            return ViewPorts.flipHorizontally(rectF, object.centerX());
        }
        bl3 = n == 90 && !bl;
        bl4 = n == 180 && bl;
        if (bl3) return ViewPorts.flipVertically(rectF, object.centerY());
        if (bl4) {
            return ViewPorts.flipVertically(rectF, object.centerY());
        }
        bl3 = n == 180 && !bl;
        bl4 = n == 270 && bl ? bl2 : false;
        if (bl3) return ViewPorts.flipHorizontally(ViewPorts.flipVertically(rectF, object.centerY()), object.centerX());
        if (bl4) {
            return ViewPorts.flipHorizontally(ViewPorts.flipVertically(rectF, object.centerY()), object.centerX());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid argument: mirrored ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(" rotation ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        return new RectF(ViewPorts.flipX(rectF.right, f), rectF.top, ViewPorts.flipX(rectF.left, f), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f) {
        return new RectF(rectF.left, ViewPorts.flipY(rectF.bottom, f), rectF.right, ViewPorts.flipY(rectF.top, f));
    }

    private static float flipX(float f, float f2) {
        return f2 + f2 - f;
    }

    private static float flipY(float f, float f2) {
        return f2 + f2 - f;
    }

    public static RectF getScaledRect(RectF object, Rational rational, int n, boolean bl, int n2, int n3) {
        if (n == 3) {
            return object;
        }
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(0.0f, 0.0f, (float)rational.getNumerator(), (float)rational.getDenominator());
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unexpected scale type: ");
                    ((StringBuilder)object).append(n);
                    throw new IllegalStateException(((StringBuilder)object).toString());
                }
                matrix.setRectToRect(rectF, (RectF)object, Matrix.ScaleToFit.END);
            } else {
                matrix.setRectToRect(rectF, (RectF)object, Matrix.ScaleToFit.CENTER);
            }
        } else {
            matrix.setRectToRect(rectF, (RectF)object, Matrix.ScaleToFit.START);
        }
        rational = new RectF();
        matrix.mapRect((RectF)rational, rectF);
        return ViewPorts.correctStartOrEnd(ViewPorts.shouldMirrorStartAndEnd(bl, n2), n3, (RectF)object, (RectF)rational);
    }

    private static boolean shouldMirrorStartAndEnd(boolean bl, int n) {
        int n2 = 1;
        n = n == 1 ? n2 : 0;
        return (bl ^ n) != 0;
    }
}
