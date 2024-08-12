/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;

public final class ObservableFlatMapMaybe<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe((Observer)new FlatMapMaybeObserver(observer, this.mapper, this.delayErrors));
    }
}
