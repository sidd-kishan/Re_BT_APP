/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.resource.bitmap;

public static final class DownsampleStrategy.SampleSizeRounding
extends Enum<DownsampleStrategy.SampleSizeRounding> {
    private static final DownsampleStrategy.SampleSizeRounding[] $VALUES;
    public static final /* enum */ DownsampleStrategy.SampleSizeRounding MEMORY;
    public static final /* enum */ DownsampleStrategy.SampleSizeRounding QUALITY;

    static {
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding;
        MEMORY = new DownsampleStrategy.SampleSizeRounding();
        QUALITY = sampleSizeRounding = new DownsampleStrategy.SampleSizeRounding();
        $VALUES = new DownsampleStrategy.SampleSizeRounding[]{MEMORY, sampleSizeRounding};
    }

    public static DownsampleStrategy.SampleSizeRounding valueOf(String string) {
        return Enum.valueOf(DownsampleStrategy.SampleSizeRounding.class, string);
    }

    public static DownsampleStrategy.SampleSizeRounding[] values() {
        return (DownsampleStrategy.SampleSizeRounding[])$VALUES.clone();
    }
}
