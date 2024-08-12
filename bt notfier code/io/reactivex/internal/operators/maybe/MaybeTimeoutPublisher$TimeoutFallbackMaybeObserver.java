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

static final class MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeObserver<? super T> downstream;

    MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void onComplete() {
        this.downstream.onComplete();
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
