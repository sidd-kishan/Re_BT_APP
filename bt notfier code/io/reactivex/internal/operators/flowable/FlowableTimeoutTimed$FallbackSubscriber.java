/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeoutTimed.FallbackSubscriber<T>
implements FlowableSubscriber<T> {
    final SubscriptionArbiter arbiter;
    final Subscriber<? super T> downstream;

    FlowableTimeoutTimed.FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
        this.downstream = subscriber;
        this.arbiter = subscriptionArbiter;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.arbiter.setSubscription(subscription);
    }
}
