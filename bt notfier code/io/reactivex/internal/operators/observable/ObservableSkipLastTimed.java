/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSkipLastTimed$SkipLastTimedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import java.util.concurrent.TimeUnit;

public final class ObservableSkipLastTimed<T>
extends AbstractObservableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        super(observableSource);
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.delayError = bl;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new SkipLastTimedObserver(observer, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
