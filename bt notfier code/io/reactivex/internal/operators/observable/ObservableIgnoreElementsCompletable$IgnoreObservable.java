/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

static final class ObservableIgnoreElementsCompletable.IgnoreObservable<T>
implements Observer<T>,
Disposable {
    final CompletableObserver downstream;
    Disposable upstream;

    ObservableIgnoreElementsCompletable.IgnoreObservable(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
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
