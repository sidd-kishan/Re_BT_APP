/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.luck.picture.lib.photoview.Util$1
 */
package com.luck.picture.lib.photoview;

import android.widget.ImageView;
import com.luck.picture.lib.photoview.Util;

class Util {
    Util() {
    }

    static void checkZoomLevels(float f, float f2, float f3) {
        if (f >= f2) throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        if (f2 >= f3) throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }

    static int getPointerIndex(int n) {
        return (n & 0xFF00) >> 8;
    }

    static boolean hasDrawable(ImageView imageView) {
        boolean bl = imageView.getDrawable() != null;
        return bl;
    }

    static boolean isSupportedScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()] == 1) throw new IllegalStateException("Matrix scale type is not supported");
        return true;
    }
}
