/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

static class SizeConfigStrategy.1 {
    static final int[] $SwitchMap$android$graphics$Bitmap$Config;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[Bitmap.Config.values().length];
        $SwitchMap$android$graphics$Bitmap$Config = nArray;
        try {
            nArray[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
