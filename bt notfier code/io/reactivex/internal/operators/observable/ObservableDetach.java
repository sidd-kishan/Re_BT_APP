/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDetach$DetachObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDetach;

public final class ObservableDetach<T>
extends AbstractObservableWithUpstream<T, T> {
    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DetachObserver(observer));
    }
}
