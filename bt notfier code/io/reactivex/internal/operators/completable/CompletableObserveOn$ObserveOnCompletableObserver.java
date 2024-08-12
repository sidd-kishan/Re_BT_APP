/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableObserveOn.ObserveOnCompletableObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable,
Runnable {
    private static final long serialVersionUID = 8571289934935992137L;
    final CompletableObserver downstream;
    Throwable error;
    final Scheduler scheduler;

    CompletableObserveOn.ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
        this.downstream = completableObserver;
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

    @Override
    public void run() {
        Throwable throwable = this.error;
        if (throwable != null) {
            this.error = null;
            this.downstream.onError(throwable);
        } else {
            this.downstream.onComplete();
        }
    }
}
