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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeDelay.DelayMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;
    T value;

    MaybeDelay.DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = maybeObserver;
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.schedule();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.schedule();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.value = t;
        this.schedule();
    }

    @Override
    public void run() {
        Throwable throwable = this.error;
        if (throwable != null) {
            this.downstream.onError(throwable);
        } else {
            throwable = this.value;
            if (throwable != null) {
                this.downstream.onSuccess((Object)throwable);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    void schedule() {
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.scheduler.scheduleDirect((Runnable)this, this.delay, this.unit));
    }
}
