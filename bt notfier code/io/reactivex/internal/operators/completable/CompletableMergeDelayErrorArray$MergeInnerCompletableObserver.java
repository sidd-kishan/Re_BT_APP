/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class CompletableMergeDelayErrorArray.MergeInnerCompletableObserver
implements CompletableObserver {
    final CompletableObserver downstream;
    final AtomicThrowable error;
    final CompositeDisposable set;
    final AtomicInteger wip;

    CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
        this.downstream = completableObserver;
        this.set = compositeDisposable;
        this.error = atomicThrowable;
        this.wip = atomicInteger;
    }

    public void onComplete() {
        this.tryTerminate();
    }

    public void onError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            this.tryTerminate();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }

    void tryTerminate() {
        if (this.wip.decrementAndGet() != 0) return;
        Throwable throwable = this.error.terminate();
        if (throwable == null) {
            this.downstream.onComplete();
        } else {
            this.downstream.onError(throwable);
        }
    }
}
