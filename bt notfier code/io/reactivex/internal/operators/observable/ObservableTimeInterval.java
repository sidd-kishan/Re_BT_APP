/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTimeInterval$TimeIntervalObserver
 *  io.reactivex.schedulers.Timed
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T>
extends AbstractObservableWithUpstream<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.scheduler = scheduler;
        this.unit = timeUnit;
    }

    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.source.subscribe((Observer)new TimeIntervalObserver(observer, this.unit, this.scheduler));
    }
}
