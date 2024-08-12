/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableReplay.InnerSubscription<T>
extends AtomicLong
implements Subscription,
Disposable {
    static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final FlowableReplay.ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;

    FlowableReplay.InnerSubscription(FlowableReplay.ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
        this.parent = replaySubscriber;
        this.child = subscriber;
        this.totalRequested = new AtomicLong();
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        if (this.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        this.parent.remove(this);
        this.parent.manageRequests();
        this.index = null;
    }

    <U> U index() {
        return (U)this.index;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == Long.MIN_VALUE;
        return bl;
    }

    public long produced(long l) {
        return BackpressureHelper.producedCancel((AtomicLong)this, (long)l);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        if (BackpressureHelper.addCancel((AtomicLong)this, (long)l) == Long.MIN_VALUE) return;
        BackpressureHelper.add((AtomicLong)this.totalRequested, (long)l);
        this.parent.manageRequests();
        this.parent.buffer.replay(this);
    }
}
