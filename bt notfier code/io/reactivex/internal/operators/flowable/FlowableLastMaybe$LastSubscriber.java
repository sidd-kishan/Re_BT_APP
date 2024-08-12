/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

static final class FlowableLastMaybe.LastSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    T item;
    Subscription upstream;

    FlowableLastMaybe.LastSubscriber(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void dispose() {
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    public boolean isDisposed() {
        boolean bl = this.upstream == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        T t = this.item;
        if (t != null) {
            this.item = null;
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.upstream = SubscriptionHelper.CANCELLED;
        this.item = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.item = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
