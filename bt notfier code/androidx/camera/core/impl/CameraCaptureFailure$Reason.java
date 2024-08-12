/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraCaptureFailure.Reason
extends Enum<CameraCaptureFailure.Reason> {
    private static final CameraCaptureFailure.Reason[] $VALUES;
    public static final /* enum */ CameraCaptureFailure.Reason ERROR;

    static {
        CameraCaptureFailure.Reason reason;
        ERROR = reason = new CameraCaptureFailure.Reason();
        $VALUES = new CameraCaptureFailure.Reason[]{reason};
    }

    public static CameraCaptureFailure.Reason valueOf(String string) {
        return Enum.valueOf(CameraCaptureFailure.Reason.class, string);
    }

    public static CameraCaptureFailure.Reason[] values() {
        return (CameraCaptureFailure.Reason[])$VALUES.clone();
    }
}
