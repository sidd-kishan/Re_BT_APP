/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.DisplayMetrics
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator$ScreenDimensions
 */
package com.bumptech.glide.load.engine.cache;

import android.util.DisplayMetrics;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;

private static final class MemorySizeCalculator.DisplayMetricsScreenDimensions
implements MemorySizeCalculator.ScreenDimensions {
    private final DisplayMetrics displayMetrics;

    MemorySizeCalculator.DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    public int getHeightPixels() {
        return this.displayMetrics.heightPixels;
    }

    public int getWidthPixels() {
        return this.displayMetrics.widthPixels;
    }
}
