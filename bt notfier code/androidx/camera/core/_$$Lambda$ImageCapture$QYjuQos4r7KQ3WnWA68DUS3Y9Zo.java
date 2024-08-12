/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final class _$$Lambda$ImageCapture$QYjuQos4r7KQ3WnWA68DUS3Y9Zo
implements CallbackToFutureAdapter.Resolver {
    private final ImageCapture f$0;
    private final CaptureConfig.Builder f$1;
    private final List f$2;
    private final CaptureStage f$3;

    public /* synthetic */ _$$Lambda$ImageCapture$QYjuQos4r7KQ3WnWA68DUS3Y9Zo(ImageCapture imageCapture, CaptureConfig.Builder builder, List list, CaptureStage captureStage) {
        this.f$0 = imageCapture;
        this.f$1 = builder;
        this.f$2 = list;
        this.f$3 = captureStage;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$issueTakePicture$19$ImageCapture(this.f$1, this.f$2, this.f$3, completer);
    }
}
