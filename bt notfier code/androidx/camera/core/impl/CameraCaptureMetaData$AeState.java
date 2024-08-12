/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureMetaData.AeState
extends Enum<CameraCaptureMetaData.AeState> {
    private static final CameraCaptureMetaData.AeState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData.AeState CONVERGED;
    public static final /* enum */ CameraCaptureMetaData.AeState FLASH_REQUIRED;
    public static final /* enum */ CameraCaptureMetaData.AeState INACTIVE;
    public static final /* enum */ CameraCaptureMetaData.AeState LOCKED;
    public static final /* enum */ CameraCaptureMetaData.AeState SEARCHING;
    public static final /* enum */ CameraCaptureMetaData.AeState UNKNOWN;

    static {
        CameraCaptureMetaData.AeState aeState;
        UNKNOWN = new CameraCaptureMetaData.AeState();
        INACTIVE = new CameraCaptureMetaData.AeState();
        SEARCHING = new CameraCaptureMetaData.AeState();
        FLASH_REQUIRED = new CameraCaptureMetaData.AeState();
        CONVERGED = new CameraCaptureMetaData.AeState();
        LOCKED = aeState = new CameraCaptureMetaData.AeState();
        $VALUES = new CameraCaptureMetaData.AeState[]{UNKNOWN, INACTIVE, SEARCHING, FLASH_REQUIRED, CONVERGED, aeState};
    }

    public static CameraCaptureMetaData.AeState valueOf(String string) {
        return Enum.valueOf(CameraCaptureMetaData.AeState.class, string);
    }

    public static CameraCaptureMetaData.AeState[] values() {
        return (CameraCaptureMetaData.AeState[])$VALUES.clone();
    }
}
