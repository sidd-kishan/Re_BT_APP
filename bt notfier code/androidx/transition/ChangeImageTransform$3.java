/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 */
package androidx.transition;

import android.widget.ImageView;

static class ChangeImageTransform.3 {
    static final int[] $SwitchMap$android$widget$ImageView$ScaleType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageView.ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = nArray;
        try {
            nArray[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ChangeImageTransform.3.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
