/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 */
package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SessionConfig {
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final List<ErrorListener> mErrorListeners;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;
    private final List<DeferrableSurface> mSurfaces;

    SessionConfig(List<DeferrableSurface> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, List<ErrorListener> list5, CaptureConfig captureConfig) {
        this.mSurfaces = list;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(list4);
        this.mErrorListeners = Collections.unmodifiableList(list5);
        this.mRepeatingCaptureConfig = captureConfig;
    }

    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList<DeferrableSurface>(), new ArrayList<CameraDevice.StateCallback>(0), new ArrayList<CameraCaptureSession.StateCallback>(0), new ArrayList<CameraCaptureCallback>(0), new ArrayList<ErrorListener>(0), new CaptureConfig.Builder().build());
    }

    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    public List<ErrorListener> getErrorListeners() {
        return this.mErrorListeners;
    }

    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}
