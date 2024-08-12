/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

static final class CompletableFromSingle.CompletableFromSingleObserver<T>
implements SingleObserver<T> {
    final CompletableObserver co;

    CompletableFromSingle.CompletableFromSingleObserver(CompletableObserver completableObserver) {
        this.co = completableObserver;
    }

    public void onError(Throwable throwable) {
        this.co.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.co.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        this.co.onComplete();
    }
}
