/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutOtherMaybeObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = -5955289211445418871L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> fallback;
    final MaybeTimeoutPublisher.TimeoutOtherMaybeObserver<T, U> other;
    final MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T> otherObserver;

    MaybeTimeoutPublisher.TimeoutMainMaybeObserver(MaybeObserver<? super T> object, MaybeSource<? extends T> maybeSource) {
        this.downstream = object;
        this.other = new MaybeTimeoutPublisher.TimeoutOtherMaybeObserver(this);
        this.fallback = maybeSource;
        object = maybeSource != null ? new MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver(object) : null;
        this.otherObserver = object;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        SubscriptionHelper.cancel(this.other);
        MaybeTimeoutPublisher.TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.otherObserver;
        if (timeoutFallbackMaybeObserver == null) return;
        DisposableHelper.dispose(timeoutFallbackMaybeObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        if (this.getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
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
        SubscriptionHelper.cancel(this.other);
        if (this.getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) return;
        this.downstream.onSuccess(t);
    }

    public void otherComplete() {
        if (!DisposableHelper.dispose((AtomicReference)this)) return;
        MaybeSource<? extends T> maybeSource = this.fallback;
        if (maybeSource == null) {
            this.downstream.onError((Throwable)new TimeoutException());
        } else {
            maybeSource.subscribe(this.otherObserver);
        }
    }

    public void otherError(Throwable throwable) {
        if (DisposableHelper.dispose((AtomicReference)this)) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
