/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTakeLast.TakeLastSubscriber<T>
extends ArrayDeque<T>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    final AtomicInteger wip = new AtomicInteger();

    FlowableTakeLast.TakeLastSubscriber(Subscriber<? super T> subscriber, int n) {
        this.downstream = subscriber;
        this.count = n;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) return;
        Subscriber<? super T> subscriber = this.downstream;
        long l = this.requested.get();
        do {
            if (this.cancelled) {
                return;
            }
            long l2 = l;
            if (this.done) {
                long l3;
                for (l3 = 0L; l3 != l; ++l3) {
                    if (this.cancelled) {
                        return;
                    }
                    Object e = this.poll();
                    if (e == null) {
                        subscriber.onComplete();
                        return;
                    }
                    subscriber.onNext(e);
                }
                l2 = l;
                if (l3 != 0L) {
                    l2 = l;
                    if (l != Long.MAX_VALUE) {
                        l2 = this.requested.addAndGet(-l3);
                    }
                }
            }
            l = l2;
        } while (this.wip.decrementAndGet() != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.count == this.size()) {
            this.poll();
        }
        this.offer(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
