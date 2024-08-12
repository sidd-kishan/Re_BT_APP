/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastProcessor
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublishMulticast.OutputCanceller<R>
implements FlowableSubscriber<R>,
Subscription {
    final Subscriber<? super R> downstream;
    final FlowablePublishMulticast.MulticastProcessor<?> processor;
    Subscription upstream;

    FlowablePublishMulticast.OutputCanceller(Subscriber<? super R> subscriber, FlowablePublishMulticast.MulticastProcessor<?> multicastProcessor) {
        this.downstream = subscriber;
        this.processor = multicastProcessor;
    }

    public void cancel() {
        this.upstream.cancel();
        this.processor.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.processor.dispose();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.processor.dispose();
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
