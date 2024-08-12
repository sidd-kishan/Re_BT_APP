/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$RequestCancelledException
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

class SurfaceRequest.1
implements FutureCallback<Void> {
    final SurfaceRequest this$0;
    final CallbackToFutureAdapter.Completer val$requestCancellationCompleter;
    final ListenableFuture val$requestCancellationFuture;

    SurfaceRequest.1(SurfaceRequest surfaceRequest, CallbackToFutureAdapter.Completer completer, ListenableFuture listenableFuture) {
        this.this$0 = surfaceRequest;
        this.val$requestCancellationCompleter = completer;
        this.val$requestCancellationFuture = listenableFuture;
    }

    public void onFailure(Throwable throwable) {
        if (throwable instanceof SurfaceRequest.RequestCancelledException) {
            Preconditions.checkState((boolean)this.val$requestCancellationFuture.cancel(false));
        } else {
            Preconditions.checkState((boolean)this.val$requestCancellationCompleter.set(null));
        }
    }

    public void onSuccess(Void void_) {
        Preconditions.checkState((boolean)this.val$requestCancellationCompleter.set(null));
    }
}
