/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.Executor;

public final class _$$Lambda$ImageCapture$2_TxPNzHOcVqstis6XB6DYcuHfk
implements Runnable {
    private final ImageCapture f$0;
    private final ImageCapture.OutputFileOptions f$1;
    private final Executor f$2;
    private final ImageCapture.OnImageSavedCallback f$3;

    public /* synthetic */ _$$Lambda$ImageCapture$2_TxPNzHOcVqstis6XB6DYcuHfk(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.f$0 = imageCapture;
        this.f$1 = outputFileOptions;
        this.f$2 = executor;
        this.f$3 = onImageSavedCallback;
    }

    @Override
    public final void run() {
        this.f$0.lambda$takePicture$5$ImageCapture(this.f$1, this.f$2, this.f$3);
    }
}
