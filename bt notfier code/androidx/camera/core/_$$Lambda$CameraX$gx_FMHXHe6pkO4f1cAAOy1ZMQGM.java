/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraX
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$CameraX$gx_FMHXHe6pkO4f1cAAOy1ZMQGM
implements Runnable {
    private final CameraX f$0;
    private final CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ _$$Lambda$CameraX$gx_FMHXHe6pkO4f1cAAOy1ZMQGM(CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = completer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$shutdownInternal$10$CameraX(this.f$1);
    }
}
