/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeoutTimed<T>
extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public ObservableTimeoutTimed(Observable<T> observable, long l, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = observableSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        if (this.other == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.timeout, this.unit, this.scheduler.createWorker());
            observer.onSubscribe((Disposable)timeoutObserver);
            timeoutObserver.startTimeout(0L);
            this.source.subscribe((Observer)timeoutObserver);
        } else {
            TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
            observer.onSubscribe((Disposable)timeoutFallbackObserver);
            timeoutFallbackObserver.startTimeout(0L);
            this.source.subscribe((Observer)timeoutFallbackObserver);
        }
    }
}
