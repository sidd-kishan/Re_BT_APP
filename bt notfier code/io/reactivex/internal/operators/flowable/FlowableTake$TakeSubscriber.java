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
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTake.TakeSubscriber<T>
extends AtomicBoolean
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -5636543848937116287L;
    boolean done;
    final Subscriber<? super T> downstream;
    final long limit;
    long remaining;
    Subscription upstream;

    FlowableTake.TakeSubscriber(Subscriber<? super T> subscriber, long l) {
        this.downstream = subscriber;
        this.limit = l;
        this.remaining = l;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (!this.done) {
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l;
        if (this.done) return;
        long l2 = this.remaining;
        this.remaining = l = l2 - 1L;
        if (l2 <= 0L) return;
        boolean bl = l == 0L;
        this.downstream.onNext(t);
        if (!bl) return;
        this.upstream.cancel();
        this.onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (this.limit == 0L) {
            subscription.cancel();
            this.done = true;
            EmptySubscription.complete(this.downstream);
        } else {
            this.downstream.onSubscribe((Subscription)this);
        }
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) {
            return;
        }
        if (!this.get() && this.compareAndSet(false, true) && l >= this.limit) {
            this.upstream.request(Long.MAX_VALUE);
            return;
        }
        this.upstream.request(l);
    }
}
