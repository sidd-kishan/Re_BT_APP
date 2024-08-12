/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraState$StateError
 */
package androidx.camera.core;

import androidx.camera.core.CameraState;

final class AutoValue_CameraState_StateError
extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    AutoValue_CameraState_StateError(int n, Throwable throwable) {
        this.code = n;
        this.cause = throwable;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof CameraState.StateError)) return false;
        CameraState.StateError stateError = (CameraState.StateError)object;
        if (this.code == stateError.getCode() && ((object = this.cause) == null ? stateError.getCause() == null : object.equals(stateError.getCause()))) return bl;
        bl = false;
        return bl;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int n = this.code;
        Throwable throwable = this.cause;
        int n2 = throwable == null ? 0 : throwable.hashCode();
        return (n ^ 0xF4243) * 1000003 ^ n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StateError{code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", cause=");
        stringBuilder.append(this.cause);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
