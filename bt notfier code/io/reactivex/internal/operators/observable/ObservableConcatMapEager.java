/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableConcatMapEager$ConcatMapEagerMainObserver
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapEager<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int n, int n2) {
        super(observableSource);
        this.mapper = function;
        this.errorMode = errorMode;
        this.maxConcurrency = n;
        this.prefetch = n2;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe((Observer)new ConcatMapEagerMainObserver(observer, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
