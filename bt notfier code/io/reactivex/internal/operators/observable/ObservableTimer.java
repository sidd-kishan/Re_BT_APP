/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableTimer$TimerObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableTimer;
import java.util.concurrent.TimeUnit;

public final class ObservableTimer
extends Observable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableTimer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe((Disposable)timerObserver);
        timerObserver.setResource(this.scheduler.scheduleDirect((Runnable)timerObserver, this.delay, this.unit));
    }
}
