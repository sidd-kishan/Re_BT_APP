/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$RequestCancelledException
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;

class SurfaceRequest.3
implements FutureCallback<Surface> {
    final SurfaceRequest this$0;
    final CallbackToFutureAdapter.Completer val$sessionStatusCompleter;
    final String val$surfaceRequestString;
    final ListenableFuture val$terminationFuture;

    SurfaceRequest.3(SurfaceRequest surfaceRequest, ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, String string) {
        this.this$0 = surfaceRequest;
        this.val$terminationFuture = listenableFuture;
        this.val$sessionStatusCompleter = completer;
        this.val$surfaceRequestString = string;
    }

    public void onFailure(Throwable throwable) {
        if (throwable instanceof CancellationException) {
            CallbackToFutureAdapter.Completer completer = this.val$sessionStatusCompleter;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.val$surfaceRequestString);
            stringBuilder.append(" cancelled.");
            Preconditions.checkState((boolean)completer.setException((Throwable)new SurfaceRequest.RequestCancelledException(stringBuilder.toString(), throwable)));
        } else {
            this.val$sessionStatusCompleter.set(null);
        }
    }

    public void onSuccess(Surface surface) {
        Futures.propagate((ListenableFuture)this.val$terminationFuture, (CallbackToFutureAdapter.Completer)this.val$sessionStatusCompleter);
    }
}
