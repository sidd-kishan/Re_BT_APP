/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$ImageCapture$s_1as3Eacj1lPWaU67XyHl9xer8
implements ImageCapture.ImageCaptureRequestProcessor.ImageCaptor {
    private final ImageCapture f$0;

    public /* synthetic */ _$$Lambda$ImageCapture$s_1as3Eacj1lPWaU67XyHl9xer8(ImageCapture imageCapture) {
        this.f$0 = imageCapture;
    }

    public final ListenableFuture capture(ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        return this.f$0.lambda$createPipeline$2$ImageCapture(imageCaptureRequest);
    }
}
