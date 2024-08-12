/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableIgnoreElements.IgnoreElementsSubscriber<T>
implements FlowableSubscriber<T>,
QueueSubscription<T> {
    final Subscriber<? super T> downstream;
    Subscription upstream;

    FlowableIgnoreElements.IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public T poll() {
        return null;
    }

    public void request(long l) {
    }

    public int requestFusion(int n) {
        return n & 2;
    }
}
