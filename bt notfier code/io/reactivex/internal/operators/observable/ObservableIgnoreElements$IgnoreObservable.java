/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

static final class ObservableIgnoreElements.IgnoreObservable<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    Disposable upstream;

    ObservableIgnoreElements.IgnoreObservable(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
