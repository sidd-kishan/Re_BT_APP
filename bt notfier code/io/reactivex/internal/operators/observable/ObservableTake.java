/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTake$TakeObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTake;

public final class ObservableTake<T>
extends AbstractObservableWithUpstream<T, T> {
    final long limit;

    public ObservableTake(ObservableSource<T> observableSource, long l) {
        super(observableSource);
        this.limit = l;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new TakeObserver(observer, this.limit));
    }
}
