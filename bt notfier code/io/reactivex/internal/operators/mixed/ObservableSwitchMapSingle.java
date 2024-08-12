/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;

public final class ObservableSwitchMapSingle<T, R>
extends Observable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final Observable<T> source;

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        this.source = observable;
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsSingle(this.source, this.mapper, observer)) return;
        this.source.subscribe((Observer)new SwitchMapSingleMainObserver(observer, this.mapper, this.delayErrors));
    }
}
