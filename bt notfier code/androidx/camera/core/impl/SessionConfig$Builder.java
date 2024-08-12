/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$BaseBuilder
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public static class SessionConfig.Builder
extends SessionConfig.BaseBuilder {
    public static SessionConfig.Builder createFrom(UseCaseConfig<?> useCaseConfig) {
        SessionConfig.OptionUnpacker optionUnpacker = useCaseConfig.getSessionOptionUnpacker(null);
        if (optionUnpacker != null) {
            SessionConfig.Builder builder = new SessionConfig.Builder();
            optionUnpacker.unpack(useCaseConfig, builder);
            return builder;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Implementation is missing option unpacker for ");
        stringBuilder.append(useCaseConfig.getTargetName(useCaseConfig.toString()));
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void addAllCameraCaptureCallbacks(Collection<CameraCaptureCallback> collection) {
        this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
        this.mSingleCameraCaptureCallbacks.addAll(collection);
    }

    public void addAllDeviceStateCallbacks(Collection<CameraDevice.StateCallback> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.addDeviceStateCallback((CameraDevice.StateCallback)object.next());
        }
    }

    public void addAllRepeatingCameraCaptureCallbacks(Collection<CameraCaptureCallback> collection) {
        this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
    }

    public void addAllSessionStateCallbacks(List<CameraCaptureSession.StateCallback> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.addSessionStateCallback((CameraCaptureSession.StateCallback)object.next());
        }
    }

    public void addCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
        this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
    }

    public void addDeviceStateCallback(CameraDevice.StateCallback stateCallback) {
        if (this.mDeviceStateCallbacks.contains(stateCallback)) throw new IllegalArgumentException("Duplicate device state callback.");
        this.mDeviceStateCallbacks.add(stateCallback);
    }

    public void addErrorListener(SessionConfig.ErrorListener errorListener) {
        this.mErrorListeners.add(errorListener);
    }

    public void addImplementationOptions(Config config) {
        this.mCaptureConfigBuilder.addImplementationOptions(config);
    }

    public void addNonRepeatingSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
    }

    public void addRepeatingCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
    }

    public void addSessionStateCallback(CameraCaptureSession.StateCallback stateCallback) {
        if (this.mSessionStateCallbacks.contains(stateCallback)) throw new IllegalArgumentException("Duplicate session state callback.");
        this.mSessionStateCallbacks.add(stateCallback);
    }

    public void addSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
        this.mCaptureConfigBuilder.addSurface(deferrableSurface);
    }

    public void addTag(String string, Integer n) {
        this.mCaptureConfigBuilder.addTag(string, n);
    }

    public SessionConfig build() {
        return new SessionConfig(new ArrayList(this.mSurfaces), this.mDeviceStateCallbacks, this.mSessionStateCallbacks, this.mSingleCameraCaptureCallbacks, this.mErrorListeners, this.mCaptureConfigBuilder.build());
    }

    public void clearSurfaces() {
        this.mSurfaces.clear();
        this.mCaptureConfigBuilder.clearSurfaces();
    }

    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
    }

    public void removeSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.remove(deferrableSurface);
        this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
    }

    public void setImplementationOptions(Config config) {
        this.mCaptureConfigBuilder.setImplementationOptions(config);
    }

    public void setTemplateType(int n) {
        this.mCaptureConfigBuilder.setTemplateType(n);
    }
}
