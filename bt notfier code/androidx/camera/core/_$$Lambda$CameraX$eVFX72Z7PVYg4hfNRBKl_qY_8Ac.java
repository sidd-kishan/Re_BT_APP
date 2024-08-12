/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.CameraX
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$CameraX$eVFX72Z7PVYg4hfNRBKl_qY_8Ac
implements CallbackToFutureAdapter.Resolver {
    private final CameraX f$0;
    private final Context f$1;

    public /* synthetic */ _$$Lambda$CameraX$eVFX72Z7PVYg4hfNRBKl_qY_8Ac(CameraX cameraX, Context context) {
        this.f$0 = cameraX;
        this.f$1 = context;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$initInternal$7$CameraX(this.f$1, completer);
    }
}
