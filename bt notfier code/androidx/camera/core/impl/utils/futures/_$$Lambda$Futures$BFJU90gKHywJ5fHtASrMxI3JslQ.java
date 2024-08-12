/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$Futures$BFJU90gKHywJ5fHtASrMxI3JslQ
implements CallbackToFutureAdapter.Resolver {
    private final ListenableFuture f$0;

    public /* synthetic */ _$$Lambda$Futures$BFJU90gKHywJ5fHtASrMxI3JslQ(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return Futures.lambda$nonCancellationPropagating$0((ListenableFuture)this.f$0, (CallbackToFutureAdapter.Completer)completer);
    }
}
