/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTakeUntil.TakeUntilMainSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -4945480365982832967L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    final OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    FlowableTakeUntil.TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
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
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }
}
