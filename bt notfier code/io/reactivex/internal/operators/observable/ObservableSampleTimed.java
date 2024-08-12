/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast
 *  io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableSampleTimed<T>
extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableSampleTimed(ObservableSource<T> observableSource, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(observableSource);
        this.period = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.emitLast = bl;
    }

    public void subscribeActual(Observer<? super T> serializedObserver) {
        serializedObserver = new SerializedObserver(serializedObserver);
        if (this.emitLast) {
            this.source.subscribe((Observer)new SampleTimedEmitLast((Observer)serializedObserver, this.period, this.unit, this.scheduler));
        } else {
            this.source.subscribe((Observer)new SampleTimedNoLast((Observer)serializedObserver, this.period, this.unit, this.scheduler));
        }
    }
}
