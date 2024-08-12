/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureMetaData.AfState
extends Enum<CameraCaptureMetaData.AfState> {
    private static final CameraCaptureMetaData.AfState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData.AfState FOCUSED;
    public static final /* enum */ CameraCaptureMetaData.AfState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData.AfState LOCKED_FOCUSED;
    public static final /* enum */ CameraCaptureMetaData.AfState LOCKED_NOT_FOCUSED;
    public static final /* enum */ CameraCaptureMetaData.AfState SCANNING;
    public static final /* enum */ CameraCaptureMetaData.AfState UNKNOWN;

    static {
        CameraCaptureMetaData.AfState afState;
        UNKNOWN = new CameraCaptureMetaData.AfState();
        INACTIVE = new CameraCaptureMetaData.AfState();
        SCANNING = new CameraCaptureMetaData.AfState();
        FOCUSED = new CameraCaptureMetaData.AfState();
        LOCKED_FOCUSED = new CameraCaptureMetaData.AfState();
        LOCKED_NOT_FOCUSED = afState = new CameraCaptureMetaData.AfState();
        $VALUES = new CameraCaptureMetaData.AfState[]{UNKNOWN, INACTIVE, SCANNING, FOCUSED, LOCKED_FOCUSED, afState};
    }

    public static CameraCaptureMetaData.AfState valueOf(String string) {
        return Enum.valueOf(CameraCaptureMetaData.AfState.class, string);
    }

    public static CameraCaptureMetaData.AfState[] values() {
        return (CameraCaptureMetaData.AfState[])$VALUES.clone();
    }
}
