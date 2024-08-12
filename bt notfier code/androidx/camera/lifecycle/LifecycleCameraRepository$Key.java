/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraId
 *  androidx.camera.lifecycle.AutoValue_LifecycleCameraRepository_Key
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.AutoValue_LifecycleCameraRepository_Key;
import androidx.lifecycle.LifecycleOwner;

static abstract class LifecycleCameraRepository.Key {
    LifecycleCameraRepository.Key() {
    }

    static LifecycleCameraRepository.Key create(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        return new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraId);
    }

    public abstract CameraUseCaseAdapter.CameraId getCameraId();

    public abstract LifecycleOwner getLifecycleOwner();
}
