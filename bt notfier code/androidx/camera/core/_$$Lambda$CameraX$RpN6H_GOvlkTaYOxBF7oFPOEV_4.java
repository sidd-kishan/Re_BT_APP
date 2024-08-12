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

public final class _$$Lambda$CameraX$RpN6H_GOvlkTaYOxBF7oFPOEV_4
implements CallbackToFutureAdapter.Resolver {
    private final CameraX f$0;

    public /* synthetic */ _$$Lambda$CameraX$RpN6H_GOvlkTaYOxBF7oFPOEV_4(CameraX cameraX) {
        this.f$0 = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CameraX.lambda$shutdownLocked$5((CameraX)this.f$0, (CallbackToFutureAdapter.Completer)completer);
    }
}
