/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 */
package com.luck.picture.lib.photoview;

import android.widget.ImageView;

static class Util.1 {
    static final int[] $SwitchMap$android$widget$ImageView$ScaleType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageView.ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = nArray;
        try {
            nArray[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
