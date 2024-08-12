/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class FlowableSamplePublisher.SamplePublisherSubscriber<T>
extends AtomicReference<T>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> other;
    final AtomicLong requested = new AtomicLong();
    final Publisher<?> sampler;
    Subscription upstream;

    FlowableSamplePublisher.SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
        this.other = new AtomicReference();
        this.downstream = subscriber;
        this.sampler = publisher;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        this.completion();
    }

    abstract void completion();

    void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 == null) return;
        if (this.requested.get() != 0L) {
            this.downstream.onNext(var1_1);
            BackpressureHelper.produced((AtomicLong)this.requested, (long)1L);
        } else {
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    public void error(Throwable throwable) {
        this.upstream.cancel();
        this.downstream.onError(throwable);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.completion();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.lazySet(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        if (this.other.get() != null) return;
        this.sampler.subscribe((Subscriber)new FlowableSamplePublisher.SamplerSubscriber(this));
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }

    abstract void run();

    void setOther(Subscription subscription) {
        SubscriptionHelper.setOnce(this.other, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
