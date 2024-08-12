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
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSkipLast.SkipLastSubscriber<T>
extends ArrayDeque<T>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -3807491841935125653L;
    final Subscriber<? super T> downstream;
    final int skip;
    Subscription upstream;

    FlowableSkipLast.SkipLastSubscriber(Subscriber<? super T> subscriber, int n) {
        super(n);
        this.downstream = subscriber;
        this.skip = n;
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
        if (this.skip == this.size()) {
            this.downstream.onNext(this.poll());
        } else {
            this.upstream.request(1L);
        }
        this.offer(t);
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
