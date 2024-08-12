/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableConcatWithSingle$ConcatWithObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;

public final class ObservableConcatWithSingle<T>
extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> other;

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.other = singleSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ConcatWithObserver(observer, this.other));
    }
}
