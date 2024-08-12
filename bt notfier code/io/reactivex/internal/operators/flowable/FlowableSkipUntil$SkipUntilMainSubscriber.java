/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSkipUntil.SkipUntilMainSubscriber<T>
extends AtomicInteger
implements ConditionalSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -6270983465606289181L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean gate;
    final OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    FlowableSkipUntil.SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.other = new OtherSubscriber(this);
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel((AtomicReference)this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel((AtomicReference)this.other);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel((AtomicReference)this.other);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        if (this.tryOnNext(t)) return;
        this.upstream.get().request(1L);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }

    public boolean tryOnNext(T t) {
        if (!this.gate) return false;
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
        return true;
    }
}
