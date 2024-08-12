/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

public final class DecodeFormat
extends Enum<DecodeFormat> {
    private static final DecodeFormat[] $VALUES;
    public static final DecodeFormat DEFAULT;
    public static final /* enum */ DecodeFormat PREFER_ARGB_8888;
    @Deprecated
    public static final /* enum */ DecodeFormat PREFER_ARGB_8888_DISALLOW_HARDWARE;
    public static final /* enum */ DecodeFormat PREFER_RGB_565;

    static {
        DecodeFormat decodeFormat;
        PREFER_ARGB_8888 = new DecodeFormat();
        PREFER_ARGB_8888_DISALLOW_HARDWARE = new DecodeFormat();
        PREFER_RGB_565 = decodeFormat = new DecodeFormat();
        DecodeFormat decodeFormat2 = PREFER_ARGB_8888;
        DecodeFormat decodeFormat3 = PREFER_ARGB_8888_DISALLOW_HARDWARE;
        $VALUES = new DecodeFormat[]{decodeFormat2, decodeFormat3, decodeFormat};
        DEFAULT = decodeFormat3;
    }

    public static DecodeFormat valueOf(String string) {
        return Enum.valueOf(DecodeFormat.class, string);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[])$VALUES.clone();
    }
}
