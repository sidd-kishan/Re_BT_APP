/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureFailure
 *  androidx.camera.core.impl.CameraCaptureResult
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

static final class CameraCaptureCallbacks.NoOpCameraCaptureCallback
extends CameraCaptureCallback {
    CameraCaptureCallbacks.NoOpCameraCaptureCallback() {
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
    }
}
