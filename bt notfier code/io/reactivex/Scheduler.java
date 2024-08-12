/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler$DisposeTask
 *  io.reactivex.Scheduler$PeriodicDirectTask
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.SchedulerWhen
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L));

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public abstract Worker createWorker();

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable) {
        return this.scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        Worker worker = this.createWorker();
        runnable = new DisposeTask(RxJavaPlugins.onSchedule((Runnable)runnable), worker);
        worker.schedule(runnable, l, timeUnit);
        return runnable;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        Worker worker = this.createWorker();
        timeUnit = worker.schedulePeriodically(runnable = new PeriodicDirectTask(RxJavaPlugins.onSchedule((Runnable)runnable), worker), l, l2, timeUnit);
        if (timeUnit != EmptyDisposable.INSTANCE) return runnable;
        return timeUnit;
    }

    public void shutdown() {
    }

    public void start() {
    }

    public <S extends Scheduler> S when(Function<Flowable<Flowable<Completable>>, Completable> function) {
        return (S)new SchedulerWhen(function, this);
    }
}
