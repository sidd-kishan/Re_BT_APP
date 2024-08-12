/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableIntervalRange$IntervalRangeObserver
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;

public final class ObservableIntervalRange
extends Observable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    public ObservableIntervalRange(long l, long l2, long l3, long l4, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = l3;
        this.period = l4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.start = l;
        this.end = l2;
    }

    public void subscribeActual(Observer<? super Long> scheduler) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(scheduler, this.start, this.end);
        scheduler.onSubscribe((Disposable)intervalRangeObserver);
        scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            scheduler = scheduler.createWorker();
            intervalRangeObserver.setResource((Disposable)scheduler);
            scheduler.schedulePeriodically((Runnable)intervalRangeObserver, this.initialDelay, this.period, this.unit);
        } else {
            intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect((Runnable)intervalRangeObserver, this.initialDelay, this.period, this.unit));
        }
    }
}
