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

public final class _$$Lambda$DeferrableSurfaces$Yekn_mWFALhEwuFd18dTMaz7qws
implements Runnable {
    private final ListenableFuture f$0;
    private final CallbackToFutureAdapter.Completer f$1;
    private final long f$2;

    public /* synthetic */ _$$Lambda$DeferrableSurfaces$Yekn_mWFALhEwuFd18dTMaz7qws(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long l) {
        this.f$0 = listenableFuture;
        this.f$1 = completer;
        this.f$2 = l;
    }

    @Override
    public final void run() {
        DeferrableSurfaces.lambda$surfaceListWithTimeout$0((ListenableFuture)this.f$0, (CallbackToFutureAdapter.Completer)this.f$1, (long)this.f$2);
    }
}
