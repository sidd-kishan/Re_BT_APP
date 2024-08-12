/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurfaces
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class _$$Lambda$DeferrableSurfaces$1M8fKlBzTzms6mhVK_pmWAC05CU
implements Runnable {
    private final Executor f$0;
    private final ListenableFuture f$1;
    private final CallbackToFutureAdapter.Completer f$2;
    private final long f$3;

    public /* synthetic */ _$$Lambda$DeferrableSurfaces$1M8fKlBzTzms6mhVK_pmWAC05CU(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long l) {
        this.f$0 = executor;
        this.f$1 = listenableFuture;
        this.f$2 = completer;
        this.f$3 = l;
    }

    @Override
    public final void run() {
        DeferrableSurfaces.lambda$surfaceListWithTimeout$1((Executor)this.f$0, (ListenableFuture)this.f$1, (CallbackToFutureAdapter.Completer)this.f$2, (long)this.f$3);
    }
}
