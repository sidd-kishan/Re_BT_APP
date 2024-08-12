/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraX
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$CameraX$mXdNm3KAyXgwNmVtH7yoqr2IRbE
implements CallbackToFutureAdapter.Resolver {
    private final CameraX f$0;

    public /* synthetic */ _$$Lambda$CameraX$mXdNm3KAyXgwNmVtH7yoqr2IRbE(CameraX cameraX) {
        this.f$0 = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$shutdownInternal$11$CameraX(completer);
    }
}
