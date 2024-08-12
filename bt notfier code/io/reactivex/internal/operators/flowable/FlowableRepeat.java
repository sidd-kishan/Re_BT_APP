/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableRepeat$RepeatSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T>
extends AbstractFlowableWithUpstream<T, T> {
    final long count;

    public FlowableRepeat(Flowable<T> flowable, long l) {
        super(flowable);
        this.count = l;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe((Subscription)subscriptionArbiter);
        long l = this.count;
        long l2 = Long.MAX_VALUE;
        if (l != Long.MAX_VALUE) {
            l2 = l - 1L;
        }
        new RepeatSubscriber(subscriber, l2, subscriptionArbiter, (Publisher)this.source).subscribeNext();
    }
}
