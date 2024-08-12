/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableEmitter
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.disposables.CancellableDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableCreate.Emitter
extends AtomicReference<Disposable>
implements CompletableEmitter,
Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final CompletableObserver downstream;

    CompletableCreate.Emitter(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.get() == DisposableHelper.DISPOSED) return;
        Disposable disposable = (Disposable)this.getAndSet(DisposableHelper.DISPOSED);
        if (disposable == DisposableHelper.DISPOSED) return;
        try {
            this.downstream.onComplete();
        }
        finally {
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public void onError(Throwable throwable) {
        if (this.tryOnError(throwable)) return;
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void setCancellable(Cancellable cancellable) {
        this.setDisposable((Disposable)new CancellableDisposable(cancellable));
    }

    public void setDisposable(Disposable disposable) {
        DisposableHelper.set((AtomicReference)this, (Disposable)disposable);
    }

    @Override
    public String toString() {
        return String.format("%s{%s}", this.getClass().getSimpleName(), super.toString());
    }

    public boolean tryOnError(Throwable throwable) {
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.get() == DisposableHelper.DISPOSED) return false;
        throwable = (Disposable)this.getAndSet(DisposableHelper.DISPOSED);
        if (throwable == DisposableHelper.DISPOSED) return false;
        try {
            this.downstream.onError(throwable2);
            return true;
        }
        finally {
            if (throwable != null) {
                throwable.dispose();
            }
        }
    }
}
