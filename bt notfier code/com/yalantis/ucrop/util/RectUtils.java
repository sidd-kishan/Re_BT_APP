/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.yalantis.ucrop.util;

import android.graphics.RectF;

public class RectUtils {
    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] getCornersFromRect(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    public static float[] getRectSidesFromCorners(float[] fArray) {
        return new float[]{(float)Math.sqrt(Math.pow(fArray[0] - fArray[2], 2.0) + Math.pow(fArray[1] - fArray[3], 2.0)), (float)Math.sqrt(Math.pow(fArray[2] - fArray[4], 2.0) + Math.pow(fArray[3] - fArray[5], 2.0))};
    }

    public static RectF trapToRect(float[] fArray) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        int n = 1;
        while (true) {
            if (n >= fArray.length) {
                rectF.sort();
                return rectF;
            }
            float f = (float)Math.round(fArray[n - 1] * 10.0f) / 10.0f;
            float f2 = (float)Math.round(fArray[n] * 10.0f) / 10.0f;
            float f3 = f < rectF.left ? f : rectF.left;
            rectF.left = f3;
            f3 = f2 < rectF.top ? f2 : rectF.top;
            rectF.top = f3;
            if (!(f > rectF.right)) {
                f = rectF.right;
            }
            rectF.right = f;
            if (!(f2 > rectF.bottom)) {
                f2 = rectF.bottom;
            }
            rectF.bottom = f2;
            n += 2;
        }
    }
}
