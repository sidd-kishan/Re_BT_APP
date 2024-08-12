/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableConcatWithCompletable$ConcatWithObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;

public final class ObservableConcatWithCompletable<T>
extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource other;

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.other = completableSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ConcatWithObserver(observer, this.other));
    }
}
