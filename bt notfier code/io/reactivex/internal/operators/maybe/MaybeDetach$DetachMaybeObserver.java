/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class MaybeDetach.DetachMaybeObserver<T>
implements MaybeObserver<T>,
Disposable {
    MaybeObserver<? super T> downstream;
    Disposable upstream;

    MaybeDetach.DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
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
        MaybeObserver<? super T> maybeObserver = this.downstream;
        if (maybeObserver == null) return;
        this.downstream = null;
        maybeObserver.onComplete();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        MaybeObserver<? super T> maybeObserver = this.downstream;
        if (maybeObserver == null) return;
        this.downstream = null;
        maybeObserver.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.upstream = DisposableHelper.DISPOSED;
        MaybeObserver<? super T> maybeObserver = this.downstream;
        if (maybeObserver == null) return;
        this.downstream = null;
        maybeObserver.onSuccess(t);
    }
}