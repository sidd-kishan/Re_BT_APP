/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed$DebounceTimedObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableThrottleFirstTimed<T>
extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DebounceTimedObserver((Observer)new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
