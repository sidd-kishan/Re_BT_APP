/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableConcatWithMaybe$ConcatWithObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;

public final class ObservableConcatWithMaybe<T>
extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> other;

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.other = maybeSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ConcatWithObserver(observer, this.other));
    }
}
