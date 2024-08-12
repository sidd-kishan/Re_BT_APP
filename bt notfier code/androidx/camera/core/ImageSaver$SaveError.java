/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public static final class ImageSaver.SaveError
extends Enum<ImageSaver.SaveError> {
    private static final ImageSaver.SaveError[] $VALUES;
    public static final /* enum */ ImageSaver.SaveError CROP_FAILED;
    public static final /* enum */ ImageSaver.SaveError ENCODE_FAILED;
    public static final /* enum */ ImageSaver.SaveError FILE_IO_FAILED;
    public static final /* enum */ ImageSaver.SaveError UNKNOWN;

    static {
        ImageSaver.SaveError saveError;
        FILE_IO_FAILED = new ImageSaver.SaveError();
        ENCODE_FAILED = new ImageSaver.SaveError();
        CROP_FAILED = new ImageSaver.SaveError();
        UNKNOWN = saveError = new ImageSaver.SaveError();
        $VALUES = new ImageSaver.SaveError[]{FILE_IO_FAILED, ENCODE_FAILED, CROP_FAILED, saveError};
    }

    public static ImageSaver.SaveError valueOf(String string) {
        return Enum.valueOf(ImageSaver.SaveError.class, string);
    }

    public static ImageSaver.SaveError[] values() {
        return (ImageSaver.SaveError[])$VALUES.clone();
    }
}
