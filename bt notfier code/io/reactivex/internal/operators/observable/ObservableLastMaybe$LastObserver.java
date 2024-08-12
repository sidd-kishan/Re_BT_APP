/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableLastMaybe.LastObserver<T>
implements Observer<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    T item;
    Disposable upstream;

    ObservableLastMaybe.LastObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        boolean bl = this.upstream == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        T t = this.item;
        if (t != null) {
            this.item = null;
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.item = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.item = t;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
