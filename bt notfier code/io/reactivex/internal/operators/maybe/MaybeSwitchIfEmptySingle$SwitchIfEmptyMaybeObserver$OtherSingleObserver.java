/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver.OtherSingleObserver<T>
implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final AtomicReference<Disposable> parent;

    MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver.OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
        this.downstream = singleObserver;
        this.parent = atomicReference;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.parent, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
