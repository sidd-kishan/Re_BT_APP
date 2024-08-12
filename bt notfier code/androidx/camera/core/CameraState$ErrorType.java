/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public static final class CameraState.ErrorType
extends Enum<CameraState.ErrorType> {
    private static final CameraState.ErrorType[] $VALUES;
    public static final /* enum */ CameraState.ErrorType CRITICAL;
    public static final /* enum */ CameraState.ErrorType RECOVERABLE;

    static {
        CameraState.ErrorType errorType;
        RECOVERABLE = new CameraState.ErrorType();
        CRITICAL = errorType = new CameraState.ErrorType();
        $VALUES = new CameraState.ErrorType[]{RECOVERABLE, errorType};
    }

    public static CameraState.ErrorType valueOf(String string) {
        return Enum.valueOf(CameraState.ErrorType.class, string);
    }

    public static CameraState.ErrorType[] values() {
        return (CameraState.ErrorType[])$VALUES.clone();
    }
}
