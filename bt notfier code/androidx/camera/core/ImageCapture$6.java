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

class ImageCapture.6
implements ImageCapture.CaptureCallbackChecker.CaptureResultChecker<CameraCaptureResult> {
    final ImageCapture this$0;

    ImageCapture.6(ImageCapture imageCapture) {
        this.this$0 = imageCapture;
    }

    public CameraCaptureResult check(CameraCaptureResult cameraCaptureResult) {
        if (!Logger.isDebugEnabled((String)"ImageCapture")) return cameraCaptureResult;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preCaptureState, AE=");
        stringBuilder.append(cameraCaptureResult.getAeState());
        stringBuilder.append(" AF =");
        stringBuilder.append(cameraCaptureResult.getAfState());
        stringBuilder.append(" AWB=");
        stringBuilder.append(cameraCaptureResult.getAwbState());
        Logger.d((String)"ImageCapture", (String)stringBuilder.toString());
        return cameraCaptureResult;
    }
}
