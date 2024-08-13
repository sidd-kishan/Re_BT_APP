/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTakeLastTimed$TakeLastTimedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import java.util.concurrent.TimeUnit;

public final class ObservableTakeLastTimed<T>
extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        super(observableSource);
        this.count = l;
        this.time = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.delayError = bl;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new TakeLastTimedObserver(observer, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}