/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 */
package com.luck.picture.lib.photoview;

import android.widget.ImageView;

static class PhotoViewAttacher.4 {
    static final int[] $SwitchMap$android$widget$ImageView$ScaleType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageView.ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = nArray;
        try {
            nArray[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PhotoViewAttacher.4.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
