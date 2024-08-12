/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureMetaData.FlashState
extends Enum<CameraCaptureMetaData.FlashState> {
    private static final CameraCaptureMetaData.FlashState[] $VALUES;
    public static final /* enum */ CameraCaptureMetaData.FlashState FIRED;
    public static final /* enum */ CameraCaptureMetaData.FlashState NONE;
    public static final /* enum */ CameraCaptureMetaData.FlashState READY;
    public static final /* enum */ CameraCaptureMetaData.FlashState UNKNOWN;

    static {
        CameraCaptureMetaData.FlashState flashState;
        UNKNOWN = new CameraCaptureMetaData.FlashState();
        NONE = new CameraCaptureMetaData.FlashState();
        READY = new CameraCaptureMetaData.FlashState();
        FIRED = flashState = new CameraCaptureMetaData.FlashState();
        $VALUES = new CameraCaptureMetaData.FlashState[]{UNKNOWN, NONE, READY, flashState};
    }

    public static CameraCaptureMetaData.FlashState valueOf(String string) {
        return Enum.valueOf(CameraCaptureMetaData.FlashState.class, string);
    }

    public static CameraCaptureMetaData.FlashState[] values() {
        return (CameraCaptureMetaData.FlashState[])$VALUES.clone();
    }
}
