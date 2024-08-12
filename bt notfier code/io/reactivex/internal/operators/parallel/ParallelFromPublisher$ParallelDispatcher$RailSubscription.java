/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscription;

final class ParallelFromPublisher.ParallelDispatcher.RailSubscription
implements Subscription {
    final int j;
    final int m;
    final ParallelFromPublisher.ParallelDispatcher this$0;

    ParallelFromPublisher.ParallelDispatcher.RailSubscription(ParallelFromPublisher.ParallelDispatcher parallelDispatcher, int n, int n2) {
        this.this$0 = parallelDispatcher;
        this.j = n;
        this.m = n2;
    }

    public void cancel() {
        AtomicLongArray atomicLongArray = this.this$0.requests;
        int n = this.m;
        if (!atomicLongArray.compareAndSet(this.j + n, 0L, 1L)) return;
        atomicLongArray = this.this$0;
        n = this.m;
        atomicLongArray.cancel(n + n);
    }

    public void request(long l) {
        long l2;
        long l3;
        if (!SubscriptionHelper.validate((long)l)) return;
        AtomicLongArray atomicLongArray = this.this$0.requests;
        do {
            if ((l3 = atomicLongArray.get(this.j)) != Long.MAX_VALUE) continue;
            return;
        } while (!atomicLongArray.compareAndSet(this.j, l3, l2 = BackpressureHelper.addCap((long)l3, (long)l)));
        if (this.this$0.subscriberCount.get() != this.m) return;
        this.this$0.drain();
    }
}
