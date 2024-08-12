/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.schedulers.Timed
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeInterval.TimeIntervalSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final Subscriber<? super Timed<T>> downstream;
    long lastTime;
    final Scheduler scheduler;
    final TimeUnit unit;
    Subscription upstream;

    FlowableTimeInterval.TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = subscriber;
        this.scheduler = scheduler;
        this.unit = timeUnit;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l = this.scheduler.now(this.unit);
        long l2 = this.lastTime;
        this.lastTime = l;
        this.downstream.onNext((Object)new Timed(t, l - l2, this.unit));
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.lastTime = this.scheduler.now(this.unit);
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
