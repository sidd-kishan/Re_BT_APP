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

static final class CompletableAmb.Amb
implements CompletableObserver {
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final CompositeDisposable set;
    Disposable upstream;

    CompletableAmb.Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
        this.once = atomicBoolean;
        this.set = compositeDisposable;
        this.downstream = completableObserver;
    }

    public void onComplete() {
        if (!this.once.compareAndSet(false, true)) return;
        this.set.delete(this.upstream);
        this.set.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        this.set.add(disposable);
    }
}
