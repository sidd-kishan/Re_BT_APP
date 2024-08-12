/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilOtherSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleTakeUntil.TakeUntilMainObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = -622603812305745221L;
    final SingleObserver<? super T> downstream;
    final SingleTakeUntil.TakeUntilOtherSubscriber other;

    SingleTakeUntil.TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
        this.other = new SingleTakeUntil.TakeUntilOtherSubscriber(this);
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.other.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onError(Throwable throwable) {
        this.other.dispose();
        if ((Disposable)this.get() != DisposableHelper.DISPOSED && (Disposable)this.getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.downstream.onError(throwable);
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.other.dispose();
        if ((Disposable)this.getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) return;
        this.downstream.onSuccess(t);
    }

    void otherError(Throwable throwable) {
        Disposable disposable;
        if ((Disposable)this.get() != DisposableHelper.DISPOSED && (disposable = (Disposable)this.getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
            if (disposable != null) {
                disposable.dispose();
            }
            this.downstream.onError(throwable);
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }
}
