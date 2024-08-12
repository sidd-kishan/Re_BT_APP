/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.DeferredScalarDisposable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

static final class SingleToObservable.SingleToObservableObserver<T>
extends DeferredScalarDisposable<T>
implements SingleObserver<T> {
    private static final long serialVersionUID = 3786543492451018833L;
    Disposable upstream;

    SingleToObservable.SingleToObservableObserver(Observer<? super T> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onError(Throwable throwable) {
        this.error(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.complete(t);
    }
}
