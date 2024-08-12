/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    public void cancel() {
        if (this.done) return;
        SubscriptionHelper.cancel(this.upstream);
    }

    public void onComplete() {
        this.done = true;
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        this.done = true;
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Subscription subscription) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe((Subscription)this);
            SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
        } else {
            subscription.cancel();
            this.cancel();
            this.onError(new IllegalStateException("\u00a72.12 violated: onSubscribe must be called at most once"));
        }
    }

    public void request(long l) {
        if (l <= 0L) {
            this.cancel();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\u00a73.9 violated: positive request amount required but it was ");
            stringBuilder.append(l);
            this.onError(new IllegalArgumentException(stringBuilder.toString()));
        } else {
            SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
        }
    }
}
