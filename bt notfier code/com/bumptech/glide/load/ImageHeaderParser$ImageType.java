/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

public static final class ImageHeaderParser.ImageType
extends Enum<ImageHeaderParser.ImageType> {
    private static final ImageHeaderParser.ImageType[] $VALUES;
    public static final /* enum */ ImageHeaderParser.ImageType GIF;
    public static final /* enum */ ImageHeaderParser.ImageType JPEG;
    public static final /* enum */ ImageHeaderParser.ImageType PNG;
    public static final /* enum */ ImageHeaderParser.ImageType PNG_A;
    public static final /* enum */ ImageHeaderParser.ImageType RAW;
    public static final /* enum */ ImageHeaderParser.ImageType UNKNOWN;
    public static final /* enum */ ImageHeaderParser.ImageType WEBP;
    public static final /* enum */ ImageHeaderParser.ImageType WEBP_A;
    private final boolean hasAlpha;

    static {
        ImageHeaderParser.ImageType imageType;
        GIF = new ImageHeaderParser.ImageType(true);
        JPEG = new ImageHeaderParser.ImageType(false);
        RAW = new ImageHeaderParser.ImageType(false);
        PNG_A = new ImageHeaderParser.ImageType(true);
        PNG = new ImageHeaderParser.ImageType(false);
        WEBP_A = new ImageHeaderParser.ImageType(true);
        WEBP = new ImageHeaderParser.ImageType(false);
        UNKNOWN = imageType = new ImageHeaderParser.ImageType(false);
        $VALUES = new ImageHeaderParser.ImageType[]{GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, imageType};
    }

    private ImageHeaderParser.ImageType(boolean bl) {
        this.hasAlpha = bl;
    }

    public static ImageHeaderParser.ImageType valueOf(String string) {
        return Enum.valueOf(ImageHeaderParser.ImageType.class, string);
    }

    public static ImageHeaderParser.ImageType[] values() {
        return (ImageHeaderParser.ImageType[])$VALUES.clone();
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}
