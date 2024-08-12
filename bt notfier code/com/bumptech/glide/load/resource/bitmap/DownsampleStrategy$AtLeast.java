/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

private static class DownsampleStrategy.AtLeast
extends DownsampleStrategy {
    DownsampleStrategy.AtLeast() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int n, int n2, int n3, int n4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }

    public float getScaleFactor(int n, int n2, int n3, int n4) {
        n = Math.min(n2 / n4, n / n3);
        float f = 1.0f;
        if (n == 0) return f;
        f = 1.0f / (float)Integer.highestOneBit(n);
        return f;
    }
}
