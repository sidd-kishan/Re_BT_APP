/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

static final class ObservableReplay.Replay<T>
extends ConnectableObservable<T> {
    private final ConnectableObservable<T> co;
    private final Observable<T> observable;

    ObservableReplay.Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
        this.co = connectableObservable;
        this.observable = observable;
    }

    public void connect(Consumer<? super Disposable> consumer) {
        this.co.connect(consumer);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.observable.subscribe(observer);
    }
}
