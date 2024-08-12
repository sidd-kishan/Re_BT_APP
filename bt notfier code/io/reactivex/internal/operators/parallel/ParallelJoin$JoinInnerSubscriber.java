/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class ParallelJoin.JoinInnerSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin.JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile SimplePlainQueue<T> queue;

    ParallelJoin.JoinInnerSubscriber(ParallelJoin.JoinSubscriptionBase<T> joinSubscriptionBase, int n) {
        this.parent = joinSubscriptionBase;
        this.prefetch = n;
        this.limit = n - (n >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel((AtomicReference)this);
    }

    SimplePlainQueue<T> getQueue() {
        SpscArrayQueue spscArrayQueue;
        SpscArrayQueue spscArrayQueue2 = spscArrayQueue = this.queue;
        if (spscArrayQueue != null) return spscArrayQueue2;
        this.queue = spscArrayQueue2 = new SpscArrayQueue(this.prefetch);
        return spscArrayQueue2;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.onError(throwable);
    }

    public void onNext(T t) {
        this.parent.onNext(this, t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)this.prefetch);
    }

    public void request(long l) {
        if ((l = this.produced + l) >= (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }

    public void requestOne() {
        long l = this.produced + 1L;
        if (l == (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }
}
