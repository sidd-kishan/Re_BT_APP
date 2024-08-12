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
import java.util.concurrent.atomic.AtomicInteger;

static final class CompletableMergeArray.InnerCompletableObserver
extends AtomicInteger
implements CompletableObserver {
    private static final long serialVersionUID = -8360547806504310570L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final CompositeDisposable set;

    CompletableMergeArray.InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int n) {
        this.downstream = completableObserver;
        this.once = atomicBoolean;
        this.set = compositeDisposable;
        this.lazySet(n);
    }

    public void onComplete() {
        if (this.decrementAndGet() != 0) return;
        if (!this.once.compareAndSet(false, true)) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }
}
