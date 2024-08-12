/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnComplete
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnError
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnNext
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDelay.DelaySubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final long delay;
    final boolean delayError;
    final Subscriber<? super T> downstream;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;

    FlowableDelay.DelaySubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker, boolean bl) {
        this.downstream = subscriber;
        this.delay = l;
        this.unit = timeUnit;
        this.w = worker;
        this.delayError = bl;
    }

    public void cancel() {
        this.upstream.cancel();
        this.w.dispose();
    }

    public void onComplete() {
        this.w.schedule((Runnable)new OnComplete(this), this.delay, this.unit);
    }

    public void onError(Throwable throwable) {
        Scheduler.Worker worker = this.w;
        throwable = new OnError(this, throwable);
        long l = this.delayError ? this.delay : 0L;
        worker.schedule((Runnable)((Object)throwable), l, this.unit);
    }

    public void onNext(T t) {
        this.w.schedule((Runnable)new OnNext(this, t), this.delay, this.unit);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
