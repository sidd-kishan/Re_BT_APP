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

static final class SingleObserveOn.ObserveOnSingleObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 3528003840217436037L;
    final SingleObserver<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    T value;

    SingleObserveOn.ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
        this.downstream = singleObserver;
        this.scheduler = scheduler;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.scheduler.scheduleDirect((Runnable)this));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.scheduler.scheduleDirect((Runnable)this));
    }

    @Override
    public void run() {
        Throwable throwable = this.error;
        if (throwable != null) {
            this.downstream.onError(throwable);
        } else {
            this.downstream.onSuccess(this.value);
        }
    }
}
