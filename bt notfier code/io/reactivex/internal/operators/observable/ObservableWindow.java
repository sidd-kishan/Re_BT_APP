/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWindow$WindowExactObserver
 *  io.reactivex.internal.operators.observable.ObservableWindow$WindowSkipObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWindow;

public final class ObservableWindow<T>
extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final long count;
    final long skip;

    public ObservableWindow(ObservableSource<T> observableSource, long l, long l2, int n) {
        super(observableSource);
        this.count = l;
        this.skip = l2;
        this.capacityHint = n;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.count == this.skip) {
            this.source.subscribe((Observer)new WindowExactObserver(observer, this.count, this.capacityHint));
        } else {
            this.source.subscribe((Observer)new WindowSkipObserver(observer, this.count, this.skip, this.capacityHint));
        }
    }
}
