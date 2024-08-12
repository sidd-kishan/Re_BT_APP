/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraId
 *  androidx.camera.lifecycle.LifecycleCameraRepository$Key
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.LifecycleOwner;

final class AutoValue_LifecycleCameraRepository_Key
extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        if (lifecycleOwner == null) throw new NullPointerException("Null lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        if (cameraId == null) throw new NullPointerException("Null cameraId");
        this.cameraId = cameraId;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof LifecycleCameraRepository.Key)) return false;
        if (this.lifecycleOwner.equals((object = (LifecycleCameraRepository.Key)object).getLifecycleOwner()) && this.cameraId.equals((Object)object.getCameraId())) return bl;
        bl = false;
        return bl;
    }

    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        return (this.lifecycleOwner.hashCode() ^ 0xF4243) * 1000003 ^ this.cameraId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key{lifecycleOwner=");
        stringBuilder.append(this.lifecycleOwner);
        stringBuilder.append(", cameraId=");
        stringBuilder.append(this.cameraId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
