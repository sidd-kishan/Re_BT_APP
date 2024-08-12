/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

static final class CompletableFromObservable.CompletableFromObservableObserver<T>
implements Observer<T> {
    final CompletableObserver co;

    CompletableFromObservable.CompletableFromObservableObserver(CompletableObserver completableObserver) {
        this.co = completableObserver;
    }

    public void onComplete() {
        this.co.onComplete();
    }

    public void onError(Throwable throwable) {
        this.co.onError(throwable);
    }

    public void onNext(T t) {
    }

    public void onSubscribe(Disposable disposable) {
        this.co.onSubscribe(disposable);
    }
}
