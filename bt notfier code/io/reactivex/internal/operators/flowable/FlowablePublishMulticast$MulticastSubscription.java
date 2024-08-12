/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastProcessor
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublishMulticast.MulticastSubscription<T>
extends AtomicLong
implements Subscription {
    private static final long serialVersionUID = 8664815189257569791L;
    final Subscriber<? super T> downstream;
    long emitted;
    final FlowablePublishMulticast.MulticastProcessor<T> parent;

    FlowablePublishMulticast.MulticastSubscription(Subscriber<? super T> subscriber, FlowablePublishMulticast.MulticastProcessor<T> multicastProcessor) {
        this.downstream = subscriber;
        this.parent = multicastProcessor;
    }

    public void cancel() {
        if (this.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        this.parent.remove(this);
        this.parent.drain();
    }

    public boolean isCancelled() {
        boolean bl = this.get() == Long.MIN_VALUE;
        return bl;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.addCancel((AtomicLong)this, (long)l);
        this.parent.drain();
    }
}
