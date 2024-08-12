/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeUnsubscribeOn.UnsubscribeOnMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final MaybeObserver<? super T> downstream;
    Disposable ds;
    final Scheduler scheduler;

    MaybeUnsubscribeOn.UnsubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
        this.downstream = maybeObserver;
        this.scheduler = scheduler;
    }

    public void dispose() {
        Disposable disposable = (Disposable)this.getAndSet(DisposableHelper.DISPOSED);
        if (disposable == DisposableHelper.DISPOSED) return;
        this.ds = disposable;
        this.scheduler.scheduleDirect((Runnable)this);
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
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }

    @Override
    public void run() {
        this.ds.dispose();
    }
}
