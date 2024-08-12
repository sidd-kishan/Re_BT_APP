/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableOnErrorNext$OnErrorNextObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;

public final class ObservableOnErrorNext<T>
extends AbstractObservableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean bl) {
        super(observableSource);
        this.nextSupplier = function;
        this.allowFatal = bl;
    }

    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.nextSupplier, this.allowFatal);
        observer.onSubscribe((Disposable)onErrorNextObserver.arbiter);
        this.source.subscribe((Observer)onErrorNextObserver);
    }
}
