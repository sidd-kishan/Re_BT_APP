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
import java.util.concurrent.Executor;

public final class _$$Lambda$CameraX$xay7br8oqZ6q4uQ5PYsgeR_j580
implements Runnable {
    private final CameraX f$0;
    private final Executor f$1;
    private final long f$2;
    private final CallbackToFutureAdapter.Completer f$3;

    public /* synthetic */ _$$Lambda$CameraX$xay7br8oqZ6q4uQ5PYsgeR_j580(CameraX cameraX, Executor executor, long l, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = executor;
        this.f$2 = l;
        this.f$3 = completer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$initAndRetryRecursively$8$CameraX(this.f$1, this.f$2, this.f$3);
    }
}
