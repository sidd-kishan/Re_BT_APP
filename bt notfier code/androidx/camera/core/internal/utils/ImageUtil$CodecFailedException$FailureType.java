/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.internal.utils;

public static final class ImageUtil.CodecFailedException.FailureType
extends Enum<ImageUtil.CodecFailedException.FailureType> {
    private static final ImageUtil.CodecFailedException.FailureType[] $VALUES;
    public static final /* enum */ ImageUtil.CodecFailedException.FailureType DECODE_FAILED;
    public static final /* enum */ ImageUtil.CodecFailedException.FailureType ENCODE_FAILED;
    public static final /* enum */ ImageUtil.CodecFailedException.FailureType UNKNOWN;

    static {
        ImageUtil.CodecFailedException.FailureType failureType;
        ENCODE_FAILED = new ImageUtil.CodecFailedException.FailureType();
        DECODE_FAILED = new ImageUtil.CodecFailedException.FailureType();
        UNKNOWN = failureType = new ImageUtil.CodecFailedException.FailureType();
        $VALUES = new ImageUtil.CodecFailedException.FailureType[]{ENCODE_FAILED, DECODE_FAILED, failureType};
    }

    public static ImageUtil.CodecFailedException.FailureType valueOf(String string) {
        return Enum.valueOf(ImageUtil.CodecFailedException.FailureType.class, string);
    }

    public static ImageUtil.CodecFailedException.FailureType[] values() {
        return (ImageUtil.CodecFailedException.FailureType[])$VALUES.clone();
    }
}
