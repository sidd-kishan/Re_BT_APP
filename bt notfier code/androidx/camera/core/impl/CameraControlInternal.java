/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.Config
 */
package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public interface CameraControlInternal
extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new /* Unavailable Anonymous Inner Class!! */;

    public void addInteropConfig(Config var1);

    public void cancelAfAeTrigger(boolean var1, boolean var2);

    public void clearInteropConfig();

    public int getFlashMode();

    public Config getInteropConfig();

    public Rect getSensorRect();

    public ListenableFuture<Integer> setExposureCompensationIndex(int var1);

    public void setFlashMode(int var1);

    public void submitCaptureRequests(List<CaptureConfig> var1);

    public ListenableFuture<CameraCaptureResult> triggerAePrecapture();

    public ListenableFuture<CameraCaptureResult> triggerAf();
}
