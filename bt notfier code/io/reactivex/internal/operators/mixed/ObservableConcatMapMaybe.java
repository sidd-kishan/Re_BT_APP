/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapMaybe<T, R>
extends Observable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Observable<T> source;

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int n) {
        this.source = observable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, observer)) return;
        this.source.subscribe((Observer)new ConcatMapMaybeMainObserver(observer, this.mapper, this.prefetch, this.errorMode));
    }
}
