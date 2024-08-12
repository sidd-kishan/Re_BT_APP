/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageCapture$CaptureCallbackChecker$RVxDy_zAdeqk9wi1C8KZybyVmF8
implements CallbackToFutureAdapter.Resolver {
    private final ImageCapture.CaptureCallbackChecker f$0;
    private final ImageCapture.CaptureCallbackChecker.CaptureResultChecker f$1;
    private final long f$2;
    private final long f$3;
    private final Object f$4;

    public /* synthetic */ _$$Lambda$ImageCapture$CaptureCallbackChecker$RVxDy_zAdeqk9wi1C8KZybyVmF8(ImageCapture.CaptureCallbackChecker captureCallbackChecker, ImageCapture.CaptureCallbackChecker.CaptureResultChecker captureResultChecker, long l, long l2, Object object) {
        this.f$0 = captureCallbackChecker;
        this.f$1 = captureResultChecker;
        this.f$2 = l;
        this.f$3 = l2;
        this.f$4 = object;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(this.f$1, this.f$2, this.f$3, this.f$4, completer);
    }
}
