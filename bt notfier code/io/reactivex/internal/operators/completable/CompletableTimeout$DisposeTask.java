/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.internal.operators.completable.CompletableTimeout
 *  io.reactivex.internal.operators.completable.CompletableTimeout$DisposeTask$DisposeObserver
 *  io.reactivex.internal.util.ExceptionHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

final class CompletableTimeout.DisposeTask
implements Runnable {
    final CompletableObserver downstream;
    private final AtomicBoolean once;
    final CompositeDisposable set;
    final CompletableTimeout this$0;

    CompletableTimeout.DisposeTask(CompletableTimeout completableTimeout, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
        this.this$0 = completableTimeout;
        this.once = atomicBoolean;
        this.set = compositeDisposable;
        this.downstream = completableObserver;
    }

    @Override
    public void run() {
        if (!this.once.compareAndSet(false, true)) return;
        this.set.clear();
        if (this.this$0.other == null) {
            this.downstream.onError((Throwable)new TimeoutException(ExceptionHelper.timeoutMessage((long)this.this$0.timeout, (TimeUnit)this.this$0.unit)));
        } else {
            this.this$0.other.subscribe((CompletableObserver)new DisposeObserver(this));
        }
    }
}
