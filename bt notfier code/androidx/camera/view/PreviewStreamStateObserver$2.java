/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.view.PreviewStreamStateObserver
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class PreviewStreamStateObserver.2
extends CameraCaptureCallback {
    final PreviewStreamStateObserver this$0;
    final CameraInfo val$cameraInfo;
    final CallbackToFutureAdapter.Completer val$completer;

    PreviewStreamStateObserver.2(PreviewStreamStateObserver previewStreamStateObserver, CallbackToFutureAdapter.Completer completer, CameraInfo cameraInfo) {
        this.this$0 = previewStreamStateObserver;
        this.val$completer = completer;
        this.val$cameraInfo = cameraInfo;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.val$completer.set(null);
        ((CameraInfoInternal)this.val$cameraInfo).removeSessionCaptureCallback((CameraCaptureCallback)this);
    }
}
