/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.AutoValue_CameraState_StateError
 *  androidx.camera.core.CameraState$ErrorType
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_CameraState_StateError;
import androidx.camera.core.CameraState;

public static abstract class CameraState.StateError {
    public static CameraState.StateError create(int n) {
        return CameraState.StateError.create(n, null);
    }

    public static CameraState.StateError create(int n, Throwable throwable) {
        return new AutoValue_CameraState_StateError(n, throwable);
    }

    public abstract Throwable getCause();

    public abstract int getCode();

    public CameraState.ErrorType getType() {
        int n = this.getCode();
        if (n == 2) return CameraState.ErrorType.RECOVERABLE;
        if (n == 1) return CameraState.ErrorType.RECOVERABLE;
        if (n != 3) return CameraState.ErrorType.CRITICAL;
        return CameraState.ErrorType.RECOVERABLE;
    }
}
