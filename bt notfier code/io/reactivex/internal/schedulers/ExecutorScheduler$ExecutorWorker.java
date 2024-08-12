/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.schedulers.DisposeOnCancel
 *  io.reactivex.internal.schedulers.ExecutorScheduler
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$BooleanRunnable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$InterruptibleRunnable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$SequentialDispose
 *  io.reactivex.internal.schedulers.ScheduledRunnable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.schedulers.DisposeOnCancel;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public static final class ExecutorScheduler.ExecutorWorker
extends Scheduler.Worker
implements Runnable {
    volatile boolean disposed;
    final Executor executor;
    final boolean interruptibleWorker;
    final MpscLinkedQueue<Runnable> queue;
    final CompositeDisposable tasks;
    final AtomicInteger wip = new AtomicInteger();

    public ExecutorScheduler.ExecutorWorker(Executor executor, boolean bl) {
        this.tasks = new CompositeDisposable();
        this.executor = executor;
        this.queue = new MpscLinkedQueue();
        this.interruptibleWorker = bl;
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.tasks.dispose();
        if (this.wip.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    @Override
    public void run() {
        MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
        int n = 1;
        block0: while (true) {
            if (this.disposed) {
                mpscLinkedQueue.clear();
                return;
            }
            do {
                Runnable runnable;
                if ((runnable = (Runnable)mpscLinkedQueue.poll()) == null) {
                    int n2;
                    if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                    n = n2 = this.wip.addAndGet(-n);
                    if (n2 != 0) continue block0;
                    return;
                }
                runnable.run();
            } while (!this.disposed);
            break;
        }
        mpscLinkedQueue.clear();
    }

    public Disposable schedule(Runnable runnable) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        if (this.interruptibleWorker) {
            runnable = new InterruptibleRunnable(runnable, (DisposableContainer)this.tasks);
            this.tasks.add((Disposable)runnable);
        } else {
            runnable = new BooleanRunnable(runnable);
        }
        this.queue.offer((Object)runnable);
        if (this.wip.getAndIncrement() != 0) return runnable;
        try {
            this.executor.execute(this);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.disposed = true;
            this.queue.clear();
            RxJavaPlugins.onError((Throwable)rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
        return runnable;
    }

    public Disposable schedule(Runnable object, long l, TimeUnit timeUnit) {
        if (l <= 0L) {
            return this.schedule((Runnable)object);
        }
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable((Disposable)sequentialDisposable);
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable((Runnable)new SequentialDispose(this, sequentialDisposable2, RxJavaPlugins.onSchedule((Runnable)object)), (DisposableContainer)this.tasks);
        this.tasks.add((Disposable)scheduledRunnable);
        object = this.executor;
        if (object instanceof ScheduledExecutorService) {
            try {
                scheduledRunnable.setFuture(((ScheduledExecutorService)object).schedule(scheduledRunnable, l, timeUnit));
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                this.disposed = true;
                RxJavaPlugins.onError((Throwable)rejectedExecutionException);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            scheduledRunnable.setFuture((Future)new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect((Runnable)scheduledRunnable, l, timeUnit)));
        }
        sequentialDisposable.replace((Disposable)scheduledRunnable);
        return sequentialDisposable2;
    }
}
