/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class SingleDetach.DetachSingleObserver<T>
implements SingleObserver<T>,
Disposable {
    SingleObserver<? super T> downstream;
    Disposable upstream;

    SingleDetach.DetachSingleObserver(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        this.downstream = null;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        SingleObserver<? super T> singleObserver = this.downstream;
        if (singleObserver == null) return;
        this.downstream = null;
        singleObserver.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.upstream = DisposableHelper.DISPOSED;
        SingleObserver<? super T> singleObserver = this.downstream;
        if (singleObserver == null) return;
        this.downstream = null;
        singleObserver.onSuccess(t);
    }
}
