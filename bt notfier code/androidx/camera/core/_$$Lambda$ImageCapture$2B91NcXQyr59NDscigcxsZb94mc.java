/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final class _$$Lambda$ImageCapture$2B91NcXQyr59NDscigcxsZb94mc
implements Runnable {
    private final ImageCapture f$0;
    private final ImageCapture.OnImageCapturedCallback f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$2B91NcXQyr59NDscigcxsZb94mc(ImageCapture imageCapture, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.f$0 = imageCapture;
        this.f$1 = onImageCapturedCallback;
    }

    @Override
    public final void run() {
        this.f$0.lambda$sendImageCaptureRequest$6$ImageCapture(this.f$1);
    }
}
