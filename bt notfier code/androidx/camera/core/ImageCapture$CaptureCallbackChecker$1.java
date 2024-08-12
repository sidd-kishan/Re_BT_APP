/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultListener
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import android.os.SystemClock;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class ImageCapture.CaptureCallbackChecker.1
implements ImageCapture.CaptureCallbackChecker.CaptureResultListener {
    final ImageCapture.CaptureCallbackChecker this$0;
    final ImageCapture.CaptureCallbackChecker.CaptureResultChecker val$checker;
    final CallbackToFutureAdapter.Completer val$completer;
    final Object val$defValue;
    final long val$startTimeInMs;
    final long val$timeoutInMs;

    ImageCapture.CaptureCallbackChecker.1(ImageCapture.CaptureCallbackChecker captureCallbackChecker, ImageCapture.CaptureCallbackChecker.CaptureResultChecker captureResultChecker, CallbackToFutureAdapter.Completer completer, long l, long l2, Object object) {
        this.this$0 = captureCallbackChecker;
        this.val$checker = captureResultChecker;
        this.val$completer = completer;
        this.val$startTimeInMs = l;
        this.val$timeoutInMs = l2;
        this.val$defValue = object;
    }

    public boolean onCaptureResult(CameraCaptureResult object) {
        if ((object = this.val$checker.check(object)) != null) {
            this.val$completer.set(object);
            return true;
        }
        if (this.val$startTimeInMs <= 0L) return false;
        if (SystemClock.elapsedRealtime() - this.val$startTimeInMs <= this.val$timeoutInMs) return false;
        this.val$completer.set(this.val$defValue);
        return true;
    }
}
