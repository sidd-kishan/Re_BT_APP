/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.AutoValue_CameraState
 *  androidx.camera.core.CameraState$StateError
 *  androidx.camera.core.CameraState$Type
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_CameraState;
import androidx.camera.core.CameraState;

public abstract class CameraState {
    public static final int ERROR_CAMERA_DISABLED = 5;
    public static final int ERROR_CAMERA_FATAL_ERROR = 6;
    public static final int ERROR_CAMERA_IN_USE = 2;
    public static final int ERROR_DO_NOT_DISTURB_MODE_ENABLED = 7;
    public static final int ERROR_MAX_CAMERAS_IN_USE = 1;
    public static final int ERROR_OTHER_RECOVERABLE_ERROR = 3;
    public static final int ERROR_STREAM_CONFIG = 4;

    public static CameraState create(Type type) {
        return CameraState.create(type, null);
    }

    public static CameraState create(Type type, StateError stateError) {
        return new AutoValue_CameraState(type, stateError);
    }

    public abstract StateError getError();

    public abstract Type getType();
}
