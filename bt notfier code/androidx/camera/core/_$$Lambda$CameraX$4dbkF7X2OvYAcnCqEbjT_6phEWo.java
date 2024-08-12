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

public final class _$$Lambda$CameraX$4dbkF7X2OvYAcnCqEbjT_6phEWo
implements Runnable {
    private final CameraX f$0;
    private final CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ _$$Lambda$CameraX$4dbkF7X2OvYAcnCqEbjT_6phEWo(CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = completer;
    }

    @Override
    public final void run() {
        CameraX.lambda$shutdownLocked$4((CameraX)this.f$0, (CallbackToFutureAdapter.Completer)this.f$1);
    }
}
