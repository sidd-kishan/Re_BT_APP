/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCache
 *  io.reactivex.internal.operators.flowable.FlowableCache$Node
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableCache.CacheSubscription<T>
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = 6770240836423125754L;
    final Subscriber<? super T> downstream;
    long index;
    FlowableCache.Node<T> node;
    int offset;
    final FlowableCache<T> parent;
    final AtomicLong requested;

    FlowableCache.CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
        this.downstream = subscriber;
        this.parent = flowableCache;
        this.node = flowableCache.head;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (this.requested.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        this.parent.remove(this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.addCancel((AtomicLong)this.requested, (long)l);
        this.parent.replay(this);
    }
}
