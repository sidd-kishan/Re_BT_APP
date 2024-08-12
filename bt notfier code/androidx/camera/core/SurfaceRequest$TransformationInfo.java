/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo
 */
package androidx.camera.core;

import android.graphics.Rect;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;

public static abstract class SurfaceRequest.TransformationInfo {
    SurfaceRequest.TransformationInfo() {
    }

    public static SurfaceRequest.TransformationInfo of(Rect rect, int n, int n2) {
        return new AutoValue_SurfaceRequest_TransformationInfo(rect, n, n2);
    }

    public abstract Rect getCropRect();

    public abstract int getRotationDegrees();

    public abstract int getTargetRotation();
}
