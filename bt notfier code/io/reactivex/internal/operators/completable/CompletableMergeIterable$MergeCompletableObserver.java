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

static final class CompletableMergeIterable.MergeCompletableObserver
extends AtomicBoolean
implements CompletableObserver {
    private static final long serialVersionUID = -7730517613164279224L;
    final CompletableObserver downstream;
    final CompositeDisposable set;
    final AtomicInteger wip;

    CompletableMergeIterable.MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
        this.downstream = completableObserver;
        this.set = compositeDisposable;
        this.wip = atomicInteger;
    }

    public void onComplete() {
        if (this.wip.decrementAndGet() != 0) return;
        if (!this.compareAndSet(false, true)) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.set.dispose();
        if (this.compareAndSet(false, true)) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }
}
