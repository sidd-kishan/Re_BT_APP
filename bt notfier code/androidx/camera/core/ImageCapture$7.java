/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraCaptureResult
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;

class ImageCapture.7
implements ImageCapture.CaptureCallbackChecker.CaptureResultChecker<Boolean> {
    final ImageCapture this$0;

    ImageCapture.7(ImageCapture imageCapture) {
        this.this$0 = imageCapture;
    }

    public Boolean check(CameraCaptureResult cameraCaptureResult) {
        if (Logger.isDebugEnabled((String)"ImageCapture")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkCaptureResult, AE=");
            stringBuilder.append(cameraCaptureResult.getAeState());
            stringBuilder.append(" AF =");
            stringBuilder.append(cameraCaptureResult.getAfState());
            stringBuilder.append(" AWB=");
            stringBuilder.append(cameraCaptureResult.getAwbState());
            Logger.d((String)"ImageCapture", (String)stringBuilder.toString());
        }
        if (!this.this$0.is3AConverged(cameraCaptureResult)) return null;
        return true;
    }
}
