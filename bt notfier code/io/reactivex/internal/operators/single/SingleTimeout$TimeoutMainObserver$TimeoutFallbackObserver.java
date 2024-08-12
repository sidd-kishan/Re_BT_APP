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
import java.util.concurrent.atomic.AtomicReference;

static final class SingleTimeout.TimeoutMainObserver.TimeoutFallbackObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T> {
    private static final long serialVersionUID = 2071387740092105509L;
    final SingleObserver<? super T> downstream;

    SingleTimeout.TimeoutMainObserver.TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
