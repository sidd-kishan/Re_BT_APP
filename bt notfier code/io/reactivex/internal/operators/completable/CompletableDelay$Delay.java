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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableDelay.Delay
extends AtomicReference<Disposable>
implements CompletableObserver,
Runnable,
Disposable {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final CompletableObserver downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;

    CompletableDelay.Delay(CompletableObserver completableObserver, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        this.downstream = completableObserver;
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = bl;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.scheduler.scheduleDirect((Runnable)this, this.delay, this.unit));
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        throwable = this.scheduler;
        long l = this.delayError ? this.delay : 0L;
        DisposableHelper.replace((AtomicReference)this, (Disposable)throwable.scheduleDirect(this, l, this.unit));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        Throwable throwable = this.error;
        this.error = null;
        if (throwable != null) {
            this.downstream.onError(throwable);
        } else {
            this.downstream.onComplete();
        }
    }
}
