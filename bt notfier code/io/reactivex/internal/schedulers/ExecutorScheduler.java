/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$DelayedDispose
 *  io.reactivex.internal.schedulers.ExecutorScheduler$DelayedRunnable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$BooleanRunnable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$InterruptibleRunnable
 *  io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask
 *  io.reactivex.internal.schedulers.ScheduledDirectTask
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class ExecutorScheduler
extends Scheduler {
    static final Scheduler HELPER = Schedulers.single();
    final Executor executor;
    final boolean interruptibleWorker;

    public ExecutorScheduler(Executor executor, boolean bl) {
        this.executor = executor;
        this.interruptibleWorker = bl;
    }

    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor, this.interruptibleWorker);
    }

    public Disposable scheduleDirect(Runnable runnable) {
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        try {
            if (this.executor instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
                scheduledDirectTask.setFuture(((ExecutorService)this.executor).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.interruptibleWorker) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnable, null);
                this.executor.execute((Runnable)interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnable);
            this.executor.execute((Runnable)booleanRunnable);
            return booleanRunnable;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            RxJavaPlugins.onError((Throwable)rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        Runnable runnable2 = RxJavaPlugins.onSchedule((Runnable)runnable);
        if (!(this.executor instanceof ScheduledExecutorService)) {
            runnable = new DelayedRunnable(runnable2);
            timeUnit = HELPER.scheduleDirect((Runnable)new DelayedDispose(this, (DelayedRunnable)runnable), l, timeUnit);
            ((DelayedRunnable)runnable).timed.replace((Disposable)timeUnit);
            return runnable;
        }
        try {
            runnable = new ScheduledDirectTask(runnable2);
            runnable.setFuture(((ScheduledExecutorService)this.executor).schedule(runnable, l, timeUnit));
            return runnable;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            RxJavaPlugins.onError((Throwable)rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        if (!(this.executor instanceof ScheduledExecutorService)) return super.schedulePeriodicallyDirect(runnable, l, l2, timeUnit);
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService)this.executor).scheduleAtFixedRate((Runnable)scheduledDirectPeriodicTask, l, l2, timeUnit));
            return scheduledDirectPeriodicTask;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            RxJavaPlugins.onError((Throwable)rejectedExecutionException);
            return EmptyDisposable.INSTANCE;
        }
    }
}
