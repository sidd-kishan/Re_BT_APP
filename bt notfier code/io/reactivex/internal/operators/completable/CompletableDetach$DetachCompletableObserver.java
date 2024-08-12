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

static final class CompletableDetach.DetachCompletableObserver
implements CompletableObserver,
Disposable {
    CompletableObserver downstream;
    Disposable upstream;

    CompletableDetach.DetachCompletableObserver(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        this.downstream = null;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        CompletableObserver completableObserver = this.downstream;
        if (completableObserver == null) return;
        this.downstream = null;
        completableObserver.onComplete();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        CompletableObserver completableObserver = this.downstream;
        if (completableObserver == null) return;
        this.downstream = null;
        completableObserver.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
