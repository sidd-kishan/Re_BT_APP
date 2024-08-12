/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainEmitLast
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainNoLast
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSampleWithObservable<T>
extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final ObservableSource<?> other;

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean bl) {
        super(observableSource);
        this.other = observableSource2;
        this.emitLast = bl;
    }

    public void subscribeActual(Observer<? super T> serializedObserver) {
        serializedObserver = new SerializedObserver(serializedObserver);
        if (this.emitLast) {
            this.source.subscribe((Observer)new SampleMainEmitLast((Observer)serializedObserver, this.other));
        } else {
            this.source.subscribe((Observer)new SampleMainNoLast((Observer)serializedObserver, this.other));
        }
    }
}
