/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class CompletableTimeout.TimeOutObserver
implements CompletableObserver {
    private final CompletableObserver downstream;
    private final AtomicBoolean once;
    private final CompositeDisposable set;

    CompletableTimeout.TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
        this.set = compositeDisposable;
        this.once = atomicBoolean;
        this.downstream = completableObserver;
    }

    public void onComplete() {
        if (!this.once.compareAndSet(false, true)) return;
        this.set.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            this.set.dispose();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }
}
