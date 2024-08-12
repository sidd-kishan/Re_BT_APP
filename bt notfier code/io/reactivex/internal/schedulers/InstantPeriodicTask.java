/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask
implements Callable<Void>,
Disposable {
    static final FutureTask<Void> CANCELLED = new FutureTask<Object>(Functions.EMPTY_RUNNABLE, null);
    final ExecutorService executor;
    final AtomicReference<Future<?>> first;
    final AtomicReference<Future<?>> rest;
    Thread runner;
    final Runnable task;

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.task = runnable;
        this.first = new AtomicReference();
        this.rest = new AtomicReference();
        this.executor = executorService;
    }

    @Override
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.task.run();
            this.setRest(this.executor.submit(this));
            this.runner = null;
        }
        catch (Throwable throwable) {
            this.runner = null;
            RxJavaPlugins.onError((Throwable)throwable);
        }
        return null;
    }

    public void dispose() {
        boolean bl;
        Future future = this.first.getAndSet(CANCELLED);
        boolean bl2 = true;
        if (future != null && future != CANCELLED) {
            bl = this.runner != Thread.currentThread();
            future.cancel(bl);
        }
        if ((future = (Future)this.rest.getAndSet(CANCELLED)) == null) return;
        if (future == CANCELLED) return;
        bl = this.runner != Thread.currentThread() ? bl2 : false;
        future.cancel(bl);
    }

    public boolean isDisposed() {
        boolean bl = this.first.get() == CANCELLED;
        return bl;
    }

    void setFirst(Future<?> future) {
        Future<?> future2;
        do {
            if ((future2 = this.first.get()) != CANCELLED) continue;
            boolean bl = this.runner != Thread.currentThread();
            future.cancel(bl);
            return;
        } while (!this.first.compareAndSet(future2, future));
    }

    void setRest(Future<?> future) {
        Future<?> future2;
        do {
            if ((future2 = this.rest.get()) != CANCELLED) continue;
            boolean bl = this.runner != Thread.currentThread();
            future.cancel(bl);
            return;
        } while (!this.rest.compareAndSet(future2, future));
    }
}
