/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraState
 *  androidx.camera.core.ExposureState
 *  androidx.camera.core.ZoomState
 *  androidx.lifecycle.LiveData
 */
package androidx.camera.core;

import androidx.camera.core.CameraState;
import androidx.camera.core.ExposureState;
import androidx.camera.core.ZoomState;
import androidx.lifecycle.LiveData;

public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    public LiveData<CameraState> getCameraState();

    public ExposureState getExposureState();

    public String getImplementationType();

    public int getSensorRotationDegrees();

    public int getSensorRotationDegrees(int var1);

    public LiveData<Integer> getTorchState();

    public LiveData<ZoomState> getZoomState();

    public boolean hasFlashUnit();
}
