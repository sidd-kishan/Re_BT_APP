/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleUnsubscribeOn.UnsubscribeOnSingleObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final SingleObserver<? super T> downstream;
    Disposable ds;
    final Scheduler scheduler;

    SingleUnsubscribeOn.UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
        this.downstream = singleObserver;
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
