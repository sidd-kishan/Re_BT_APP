/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.Executor;

public final class _$$Lambda$ImageCapture$ZwpMLqCr2U9t8PY1QTzAwfLPaTE
implements Runnable {
    private final ImageCapture f$0;
    private final Executor f$1;
    private final ImageCapture.OnImageCapturedCallback f$2;

    public /* synthetic */ _$$Lambda$ImageCapture$ZwpMLqCr2U9t8PY1QTzAwfLPaTE(ImageCapture imageCapture, Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.f$0 = imageCapture;
        this.f$1 = executor;
        this.f$2 = onImageCapturedCallback;
    }

    @Override
    public final void run() {
        this.f$0.lambda$takePicture$4$ImageCapture(this.f$1, this.f$2);
    }
}
