/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

static final class MaybeToSingle.ToSingleMaybeSubscriber<T>
implements MaybeObserver<T>,
Disposable {
    final T defaultValue;
    final SingleObserver<? super T> downstream;
    Disposable upstream;

    MaybeToSingle.ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
        this.downstream = singleObserver;
        this.defaultValue = t;
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
        T t = this.defaultValue;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onError((Throwable)new NoSuchElementException("The MaybeSource is empty"));
        }
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onSuccess(t);
    }
}
