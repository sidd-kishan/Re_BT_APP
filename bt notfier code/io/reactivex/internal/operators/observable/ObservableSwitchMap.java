/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap
 *  io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;

public final class ObservableSwitchMap<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int n, boolean bl) {
        super(observableSource);
        this.mapper = function;
        this.bufferSize = n;
        this.delayErrors = bl;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe((ObservableSource)this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe((Observer)new SwitchMapObserver(observer, this.mapper, this.bufferSize, this.delayErrors));
    }
}
