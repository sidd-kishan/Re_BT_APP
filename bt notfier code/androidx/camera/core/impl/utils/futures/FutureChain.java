/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureChain<V>
implements ListenableFuture<V> {
    CallbackToFutureAdapter.Completer<V> mCompleter;
    private final ListenableFuture<V> mDelegate;

    FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new /* Unavailable Anonymous Inner Class!! */);
    }

    FutureChain(ListenableFuture<V> listenableFuture) {
        this.mDelegate = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    public static <V> FutureChain<V> from(ListenableFuture<V> futureChain) {
        futureChain = futureChain instanceof FutureChain ? (FutureChain<V>)futureChain : new FutureChain<V>(futureChain);
        return futureChain;
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.addCallback((ListenableFuture)this, futureCallback, (Executor)executor);
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    @Override
    public boolean cancel(boolean bl) {
        return this.mDelegate.cancel(bl);
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    @Override
    public V get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(l, timeUnit);
    }

    @Override
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    boolean set(V v) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer == null) return false;
        return completer.set(v);
    }

    boolean setException(Throwable throwable) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer == null) return false;
        return completer.setException(throwable);
    }

    public final <T> FutureChain<T> transform(Function<? super V, T> function, Executor executor) {
        return (FutureChain)Futures.transform((ListenableFuture)this, function, (Executor)executor);
    }

    public final <T> FutureChain<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (FutureChain)Futures.transformAsync((ListenableFuture)this, asyncFunction, (Executor)executor);
    }
}
