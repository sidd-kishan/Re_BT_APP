/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureMetaData.AwbState
extends Enum<CameraCaptureMetaData.AwbState> {
    private static final CameraCaptureMetaData.AwbState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData.AwbState CONVERGED;
    public static final /* enum */ CameraCaptureMetaData.AwbState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData.AwbState LOCKED;
    public static final /* enum */ CameraCaptureMetaData.AwbState METERING;
    public static final /* enum */ CameraCaptureMetaData.AwbState UNKNOWN;

    static {
        CameraCaptureMetaData.AwbState awbState;
        UNKNOWN = new CameraCaptureMetaData.AwbState();
        INACTIVE = new CameraCaptureMetaData.AwbState();
        METERING = new CameraCaptureMetaData.AwbState();
        CONVERGED = new CameraCaptureMetaData.AwbState();
        LOCKED = awbState = new CameraCaptureMetaData.AwbState();
        $VALUES = new CameraCaptureMetaData.AwbState[]{UNKNOWN, INACTIVE, METERING, CONVERGED, awbState};
    }

    public static CameraCaptureMetaData.AwbState valueOf(String string) {
        return Enum.valueOf(CameraCaptureMetaData.AwbState.class, string);
    }

    public static CameraCaptureMetaData.AwbState[] values() {
        return (CameraCaptureMetaData.AwbState[])$VALUES.clone();
    }
}
