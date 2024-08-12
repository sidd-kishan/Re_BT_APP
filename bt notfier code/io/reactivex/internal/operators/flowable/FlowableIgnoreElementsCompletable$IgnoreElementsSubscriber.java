/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

static final class FlowableIgnoreElementsCompletable.IgnoreElementsSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    final CompletableObserver downstream;
    Subscription upstream;

    FlowableIgnoreElementsCompletable.IgnoreElementsSubscriber(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
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
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.upstream = SubscriptionHelper.CANCELLED;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
