/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 *  com.bumptech.glide.Priority
 */
package com.bumptech.glide;

import android.widget.ImageView;
import com.bumptech.glide.Priority;

static class RequestBuilder.2 {
    static final int[] $SwitchMap$android$widget$ImageView$ScaleType;
    static final int[] $SwitchMap$com$bumptech$glide$Priority;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Priority.values().length];
        $SwitchMap$com$bumptech$glide$Priority = nArray;
        try {
            nArray[Priority.LOW.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$com$bumptech$glide$Priority[Priority.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$com$bumptech$glide$Priority[Priority.HIGH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$com$bumptech$glide$Priority[Priority.IMMEDIATE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[ImageView.ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = nArray;
        try {
            nArray[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RequestBuilder.2.$SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
