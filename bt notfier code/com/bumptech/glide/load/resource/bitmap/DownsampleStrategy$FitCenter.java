/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

private static class DownsampleStrategy.FitCenter
extends DownsampleStrategy {
    DownsampleStrategy.FitCenter() {
    }

    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int n, int n2, int n3, int n4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }

    public float getScaleFactor(int n, int n2, int n3, int n4) {
        return Math.min((float)n3 / (float)n, (float)n4 / (float)n2);
    }
}
