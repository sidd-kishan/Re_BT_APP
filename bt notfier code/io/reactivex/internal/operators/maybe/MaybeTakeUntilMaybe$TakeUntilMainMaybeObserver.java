/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver<T, U>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = -2187421758664251153L;
    final MaybeObserver<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;

    MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
        this.other = new TakeUntilOtherMaybeObserver(this);
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        DisposableHelper.dispose(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        if (this.getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        if (this.getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        DisposableHelper.dispose(this.other);
        if (this.getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) return;
        this.downstream.onSuccess(t);
    }

    void otherComplete() {
        if (!DisposableHelper.dispose((AtomicReference)this)) return;
        this.downstream.onComplete();
    }

    void otherError(Throwable throwable) {
        if (DisposableHelper.dispose((AtomicReference)this)) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
