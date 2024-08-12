/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

private static class HandlerScheduledExecutorService.HandlerScheduledFuture<V>
implements RunnableScheduledFuture<V> {
    final AtomicReference<CallbackToFutureAdapter.Completer<V>> mCompleter = new AtomicReference<Object>(null);
    private final ListenableFuture<V> mDelegate;
    private final long mRunAtMillis;
    private final Callable<V> mTask;

    HandlerScheduledExecutorService.HandlerScheduledFuture(Handler handler, long l, Callable<V> callable) {
        this.mRunAtMillis = l;
        this.mTask = callable;
        this.mDelegate = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new /* Unavailable Anonymous Inner Class!! */);
    }

    @Override
    public boolean cancel(boolean bl) {
        return this.mDelegate.cancel(bl);
    }

    @Override
    public int compareTo(Delayed delayed) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), delayed.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public V get() throws ExecutionException, InterruptedException {
        return this.mDelegate.get();
    }

    @Override
    public V get(long l, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.mDelegate.get(l, timeUnit);
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    @Override
    public boolean isPeriodic() {
        return false;
    }

    @Override
    public void run() {
        CallbackToFutureAdapter.Completer completer = this.mCompleter.getAndSet(null);
        if (completer == null) return;
        try {
            completer.set(this.mTask.call());
        }
        catch (Exception exception) {
            completer.setException((Throwable)exception);
        }
    }
}
