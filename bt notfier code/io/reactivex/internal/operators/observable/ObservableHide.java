/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableHide$HideDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableHide;

public final class ObservableHide<T>
extends AbstractObservableWithUpstream<T, T> {
    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new HideDisposable(observer));
    }
}
