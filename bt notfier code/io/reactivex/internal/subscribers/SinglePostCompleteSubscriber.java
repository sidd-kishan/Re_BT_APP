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
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> downstream;
    protected long produced;
    protected Subscription upstream;
    protected R value;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    protected final void complete(R r) {
        long l = this.produced;
        if (l != 0L) {
            BackpressureHelper.produced((AtomicLong)this, (long)l);
        }
        while (true) {
            if (((l = this.get()) & Long.MIN_VALUE) != 0L) {
                this.onDrop(r);
                return;
            }
            if ((l & Long.MAX_VALUE) != 0L) {
                this.lazySet(-9223372036854775807L);
                this.downstream.onNext(r);
                this.downstream.onComplete();
                return;
            }
            this.value = r;
            if (this.compareAndSet(0L, Long.MIN_VALUE)) {
                return;
            }
            this.value = null;
        }
    }

    protected void onDrop(R r) {
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public final void request(long l) {
        block1: {
            long l2;
            if (!SubscriptionHelper.validate((long)l)) return;
            do {
                if (((l2 = this.get()) & Long.MIN_VALUE) == 0L) continue;
                if (!this.compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) return;
                this.downstream.onNext(this.value);
                this.downstream.onComplete();
                break block1;
            } while (!this.compareAndSet(l2, BackpressureHelper.addCap((long)l2, (long)l)));
            this.upstream.request(l);
        }
    }
}
