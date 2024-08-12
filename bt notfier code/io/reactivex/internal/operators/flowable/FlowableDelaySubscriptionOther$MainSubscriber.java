/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDelaySubscriptionOther.MainSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 2259811067697317255L;
    final Subscriber<? super T> downstream;
    final Publisher<? extends T> main;
    final OtherSubscriber other;
    final AtomicReference<Subscription> upstream;

    FlowableDelaySubscriptionOther.MainSubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.main = publisher;
        this.other = new OtherSubscriber(this);
        this.upstream = new AtomicReference();
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    void next() {
        this.main.subscribe((Subscriber)this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this, (Subscription)subscription);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this, (long)l);
    }
}
