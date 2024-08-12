/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

static final class CompletableDisposeOn.DisposeOnObserver
implements CompletableObserver,
Disposable,
Runnable {
    volatile boolean disposed;
    final CompletableObserver downstream;
    final Scheduler scheduler;
    Disposable upstream;

    CompletableDisposeOn.DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
        this.downstream = completableObserver;
        this.scheduler = scheduler;
    }

    public void dispose() {
        this.disposed = true;
        this.scheduler.scheduleDirect((Runnable)this);
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        if (this.disposed) {
            return;
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.disposed) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }
}
