/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDoFinally$DoFinallyObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDoFinally;

public final class ObservableDoFinally<T>
extends AbstractObservableWithUpstream<T, T> {
    final Action onFinally;

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.onFinally = action;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DoFinallyObserver(observer, this.onFinally));
    }
}
