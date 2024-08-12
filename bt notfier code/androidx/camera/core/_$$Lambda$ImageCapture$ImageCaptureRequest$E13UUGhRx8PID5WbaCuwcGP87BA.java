/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;

public final class _$$Lambda$ImageCapture$ImageCaptureRequest$E13UUGhRx8PID5WbaCuwcGP87BA
implements Runnable {
    private final ImageCapture.ImageCaptureRequest f$0;
    private final ImageProxy f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$ImageCaptureRequest$E13UUGhRx8PID5WbaCuwcGP87BA(ImageCapture.ImageCaptureRequest imageCaptureRequest, ImageProxy imageProxy) {
        this.f$0 = imageCaptureRequest;
        this.f$1 = imageProxy;
    }

    @Override
    public final void run() {
        this.f$0.lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(this.f$1);
    }
}
