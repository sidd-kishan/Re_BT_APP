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

static final class CompletableHide.HideCompletableObserver
implements CompletableObserver,
Disposable {
    final CompletableObserver downstream;
    Disposable upstream;

    CompletableHide.HideCompletableObserver(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
