/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.EmptyComponent
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDetach.DetachSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    Subscriber<? super T> downstream;
    Subscription upstream;

    FlowableDetach.DetachSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        Subscription subscription = this.upstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asSubscriber();
        subscription.cancel();
    }

    public void onComplete() {
        Subscriber<? super T> subscriber = this.downstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asSubscriber();
        subscriber.onComplete();
    }

    public void onError(Throwable throwable) {
        Subscriber<? super T> subscriber = this.downstream;
        this.upstream = EmptyComponent.INSTANCE;
        this.downstream = EmptyComponent.asSubscriber();
        subscriber.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
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
