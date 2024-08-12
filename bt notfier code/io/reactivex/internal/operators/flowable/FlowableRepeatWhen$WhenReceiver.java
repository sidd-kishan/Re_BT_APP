/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

static final class FlowableRepeatWhen.WhenReceiver<T, U>
extends AtomicInteger
implements FlowableSubscriber<Object>,
Subscription {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested;
    final Publisher<T> source;
    FlowableRepeatWhen.WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<Subscription> upstream;

    FlowableRepeatWhen.WhenReceiver(Publisher<T> publisher) {
        this.source = publisher;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        if (this.getAndIncrement() != 0) return;
        do {
            if (this.upstream.get() == SubscriptionHelper.CANCELLED) {
                return;
            }
            this.source.subscribe(this.subscriber);
        } while (this.decrementAndGet() != 0);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }
}
