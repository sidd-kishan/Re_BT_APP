/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class ParallelJoin.JoinSubscriptionBase<T>
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = 3100232009247827843L;
    volatile boolean cancelled;
    final AtomicInteger done;
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final ParallelJoin.JoinInnerSubscriber<T>[] subscribers;

    ParallelJoin.JoinSubscriptionBase(Subscriber<? super T> joinInnerSubscriberArray, int n, int n2) {
        this.done = new AtomicInteger();
        this.downstream = joinInnerSubscriberArray;
        joinInnerSubscriberArray = new ParallelJoin.JoinInnerSubscriber[n];
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                this.subscribers = joinInnerSubscriberArray;
                this.done.lazySet(n);
                return;
            }
            joinInnerSubscriberArray[n3] = new ParallelJoin.JoinInnerSubscriber(this, n2);
            ++n3;
        }
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelAll();
        if (this.getAndIncrement() != 0) return;
        this.cleanup();
    }

    void cancelAll() {
        ParallelJoin.JoinInnerSubscriber<T>[] joinInnerSubscriberArray = this.subscribers;
        int n = joinInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            joinInnerSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    void cleanup() {
        ParallelJoin.JoinInnerSubscriber<T>[] joinInnerSubscriberArray = this.subscribers;
        int n = joinInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            joinInnerSubscriberArray[n2].queue = null;
            ++n2;
        }
    }

    abstract void drain();

    abstract void onComplete();

    abstract void onError(Throwable var1);

    abstract void onNext(ParallelJoin.JoinInnerSubscriber<T> var1, T var2);

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
