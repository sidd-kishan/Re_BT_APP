/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class UseCaseConfigFactory.CaptureType
extends Enum<UseCaseConfigFactory.CaptureType> {
    private static final UseCaseConfigFactory.CaptureType[] $VALUES;
    public static final /* enum */ UseCaseConfigFactory.CaptureType IMAGE_ANALYSIS;
    public static final /* enum */ UseCaseConfigFactory.CaptureType IMAGE_CAPTURE;
    public static final /* enum */ UseCaseConfigFactory.CaptureType PREVIEW;
    public static final /* enum */ UseCaseConfigFactory.CaptureType VIDEO_CAPTURE;

    static {
        UseCaseConfigFactory.CaptureType captureType;
        IMAGE_CAPTURE = new UseCaseConfigFactory.CaptureType();
        PREVIEW = new UseCaseConfigFactory.CaptureType();
        IMAGE_ANALYSIS = new UseCaseConfigFactory.CaptureType();
        VIDEO_CAPTURE = captureType = new UseCaseConfigFactory.CaptureType();
        $VALUES = new UseCaseConfigFactory.CaptureType[]{IMAGE_CAPTURE, PREVIEW, IMAGE_ANALYSIS, captureType};
    }

    public static UseCaseConfigFactory.CaptureType valueOf(String string) {
        return Enum.valueOf(UseCaseConfigFactory.CaptureType.class, string);
    }

    public static UseCaseConfigFactory.CaptureType[] values() {
        return (UseCaseConfigFactory.CaptureType[])$VALUES.clone();
    }
}
