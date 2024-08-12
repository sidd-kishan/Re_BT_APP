/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageCapture$_MbcjLnO0JEbrFw7tB0q1uSNwrI
implements CallbackToFutureAdapter.Resolver {
    private final ImageCapture f$0;
    private final ImageCapture.ImageCaptureRequest f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$_MbcjLnO0JEbrFw7tB0q1uSNwrI(ImageCapture imageCapture, ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        this.f$0 = imageCapture;
        this.f$1 = imageCaptureRequest;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$takePictureInternal$10$ImageCapture(this.f$1, completer);
    }
}
