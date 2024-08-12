/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker$PeriodicTask
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

public static abstract class Scheduler.Worker
implements Disposable {
    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable schedule(Runnable runnable) {
        return this.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public abstract Disposable schedule(Runnable var1, long var2, TimeUnit var4);

    public Disposable schedulePeriodically(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable((Disposable)sequentialDisposable);
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        l2 = timeUnit.toNanos(l2);
        long l3 = this.now(TimeUnit.NANOSECONDS);
        runnable = this.schedule((Runnable)new PeriodicTask(this, l3 + timeUnit.toNanos(l), runnable, l3, sequentialDisposable2, l2), l, timeUnit);
        if (runnable == EmptyDisposable.INSTANCE) {
            return runnable;
        }
        sequentialDisposable.replace((Disposable)runnable);
        return sequentialDisposable2;
    }
}
