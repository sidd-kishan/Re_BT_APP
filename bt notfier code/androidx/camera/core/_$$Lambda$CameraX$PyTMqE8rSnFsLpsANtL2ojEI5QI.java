/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.CameraX
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final class _$$Lambda$CameraX$PyTMqE8rSnFsLpsANtL2ojEI5QI
implements Runnable {
    private final CameraX f$0;
    private final Context f$1;
    private final Executor f$2;
    private final CallbackToFutureAdapter.Completer f$3;
    private final long f$4;

    public /* synthetic */ _$$Lambda$CameraX$PyTMqE8rSnFsLpsANtL2ojEI5QI(CameraX cameraX, Context context, Executor executor, CallbackToFutureAdapter.Completer completer, long l) {
        this.f$0 = cameraX;
        this.f$1 = context;
        this.f$2 = executor;
        this.f$3 = completer;
        this.f$4 = l;
    }

    @Override
    public final void run() {
        this.f$0.lambda$initAndRetryRecursively$9$CameraX(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
