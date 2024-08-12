/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 */
package androidx.camera.core;

import android.graphics.Rect;
import androidx.camera.core.SurfaceRequest;

final class AutoValue_SurfaceRequest_TransformationInfo
extends SurfaceRequest.TransformationInfo {
    private final Rect cropRect;
    private final int rotationDegrees;
    private final int targetRotation;

    AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int n, int n2) {
        if (rect == null) throw new NullPointerException("Null cropRect");
        this.cropRect = rect;
        this.rotationDegrees = n;
        this.targetRotation = n2;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof SurfaceRequest.TransformationInfo)) return false;
        if (this.cropRect.equals((Object)(object = (SurfaceRequest.TransformationInfo)object).getCropRect()) && this.rotationDegrees == object.getRotationDegrees() && this.targetRotation == object.getTargetRotation()) return bl;
        bl = false;
        return bl;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int getTargetRotation() {
        return this.targetRotation;
    }

    public int hashCode() {
        return ((this.cropRect.hashCode() ^ 0xF4243) * 1000003 ^ this.rotationDegrees) * 1000003 ^ this.targetRotation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransformationInfo{cropRect=");
        stringBuilder.append(this.cropRect);
        stringBuilder.append(", rotationDegrees=");
        stringBuilder.append(this.rotationDegrees);
        stringBuilder.append(", targetRotation=");
        stringBuilder.append(this.targetRotation);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
