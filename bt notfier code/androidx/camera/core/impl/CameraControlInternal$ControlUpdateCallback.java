/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.SessionConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

public static interface CameraControlInternal.ControlUpdateCallback {
    public void onCameraControlCaptureRequests(List<CaptureConfig> var1);

    public void onCameraControlUpdateSessionConfig(SessionConfig var1);
}
