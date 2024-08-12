/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber$Cancellation
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableUnsubscribeOn.UnsubscribeSubscriber<T>
extends AtomicBoolean
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 1015244841293359600L;
    final Subscriber<? super T> downstream;
    final Scheduler scheduler;
    Subscription upstream;

    FlowableUnsubscribeOn.UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
        this.downstream = subscriber;
        this.scheduler = scheduler;
    }

    public void cancel() {
        if (!this.compareAndSet(false, true)) return;
        this.scheduler.scheduleDirect((Runnable)new Cancellation(this));
    }

    public void onComplete() {
        if (this.get()) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.get()) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.get()) return;
        this.downstream.onNext(t);
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
