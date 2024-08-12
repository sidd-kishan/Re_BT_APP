/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 */
package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

static class SessionConfig.BaseBuilder {
    final CaptureConfig.Builder mCaptureConfigBuilder;
    final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    final List<SessionConfig.ErrorListener> mErrorListeners;
    final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;
    final Set<DeferrableSurface> mSurfaces = new HashSet<DeferrableSurface>();

    SessionConfig.BaseBuilder() {
        this.mCaptureConfigBuilder = new CaptureConfig.Builder();
        this.mDeviceStateCallbacks = new ArrayList<CameraDevice.StateCallback>();
        this.mSessionStateCallbacks = new ArrayList<CameraCaptureSession.StateCallback>();
        this.mErrorListeners = new ArrayList<SessionConfig.ErrorListener>();
        this.mSingleCameraCaptureCallbacks = new ArrayList<CameraCaptureCallback>();
    }
}
