/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.observers.DisposableLambdaObserver
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;

public final class ObservableDoOnLifecycle<T>
extends AbstractObservableWithUpstream<T, T> {
    private final Action onDispose;
    private final Consumer<? super Disposable> onSubscribe;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.onSubscribe = consumer;
        this.onDispose = action;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DisposableLambdaObserver(observer, this.onSubscribe, this.onDispose));
    }
}
