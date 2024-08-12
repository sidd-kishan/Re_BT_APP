/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class HandlerScheduledExecutorService
extends AbstractExecutorService
implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance = new /* Unavailable Anonymous Inner Class!! */;
    private final Handler mHandler;

    HandlerScheduledExecutorService(Handler handler) {
        this.mHandler = handler;
    }

    private RejectedExecutionException createPostFailedException() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mHandler);
        stringBuilder.append(" is shutting down");
        return new RejectedExecutionException(stringBuilder.toString());
    }

    static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService = sThreadLocalInstance.get();
        if (scheduledExecutorService != null) return scheduledExecutorService2;
        scheduledExecutorService2 = Looper.myLooper();
        if (scheduledExecutorService2 == null) throw new IllegalStateException("Current thread has no looper!");
        scheduledExecutorService2 = new HandlerScheduledExecutorService(new Handler((Looper)scheduledExecutorService2));
        sThreadLocalInstance.set(scheduledExecutorService2);
        return scheduledExecutorService2;
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit object) {
        object = new StringBuilder();
        ((StringBuilder)object).append(HandlerScheduledExecutorService.class.getSimpleName());
        ((StringBuilder)object).append(" cannot be shut down. Use Looper.quitSafely().");
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    @Override
    public void execute(Runnable runnable) {
        if (!this.mHandler.post(runnable)) throw this.createPostFailedException();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        return this.schedule((Callable)new /* Unavailable Anonymous Inner Class!! */, l, timeUnit);
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> handlerScheduledFuture, long l, TimeUnit timeUnit) {
        l = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(l, timeUnit);
        handlerScheduledFuture = new HandlerScheduledFuture(this.mHandler, l, handlerScheduledFuture);
        if (!this.mHandler.postAtTime((Runnable)handlerScheduledFuture, l)) return Futures.immediateFailedScheduledFuture((Throwable)this.createPostFailedException());
        return handlerScheduledFuture;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable object, long l, long l2, TimeUnit timeUnit) {
        object = new StringBuilder();
        ((StringBuilder)object).append(HandlerScheduledExecutorService.class.getSimpleName());
        ((StringBuilder)object).append(" does not yet support fixed-rate scheduling.");
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable object, long l, long l2, TimeUnit timeUnit) {
        object = new StringBuilder();
        ((StringBuilder)object).append(HandlerScheduledExecutorService.class.getSimpleName());
        ((StringBuilder)object).append(" does not yet support fixed-delay scheduling.");
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    @Override
    public void shutdown() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HandlerScheduledExecutorService.class.getSimpleName());
        stringBuilder.append(" cannot be shut down. Use Looper.quitSafely().");
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    @Override
    public List<Runnable> shutdownNow() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HandlerScheduledExecutorService.class.getSimpleName());
        stringBuilder.append(" cannot be shut down. Use Looper.quitSafely().");
        throw new UnsupportedOperationException(stringBuilder.toString());
    }
}
