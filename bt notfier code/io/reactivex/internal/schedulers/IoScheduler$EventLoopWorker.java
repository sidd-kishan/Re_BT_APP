/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.IoScheduler$CachedWorkerPool
 *  io.reactivex.internal.schedulers.IoScheduler$ThreadWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.IoScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

static final class IoScheduler.EventLoopWorker
extends Scheduler.Worker {
    final AtomicBoolean once = new AtomicBoolean();
    private final IoScheduler.CachedWorkerPool pool;
    private final CompositeDisposable tasks;
    private final IoScheduler.ThreadWorker threadWorker;

    IoScheduler.EventLoopWorker(IoScheduler.CachedWorkerPool cachedWorkerPool) {
        this.pool = cachedWorkerPool;
        this.tasks = new CompositeDisposable();
        this.threadWorker = cachedWorkerPool.get();
    }

    public void dispose() {
        if (!this.once.compareAndSet(false, true)) return;
        this.tasks.dispose();
        this.pool.release(this.threadWorker);
    }

    public boolean isDisposed() {
        return this.once.get();
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (!this.tasks.isDisposed()) return this.threadWorker.scheduleActual(runnable, l, timeUnit, (DisposableContainer)this.tasks);
        return EmptyDisposable.INSTANCE;
    }
}
