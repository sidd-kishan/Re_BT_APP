/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$WindowBoundaryMainObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.observers.SerializedObserver;

public final class ObservableWindowBoundarySelector<T, B, V>
extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> close;
    final ObservableSource<B> open;

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int n) {
        super(observableSource);
        this.open = observableSource2;
        this.close = function;
        this.bufferSize = n;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe((Observer)new WindowBoundaryMainObserver((Observer)new SerializedObserver(observer), this.open, this.close, this.bufferSize));
    }
}
