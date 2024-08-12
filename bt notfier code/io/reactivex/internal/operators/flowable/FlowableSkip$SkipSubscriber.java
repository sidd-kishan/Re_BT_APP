/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSkip.SkipSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final Subscriber<? super T> downstream;
    long remaining;
    Subscription upstream;

    FlowableSkip.SkipSubscriber(Subscriber<? super T> subscriber, long l) {
        this.downstream = subscriber;
        this.remaining = l;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l = this.remaining;
        if (l != 0L) {
            this.remaining = l - 1L;
        } else {
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        long l = this.remaining;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(l);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
