/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeEmitter
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.disposables.CancellableDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeCreate.Emitter<T>
extends AtomicReference<Disposable>
implements MaybeEmitter<T>,
Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final MaybeObserver<? super T> downstream;

    MaybeCreate.Emitter(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
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

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onSuccess(T var1_1) {
        block4: {
            if (this.get() == DisposableHelper.DISPOSED) return;
            var2_3 = (Disposable)this.getAndSet(DisposableHelper.DISPOSED);
            if (var2_3 == DisposableHelper.DISPOSED) return;
            if (var1_1 /* !! */  != null) ** GOTO lbl10
            try {
                var1_1 /* !! */  = this.downstream;
                var3_4 = new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
                var1_1 /* !! */ .onError((Throwable)var3_4);
                break block4;
lbl10:
                // 1 sources

                this.downstream.onSuccess(var1_1 /* !! */ );
            }
            finally {
                if (var2_3 != null) {
                    var2_3.dispose();
                }
            }
        }
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
