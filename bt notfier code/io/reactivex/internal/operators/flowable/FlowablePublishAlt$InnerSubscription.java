/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublishAlt.InnerSubscription<T>
extends AtomicLong
implements Subscription {
    private static final long serialVersionUID = 2845000326761540265L;
    final Subscriber<? super T> downstream;
    long emitted;
    final FlowablePublishAlt.PublishConnection<T> parent;

    FlowablePublishAlt.InnerSubscription(Subscriber<? super T> subscriber, FlowablePublishAlt.PublishConnection<T> publishConnection) {
        this.downstream = subscriber;
        this.parent = publishConnection;
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
        BackpressureHelper.addCancel((AtomicLong)this, (long)l);
        this.parent.drain();
    }
}
