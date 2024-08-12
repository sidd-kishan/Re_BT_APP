/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.processors.ReplayProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.ReplayProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ReplayProcessor.ReplaySubscription<T>
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final Subscriber<? super T> downstream;
    long emitted;
    Object index;
    final AtomicLong requested;
    final ReplayProcessor<T> state;

    ReplayProcessor.ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
        this.downstream = subscriber;
        this.state = replayProcessor;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.state.remove(this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.state.buffer.replay(this);
    }
}
