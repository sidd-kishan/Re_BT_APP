/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.disposables.ListCompositeDisposable
 *  io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.schedulers.ComputationScheduler;
import java.util.concurrent.TimeUnit;

static final class ComputationScheduler.EventLoopWorker
extends Scheduler.Worker {
    private final ListCompositeDisposable both;
    volatile boolean disposed;
    private final ComputationScheduler.PoolWorker poolWorker;
    private final ListCompositeDisposable serial;
    private final CompositeDisposable timed;

    ComputationScheduler.EventLoopWorker(ComputationScheduler.PoolWorker poolWorker) {
        this.poolWorker = poolWorker;
        this.serial = new ListCompositeDisposable();
        this.timed = new CompositeDisposable();
        poolWorker = new ListCompositeDisposable();
        this.both = poolWorker;
        poolWorker.add((Disposable)this.serial);
        this.both.add((Disposable)this.timed);
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.both.dispose();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public Disposable schedule(Runnable runnable) {
        if (!this.disposed) return this.poolWorker.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, (DisposableContainer)this.serial);
        return EmptyDisposable.INSTANCE;
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (!this.disposed) return this.poolWorker.scheduleActual(runnable, l, timeUnit, (DisposableContainer)this.timed);
        return EmptyDisposable.INSTANCE;
    }
}
