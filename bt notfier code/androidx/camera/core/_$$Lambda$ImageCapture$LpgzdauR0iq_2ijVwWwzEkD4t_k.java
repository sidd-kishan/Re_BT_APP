/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$TakePictureState
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageCapture$LpgzdauR0iq_2ijVwWwzEkD4t_k
implements CallbackToFutureAdapter.Resolver {
    private final ImageCapture f$0;
    private final ImageCapture.TakePictureState f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$LpgzdauR0iq_2ijVwWwzEkD4t_k(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$openTorch$15$ImageCapture(this.f$1, completer);
    }
}
