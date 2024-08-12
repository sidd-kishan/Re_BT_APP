/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraClosedException
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$CaptureFailedException
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureFailure
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.CameraClosedException;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class ImageCapture.8
extends CameraCaptureCallback {
    final ImageCapture this$0;
    final CallbackToFutureAdapter.Completer val$completer;

    ImageCapture.8(ImageCapture imageCapture, CallbackToFutureAdapter.Completer completer) {
        this.this$0 = imageCapture;
        this.val$completer = completer;
    }

    public void onCaptureCancelled() {
        this.val$completer.setException((Throwable)new CameraClosedException("Capture request is cancelled because camera is closed"));
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.val$completer.set(null);
    }

    public void onCaptureFailed(CameraCaptureFailure object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Capture request failed with reason ");
        stringBuilder.append(object.getReason());
        object = stringBuilder.toString();
        this.val$completer.setException((Throwable)new ImageCapture.CaptureFailedException((String)object));
    }
}
