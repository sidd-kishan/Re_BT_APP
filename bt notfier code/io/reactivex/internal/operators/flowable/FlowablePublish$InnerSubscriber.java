/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublish.InnerSubscriber<T>
extends AtomicLong
implements Subscription {
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    long emitted;
    volatile FlowablePublish.PublishSubscriber<T> parent;

    FlowablePublish.InnerSubscriber(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    public void cancel() {
        if (this.get() == Long.MIN_VALUE) return;
        if (this.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        FlowablePublish.PublishSubscriber<T> publishSubscriber = this.parent;
        if (publishSubscriber == null) return;
        publishSubscriber.remove(this);
        publishSubscriber.dispatch();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.addCancel((AtomicLong)this, (long)l);
        FlowablePublish.PublishSubscriber<T> publishSubscriber = this.parent;
        if (publishSubscriber == null) return;
        publishSubscriber.dispatch();
    }
}
