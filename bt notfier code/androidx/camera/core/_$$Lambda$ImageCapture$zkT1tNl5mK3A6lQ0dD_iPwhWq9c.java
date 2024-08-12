/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageCapture$zkT1tNl5mK3A6lQ0dD_iPwhWq9c
implements ImageReaderProxy.OnImageAvailableListener {
    private final CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ _$$Lambda$ImageCapture$zkT1tNl5mK3A6lQ0dD_iPwhWq9c(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageCapture.lambda$takePictureInternal$7((CallbackToFutureAdapter.Completer)this.f$0, (ImageReaderProxy)imageReaderProxy);
    }
}
