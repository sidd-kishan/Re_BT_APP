/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver
 *  io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTimeout;

public final class ObservableTimeout<T, U, V>
extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> firstTimeoutIndicator;
    final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
    final ObservableSource<? extends T> other;

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.firstTimeoutIndicator = observableSource;
        this.itemTimeoutIndicator = function;
        this.other = observableSource2;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        if (this.other == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.itemTimeoutIndicator);
            observer.onSubscribe((Disposable)timeoutObserver);
            timeoutObserver.startFirstTimeout(this.firstTimeoutIndicator);
            this.source.subscribe((Observer)timeoutObserver);
        } else {
            TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.itemTimeoutIndicator, this.other);
            observer.onSubscribe((Disposable)timeoutFallbackObserver);
            timeoutFallbackObserver.startFirstTimeout(this.firstTimeoutIndicator);
            this.source.subscribe((Observer)timeoutFallbackObserver);
        }
    }
}
