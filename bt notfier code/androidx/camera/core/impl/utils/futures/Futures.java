/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.ChainingListenableFuture
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures$CallbackListener
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedScheduledFuture
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateSuccessfulFuture
 *  androidx.camera.core.impl.utils.futures.ListFuture
 *  androidx.camera.core.impl.utils.futures._$$Lambda$Futures$BFJU90gKHywJ5fHtASrMxI3JslQ
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.core.impl.utils.futures._$;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new /* Unavailable Anonymous Inner Class!! */;

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener((Runnable)new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static <V> ListenableFuture<List<V>> allAsList(Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList<ListenableFuture<? extends V>>(collection), true, CameraXExecutors.directExecutor());
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        boolean bl = future.isDone();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Future was expected to be done, ");
        stringBuilder.append(future);
        Preconditions.checkState((boolean)bl, (String)stringBuilder.toString());
        return Futures.getUninterruptibly(future);
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean bl = false;
        while (true) {
            try {
                v = future.get();
                if (!bl) return v;
                Thread.currentThread().interrupt();
            }
            catch (Throwable throwable) {
                if (!bl) throw throwable;
                Thread.currentThread().interrupt();
                throw throwable;
            }
            catch (InterruptedException interruptedException) {
                bl = true;
                continue;
            }
            break;
        }
        return v;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable) {
        return new ImmediateFuture.ImmediateFailedFuture(throwable);
    }

    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(Throwable throwable) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(throwable);
    }

    public static <V> ListenableFuture<V> immediateFuture(V v) {
        if (v != null) return new ImmediateFuture.ImmediateSuccessfulFuture(v);
        return ImmediateFuture.nullFuture();
    }

    static /* synthetic */ Object lambda$nonCancellationPropagating$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer object) throws Exception {
        Futures.propagateTransform(false, listenableFuture, IDENTITY_FUNCTION, object, CameraXExecutors.directExecutor());
        object = new StringBuilder();
        ((StringBuilder)object).append("nonCancellationPropagating[");
        ((StringBuilder)object).append(listenableFuture);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        if (!listenableFuture.isDone()) return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.Futures.BFJU90gKHywJ5fHtASrMxI3JslQ(listenableFuture));
        return listenableFuture;
    }

    public static <V> void propagate(ListenableFuture<V> listenableFuture, CallbackToFutureAdapter.Completer<V> completer) {
        Futures.propagateTransform(listenableFuture, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, CallbackToFutureAdapter.Completer<O> completer, Executor executor) {
        Futures.propagateTransform(true, listenableFuture, function, completer, executor);
    }

    private static <I, O> void propagateTransform(boolean bl, ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, CallbackToFutureAdapter.Completer<O> completer, Executor executor) {
        Preconditions.checkNotNull(listenableFuture);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(completer);
        Preconditions.checkNotNull((Object)executor);
        Futures.addCallback(listenableFuture, new /* Unavailable Anonymous Inner Class!! */, executor);
        if (!bl) return;
        completer.addCancellationListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, CameraXExecutors.directExecutor());
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList<ListenableFuture<? extends V>>(collection), false, CameraXExecutors.directExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return Futures.transformAsync(listenableFuture, new /* Unavailable Anonymous Inner Class!! */, executor);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> chainingListenableFuture, Executor executor) {
        chainingListenableFuture = new ChainingListenableFuture(chainingListenableFuture, listenableFuture);
        listenableFuture.addListener((Runnable)chainingListenableFuture, executor);
        return chainingListenableFuture;
    }
}
