/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.DeferredScalarDisposable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

static final class MaybeToObservable.MaybeToObservableObserver<T>
extends DeferredScalarDisposable<T>
implements MaybeObserver<T> {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;

    MaybeToObservable.MaybeToObservableObserver(Observer<? super T> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        this.complete();
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
