/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableInterval$IntervalObserver
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;

public final class ObservableInterval
extends Observable<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableInterval(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = l;
        this.period = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void subscribeActual(Observer<? super Long> scheduler) {
        IntervalObserver intervalObserver = new IntervalObserver(scheduler);
        scheduler.onSubscribe((Disposable)intervalObserver);
        scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            scheduler = scheduler.createWorker();
            intervalObserver.setResource((Disposable)scheduler);
            scheduler.schedulePeriodically((Runnable)intervalObserver, this.initialDelay, this.period, this.unit);
        } else {
            intervalObserver.setResource(scheduler.schedulePeriodicallyDirect((Runnable)intervalObserver, this.initialDelay, this.period, this.unit));
        }
    }
}
