/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeSubscribeOn.SubscribeOnMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 8571289934935992137L;
    final MaybeObserver<? super T> downstream;
    final SequentialDisposable task;

    MaybeSubscribeOn.SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
        this.task = new SequentialDisposable();
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
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
