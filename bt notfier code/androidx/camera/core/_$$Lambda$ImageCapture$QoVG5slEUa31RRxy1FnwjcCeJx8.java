/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$ImageCapture$QoVG5slEUa31RRxy1FnwjcCeJx8
implements AsyncFunction {
    private final ImageCapture f$0;
    private final ImageCapture.ImageCaptureRequest f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$QoVG5slEUa31RRxy1FnwjcCeJx8(ImageCapture imageCapture, ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        this.f$0 = imageCapture;
        this.f$1 = imageCaptureRequest;
    }

    public final ListenableFuture apply(Object object) {
        return this.f$0.lambda$takePictureInternal$8$ImageCapture(this.f$1, (Void)object);
    }
}
