/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$AtLeast
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$AtMost
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$CenterInside
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$CenterOutside
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$FitCenter
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$None
 *  com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST;
    public static final DownsampleStrategy AT_MOST;
    public static final DownsampleStrategy CENTER_INSIDE;
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    public static final DownsampleStrategy FIT_CENTER;
    public static final DownsampleStrategy NONE;

    static {
        FIT_CENTER = new FitCenter();
        CENTER_OUTSIDE = new CenterOutside();
        AT_LEAST = new AtLeast();
        AT_MOST = new AtMost();
        CENTER_INSIDE = new CenterInside();
        NONE = new None();
        DEFAULT = CENTER_OUTSIDE;
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int var1, int var2, int var3, int var4);

    public abstract float getScaleFactor(int var1, int var2, int var3, int var4);
}
