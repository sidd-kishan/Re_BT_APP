/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapSingle<T, R>
extends Observable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int prefetch;
    final Observable<T> source;

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int n) {
        this.source = observable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsSingle(this.source, this.mapper, observer)) return;
        this.source.subscribe((Observer)new ConcatMapSingleMainObserver(observer, this.mapper, this.prefetch, this.errorMode));
    }
}
