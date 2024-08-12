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

static final class SingleFlatMap.SingleFlatMapCallback.FlatMapSingleObserver<R>
implements SingleObserver<R> {
    final SingleObserver<? super R> downstream;
    final AtomicReference<Disposable> parent;

    SingleFlatMap.SingleFlatMapCallback.FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
        this.parent = atomicReference;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.parent, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.downstream.onSuccess(r);
    }
}
