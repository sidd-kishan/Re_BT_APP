/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableScan$ScanObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableScan;

public final class ObservableScan<T>
extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.accumulator = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ScanObserver(observer, this.accumulator));
    }
}
