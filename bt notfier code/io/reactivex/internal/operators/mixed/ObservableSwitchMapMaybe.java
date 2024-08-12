/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver
 *  io.reactivex.internal.operators.mixed.ScalarXMapZHelper
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ScalarXMapZHelper;

public final class ObservableSwitchMapMaybe<T, R>
extends Observable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final Observable<T> source;

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        this.source = observable;
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, observer)) return;
        this.source.subscribe((Observer)new SwitchMapMaybeMainObserver(observer, this.mapper, this.delayErrors));
    }
}
