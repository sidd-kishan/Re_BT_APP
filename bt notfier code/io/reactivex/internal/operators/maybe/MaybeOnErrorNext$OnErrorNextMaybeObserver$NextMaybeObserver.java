/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeOnErrorNext.OnErrorNextMaybeObserver.NextMaybeObserver<T>
implements MaybeObserver<T> {
    final MaybeObserver<? super T> downstream;
    final AtomicReference<Disposable> upstream;

    MaybeOnErrorNext.OnErrorNextMaybeObserver.NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
        this.downstream = maybeObserver;
        this.upstream = atomicReference;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
