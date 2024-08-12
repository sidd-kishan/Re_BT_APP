/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.camera.core.FocusMeteringAction
 *  androidx.camera.core.FocusMeteringResult
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CameraCaptureResult$EmptyCameraCaptureResult
 *  androidx.camera.core.impl.CameraControlInternal
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

class CameraControlInternal.1
implements CameraControlInternal {
    CameraControlInternal.1() {
    }

    public void addInteropConfig(Config config) {
    }

    public void cancelAfAeTrigger(boolean bl, boolean bl2) {
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        return Futures.immediateFuture(null);
    }

    public void clearInteropConfig() {
    }

    public ListenableFuture<Void> enableTorch(boolean bl) {
        return Futures.immediateFuture(null);
    }

    public int getFlashMode() {
        return 2;
    }

    public Config getInteropConfig() {
        return null;
    }

    public Rect getSensorRect() {
        return new Rect();
    }

    public ListenableFuture<Integer> setExposureCompensationIndex(int n) {
        return Futures.immediateFuture((Object)0);
    }

    public void setFlashMode(int n) {
    }

    public ListenableFuture<Void> setLinearZoom(float f) {
        return Futures.immediateFuture(null);
    }

    public ListenableFuture<Void> setZoomRatio(float f) {
        return Futures.immediateFuture(null);
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return Futures.immediateFuture((Object)FocusMeteringResult.emptyInstance());
    }

    public void submitCaptureRequests(List<CaptureConfig> list) {
    }

    public ListenableFuture<CameraCaptureResult> triggerAePrecapture() {
        return Futures.immediateFuture((Object)CameraCaptureResult.EmptyCameraCaptureResult.create());
    }

    public ListenableFuture<CameraCaptureResult> triggerAf() {
        return Futures.immediateFuture((Object)CameraCaptureResult.EmptyCameraCaptureResult.create());
    }
}
