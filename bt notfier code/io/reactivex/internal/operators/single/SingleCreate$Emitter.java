/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleEmitter
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.disposables.CancellableDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleCreate.Emitter<T>
extends AtomicReference<Disposable>
implements SingleEmitter<T>,
Disposable {
    private static final long serialVersionUID = -2467358622224974244L;
    final SingleObserver<? super T> downstream;

    SingleCreate.Emitter(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
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
                var3_4 = this.downstream;
                var1_1 /* !! */  = new T("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
                var3_4.onError(var1_1 /* !! */ );
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
