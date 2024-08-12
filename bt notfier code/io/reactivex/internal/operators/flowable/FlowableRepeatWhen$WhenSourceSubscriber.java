/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  io.reactivex.processors.FlowableProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.processors.FlowableProcessor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class FlowableRepeatWhen.WhenSourceSubscriber<T, U>
extends SubscriptionArbiter
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final Subscriber<? super T> downstream;
    protected final FlowableProcessor<U> processor;
    private long produced;
    protected final Subscription receiver;

    FlowableRepeatWhen.WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
        super(false);
        this.downstream = subscriber;
        this.processor = flowableProcessor;
        this.receiver = subscription;
    }

    protected final void again(U u) {
        this.setSubscription((Subscription)EmptySubscription.INSTANCE);
        long l = this.produced;
        if (l != 0L) {
            this.produced = 0L;
            this.produced(l);
        }
        this.receiver.request(1L);
        this.processor.onNext(u);
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public final void onNext(T t) {
        ++this.produced;
        this.downstream.onNext(t);
    }

    public final void onSubscribe(Subscription subscription) {
        this.setSubscription(subscription);
    }
}
