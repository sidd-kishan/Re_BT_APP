/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureFailure
 *  androidx.camera.core.impl.CameraCaptureResult
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

public abstract class CameraCaptureCallback {
    public void onCaptureCancelled() {
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
    }
}
