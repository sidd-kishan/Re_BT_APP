/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactBoundedObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactUnboundedObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableWindowTimed<T>
extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public ObservableWindowTimed(ObservableSource<T> observableSource, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, long l3, int n, boolean bl) {
        super(observableSource);
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = l3;
        this.bufferSize = n;
        this.restartTimerOnMaxSize = bl;
    }

    public void subscribeActual(Observer<? super Observable<T>> serializedObserver) {
        serializedObserver = new SerializedObserver(serializedObserver);
        if (this.timespan != this.timeskip) {
            this.source.subscribe((Observer)new WindowSkipObserver((Observer)serializedObserver, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
            return;
        }
        if (this.maxSize == Long.MAX_VALUE) {
            this.source.subscribe((Observer)new WindowExactUnboundedObserver((Observer)serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize));
            return;
        }
        this.source.subscribe((Observer)new WindowExactBoundedObserver((Observer)serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
    }
}
