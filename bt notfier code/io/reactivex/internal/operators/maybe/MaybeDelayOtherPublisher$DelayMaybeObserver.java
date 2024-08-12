/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher$OtherSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;

static final class MaybeDelayOtherPublisher.DelayMaybeObserver<T, U>
implements MaybeObserver<T>,
Disposable {
    final MaybeDelayOtherPublisher.OtherSubscriber<T> other;
    final Publisher<U> otherSource;
    Disposable upstream;

    MaybeDelayOtherPublisher.DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, Publisher<U> publisher) {
        this.other = new MaybeDelayOtherPublisher.OtherSubscriber(maybeObserver);
        this.otherSource = publisher;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        SubscriptionHelper.cancel(this.other);
    }

    public boolean isDisposed() {
        boolean bl = this.other.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.upstream = DisposableHelper.DISPOSED;
        this.subscribeNext();
    }

    public void onError(Throwable throwable) {
        this.upstream = DisposableHelper.DISPOSED;
        this.other.error = throwable;
        this.subscribeNext();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.other.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.upstream = DisposableHelper.DISPOSED;
        this.other.value = t;
        this.subscribeNext();
    }

    void subscribeNext() {
        this.otherSource.subscribe(this.other);
    }
}
