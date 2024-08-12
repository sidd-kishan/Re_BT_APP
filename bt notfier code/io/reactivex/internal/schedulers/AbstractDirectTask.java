/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.schedulers.SchedulerRunnableIntrospection
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask
extends AtomicReference<Future<?>>
implements Disposable,
SchedulerRunnableIntrospection {
    protected static final FutureTask<Void> DISPOSED;
    protected static final FutureTask<Void> FINISHED;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        FINISHED = new FutureTask<Object>(Functions.EMPTY_RUNNABLE, null);
        DISPOSED = new FutureTask<Object>(Functions.EMPTY_RUNNABLE, null);
    }

    AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    public final void dispose() {
        Future future = (Future)this.get();
        if (future == FINISHED) return;
        FutureTask<Void> futureTask = DISPOSED;
        if (future == futureTask) return;
        if (!this.compareAndSet(future, futureTask)) return;
        if (future == null) return;
        boolean bl = this.runner != Thread.currentThread();
        future.cancel(bl);
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    public final boolean isDisposed() {
        Future future = (Future)this.get();
        boolean bl = future == FINISHED || future == DISPOSED;
        return bl;
    }

    public final void setFuture(Future<?> future) {
        Future future2;
        while ((future2 = (Future)this.get()) != FINISHED) {
            if (future2 == DISPOSED) {
                boolean bl = this.runner != Thread.currentThread();
                future.cancel(bl);
                break;
            }
            if (!this.compareAndSet(future2, future)) continue;
        }
    }
}
