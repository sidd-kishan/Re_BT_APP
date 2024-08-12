/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSerialized<T>
extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(Observable<T> observable) {
        super(observable);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new SerializedObserver(observer));
    }
}
