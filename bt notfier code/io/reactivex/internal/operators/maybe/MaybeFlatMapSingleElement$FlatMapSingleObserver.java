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
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeFlatMapSingleElement.FlatMapSingleObserver<R>
implements SingleObserver<R> {
    final MaybeObserver<? super R> downstream;
    final AtomicReference<Disposable> parent;

    MaybeFlatMapSingleElement.FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
        this.parent = atomicReference;
        this.downstream = maybeObserver;
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
