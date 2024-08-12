/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableSkip.SkipObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    long remaining;
    Disposable upstream;

    ObservableSkip.SkipObserver(Observer<? super T> observer, long l) {
        this.downstream = observer;
        this.remaining = l;
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
        long l = this.remaining;
        if (l != 0L) {
            this.remaining = l - 1L;
        } else {
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
