/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDematerialize$DematerializeObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDematerialize;

public final class ObservableDematerialize<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> selector;

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.selector = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe((Observer)new DematerializeObserver(observer, this.selector));
    }
}
