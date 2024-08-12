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
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T>
extends Observable<T> {
    final AtomicInteger clients;
    final Consumer<? super Disposable> connection;
    final int numberOfObservers;
    final ConnectableObservable<? extends T> source;

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int n, Consumer<? super Disposable> consumer) {
        this.source = connectableObservable;
        this.numberOfObservers = n;
        this.connection = consumer;
        this.clients = new AtomicInteger();
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(observer);
        if (this.clients.incrementAndGet() != this.numberOfObservers) return;
        this.source.connect(this.connection);
    }
}
