/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final class _$$Lambda$ImageCapture$ImageCaptureRequest$1G7WSvt8TANxhZtOyewefm68pg4
implements Runnable {
    private final ImageCapture.ImageCaptureRequest f$0;
    private final int f$1;
    private final String f$2;
    private final Throwable f$3;

    public /* synthetic */ _$$Lambda$ImageCapture$ImageCaptureRequest$1G7WSvt8TANxhZtOyewefm68pg4(ImageCapture.ImageCaptureRequest imageCaptureRequest, int n, String string, Throwable throwable) {
        this.f$0 = imageCaptureRequest;
        this.f$1 = n;
        this.f$2 = string;
        this.f$3 = throwable;
    }

    @Override
    public final void run() {
        this.f$0.lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(this.f$1, this.f$2, this.f$3);
    }
}
