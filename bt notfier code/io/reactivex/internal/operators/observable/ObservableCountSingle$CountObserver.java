/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableCountSingle.CountObserver
implements Observer<Object>,
Disposable {
    long count;
    final SingleObserver<? super Long> downstream;
    Disposable upstream;

    ObservableCountSingle.CountObserver(SingleObserver<? super Long> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onSuccess((Object)this.count);
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        ++this.count;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
