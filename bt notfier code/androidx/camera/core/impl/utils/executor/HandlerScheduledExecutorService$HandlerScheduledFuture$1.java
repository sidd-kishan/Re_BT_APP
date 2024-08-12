/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;

class HandlerScheduledExecutorService.HandlerScheduledFuture.1
implements CallbackToFutureAdapter.Resolver<V> {
    final HandlerScheduledExecutorService.HandlerScheduledFuture this$0;
    final Handler val$handler;
    final Callable val$task;

    HandlerScheduledExecutorService.HandlerScheduledFuture.1(HandlerScheduledExecutorService.HandlerScheduledFuture handlerScheduledFuture, Handler handler, Callable callable) {
        this.this$0 = handlerScheduledFuture;
        this.val$handler = handler;
        this.val$task = callable;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer<V> object) throws RejectedExecutionException {
        object.addCancellationListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, CameraXExecutors.directExecutor());
        this.this$0.mCompleter.set(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("HandlerScheduledFuture-");
        ((StringBuilder)object).append(this.val$task.toString());
        return ((StringBuilder)object).toString();
    }
}
