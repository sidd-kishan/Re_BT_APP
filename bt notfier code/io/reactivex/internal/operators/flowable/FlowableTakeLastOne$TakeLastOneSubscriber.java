/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTakeLastOne.TakeLastOneSubscriber<T>
extends DeferredScalarSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -5467847744262967226L;
    Subscription upstream;

    FlowableTakeLastOne.TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        Object object = this.value;
        if (object != null) {
            this.complete(object);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.value = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
