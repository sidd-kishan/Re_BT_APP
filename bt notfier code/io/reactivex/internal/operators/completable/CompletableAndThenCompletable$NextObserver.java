/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableAndThenCompletable.NextObserver
implements CompletableObserver {
    final CompletableObserver downstream;
    final AtomicReference<Disposable> parent;

    public CompletableAndThenCompletable.NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
        this.parent = atomicReference;
        this.downstream = completableObserver;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.parent, (Disposable)disposable);
    }
}
