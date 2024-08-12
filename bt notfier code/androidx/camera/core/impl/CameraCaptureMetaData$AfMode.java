/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureMetaData.AfMode
extends Enum<CameraCaptureMetaData.AfMode> {
    private static final CameraCaptureMetaData.AfMode[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData.AfMode OFF;
    public static final /* enum */ CameraCaptureMetaData.AfMode ON_CONTINUOUS_AUTO;
    public static final /* enum */ CameraCaptureMetaData.AfMode ON_MANUAL_AUTO;
    public static final /* enum */ CameraCaptureMetaData.AfMode UNKNOWN;

    static {
        CameraCaptureMetaData.AfMode afMode;
        UNKNOWN = new CameraCaptureMetaData.AfMode();
        OFF = new CameraCaptureMetaData.AfMode();
        ON_MANUAL_AUTO = new CameraCaptureMetaData.AfMode();
        ON_CONTINUOUS_AUTO = afMode = new CameraCaptureMetaData.AfMode();
        $VALUES = new CameraCaptureMetaData.AfMode[]{UNKNOWN, OFF, ON_MANUAL_AUTO, afMode};
    }

    public static CameraCaptureMetaData.AfMode valueOf(String string) {
        return Enum.valueOf(CameraCaptureMetaData.AfMode.class, string);
    }

    public static CameraCaptureMetaData.AfMode[] values() {
        return (CameraCaptureMetaData.AfMode[])$VALUES.clone();
    }
}
