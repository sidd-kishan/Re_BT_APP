/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.FocusMeteringAction
 *  androidx.camera.core.FocusMeteringResult
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import com.google.common.util.concurrent.ListenableFuture;

public interface CameraControl {
    public ListenableFuture<Void> cancelFocusAndMetering();

    public ListenableFuture<Void> enableTorch(boolean var1);

    public ListenableFuture<Integer> setExposureCompensationIndex(int var1);

    public ListenableFuture<Void> setLinearZoom(float var1);

    public ListenableFuture<Void> setZoomRatio(float var1);

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction var1);
}
