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

static final class MaybeObserveOn.ObserveOnMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    T value;

    MaybeObserveOn.ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
        this.downstream = maybeObserver;
        this.scheduler = scheduler;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.scheduler.scheduleDirect((Runnable)this));
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
            this.error = null;
            this.downstream.onError(throwable);
        } else {
            throwable = this.value;
            if (throwable != null) {
                this.value = null;
                this.downstream.onSuccess((Object)throwable);
            } else {
                this.downstream.onComplete();
            }
        }
    }
}
