/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

private static class DownsampleStrategy.AtMost
extends DownsampleStrategy {
    DownsampleStrategy.AtMost() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int n, int n2, int n3, int n4) {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    public float getScaleFactor(int n, int n2, int n3, int n4) {
        n3 = (int)Math.ceil(Math.max((float)n2 / (float)n4, (float)n / (float)n3));
        n2 = Integer.highestOneBit(n3);
        n = 1;
        if ((n2 = Math.max(1, n2)) < n3) return 1.0f / (float)(n2 << n);
        n = 0;
        return 1.0f / (float)(n2 << n);
    }
}
