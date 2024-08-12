/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableLimit.LimitSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 2288246011222124525L;
    final Subscriber<? super T> downstream;
    long remaining;
    Subscription upstream;

    FlowableLimit.LimitSubscriber(Subscriber<? super T> subscriber, long l) {
        this.downstream = subscriber;
        this.remaining = l;
        this.lazySet(l);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.remaining <= 0L) return;
        this.remaining = 0L;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.remaining > 0L) {
            this.remaining = 0L;
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.remaining;
        if (l <= 0L) return;
        this.remaining = --l;
        this.downstream.onNext(t);
        if (l != 0L) return;
        this.upstream.cancel();
        this.downstream.onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        if (this.remaining == 0L) {
            subscription.cancel();
            EmptySubscription.complete(this.downstream);
        } else {
            this.upstream = subscription;
            this.downstream.onSubscribe((Subscription)this);
        }
    }

    public void request(long l) {
        long l2;
        if (!SubscriptionHelper.validate((long)l)) return;
        while ((l2 = this.get()) != 0L) {
            long l3 = l2 <= l ? l2 : l;
            if (!this.compareAndSet(l2, l2 - l3)) continue;
            this.upstream.request(l3);
            break;
        }
    }
}
