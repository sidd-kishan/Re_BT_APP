/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTakeLast$TakeLastObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTakeLast;

public final class ObservableTakeLast<T>
extends AbstractObservableWithUpstream<T, T> {
    final int count;

    public ObservableTakeLast(ObservableSource<T> observableSource, int n) {
        super(observableSource);
        this.count = n;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new TakeLastObserver(observer, this.count));
    }
}
