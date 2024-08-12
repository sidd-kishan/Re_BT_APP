/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.impl.LensFacingCameraFilter
 */
package androidx.camera.core;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.LensFacingCameraFilter;
import java.util.LinkedHashSet;

public static final class CameraSelector.Builder {
    private final LinkedHashSet<CameraFilter> mCameraFilterSet;

    public CameraSelector.Builder() {
        this.mCameraFilterSet = new LinkedHashSet();
    }

    private CameraSelector.Builder(LinkedHashSet<CameraFilter> linkedHashSet) {
        this.mCameraFilterSet = new LinkedHashSet<CameraFilter>(linkedHashSet);
    }

    public static CameraSelector.Builder fromSelector(CameraSelector cameraSelector) {
        return new CameraSelector.Builder(cameraSelector.getCameraFilterSet());
    }

    public CameraSelector.Builder addCameraFilter(CameraFilter cameraFilter) {
        this.mCameraFilterSet.add(cameraFilter);
        return this;
    }

    public CameraSelector build() {
        return new CameraSelector(this.mCameraFilterSet);
    }

    public CameraSelector.Builder requireLensFacing(int n) {
        this.mCameraFilterSet.add((CameraFilter)new LensFacingCameraFilter(n));
        return this;
    }
}
