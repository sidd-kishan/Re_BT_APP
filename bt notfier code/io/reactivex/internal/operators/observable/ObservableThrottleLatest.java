/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableThrottleLatest$ThrottleLatestObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import java.util.concurrent.TimeUnit;

public final class ObservableThrottleLatest<T>
extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public ObservableThrottleLatest(Observable<T> observable, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(observable);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.emitLast = bl;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ThrottleLatestObserver(observer, this.timeout, this.unit, this.scheduler.createWorker(), this.emitLast));
    }
}
