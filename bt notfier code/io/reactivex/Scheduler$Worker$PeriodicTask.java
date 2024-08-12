/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.schedulers.SchedulerRunnableIntrospection
 */
package io.reactivex;

import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

final class Scheduler.Worker.PeriodicTask
implements Runnable,
SchedulerRunnableIntrospection {
    long count;
    final Runnable decoratedRun;
    long lastNowNanoseconds;
    final long periodInNanoseconds;
    final SequentialDisposable sd;
    long startInNanoseconds;
    final Scheduler.Worker this$0;

    Scheduler.Worker.PeriodicTask(Scheduler.Worker worker, long l, Runnable runnable, long l2, SequentialDisposable sequentialDisposable, long l3) {
        this.this$0 = worker;
        this.decoratedRun = runnable;
        this.sd = sequentialDisposable;
        this.periodInNanoseconds = l3;
        this.lastNowNanoseconds = l2;
        this.startInNanoseconds = l;
    }

    public Runnable getWrappedRunnable() {
        return this.decoratedRun;
    }

    @Override
    public void run() {
        long l;
        this.decoratedRun.run();
        if (this.sd.isDisposed()) return;
        long l2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
        long l3 = this.this$0.now(TimeUnit.NANOSECONDS);
        if (l2 + l3 >= (l = this.lastNowNanoseconds) && l3 < l + this.periodInNanoseconds + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
            l = this.startInNanoseconds;
            this.count = l2 = this.count + 1L;
            l += l2 * this.periodInNanoseconds;
        } else {
            long l4;
            l2 = this.periodInNanoseconds;
            l = l3 + l2;
            this.count = l4 = this.count + 1L;
            this.startInNanoseconds = l - l2 * l4;
        }
        this.lastNowNanoseconds = l3;
        this.sd.replace(this.this$0.schedule((Runnable)this, l - l3, TimeUnit.NANOSECONDS));
    }
}
