/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraState
 *  androidx.camera.core.CameraState$StateError
 *  androidx.camera.core.CameraState$Type
 */
package androidx.camera.core;

import androidx.camera.core.CameraState;

final class AutoValue_CameraState
extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    AutoValue_CameraState(CameraState.Type type, CameraState.StateError stateError) {
        if (type == null) throw new NullPointerException("Null type");
        this.type = type;
        this.error = stateError;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof CameraState)) return false;
        CameraState cameraState = (CameraState)object;
        if (this.type.equals((Object)cameraState.getType()) && ((object = this.error) == null ? cameraState.getError() == null : object.equals(cameraState.getError()))) return bl;
        bl = false;
        return bl;
    }

    public CameraState.StateError getError() {
        return this.error;
    }

    public CameraState.Type getType() {
        return this.type;
    }

    public int hashCode() {
        int n = this.type.hashCode();
        CameraState.StateError stateError = this.error;
        int n2 = stateError == null ? 0 : stateError.hashCode();
        return (n ^ 0xF4243) * 1000003 ^ n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraState{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
