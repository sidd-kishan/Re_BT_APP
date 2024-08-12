/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

private static final class CallbackToFutureAdapter.SafeFuture<T>
implements ListenableFuture<T> {
    final WeakReference<CallbackToFutureAdapter.Completer<T>> completerWeakReference;
    private final AbstractResolvableFuture<T> delegate = new /* Unavailable Anonymous Inner Class!! */;

    CallbackToFutureAdapter.SafeFuture(CallbackToFutureAdapter.Completer<T> completer) {
        this.completerWeakReference = new WeakReference<CallbackToFutureAdapter.Completer<CallbackToFutureAdapter.Completer<T>>>(completer);
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    @Override
    public boolean cancel(boolean bl) {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer)this.completerWeakReference.get();
        if (!(bl = this.delegate.cancel(bl))) return bl;
        if (completer == null) return bl;
        completer.fireCancellationListeners();
        return bl;
    }

    boolean cancelWithoutNotifyingCompleter(boolean bl) {
        return this.delegate.cancel(bl);
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return (T)this.delegate.get();
    }

    @Override
    public T get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T)this.delegate.get(l, timeUnit);
    }

    @Override
    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.delegate.isDone();
    }

    boolean set(T t) {
        return this.delegate.set(t);
    }

    boolean setException(Throwable throwable) {
        return this.delegate.setException(throwable);
    }

    public String toString() {
        return this.delegate.toString();
    }
}
