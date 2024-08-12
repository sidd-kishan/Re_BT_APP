/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber$Request
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSubscribeOn.SubscribeOnSubscriber<T>
extends AtomicReference<Thread>
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    final Subscriber<? super T> downstream;
    final boolean nonScheduledRequests;
    final AtomicLong requested;
    Publisher<T> source;
    final AtomicReference<Subscription> upstream;
    final Scheduler.Worker worker;

    FlowableSubscribeOn.SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean bl) {
        this.downstream = subscriber;
        this.worker = worker;
        this.source = publisher;
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
        this.nonScheduledRequests = bl ^ true;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        long l = this.requested.getAndSet(0L);
        if (l == 0L) return;
        this.requestUpstream(l, subscription);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        Subscription subscription = this.upstream.get();
        if (subscription != null) {
            this.requestUpstream(l, subscription);
        } else {
            BackpressureHelper.add((AtomicLong)this.requested, (long)l);
            subscription = this.upstream.get();
            if (subscription == null) return;
            l = this.requested.getAndSet(0L);
            if (l == 0L) return;
            this.requestUpstream(l, subscription);
        }
    }

    void requestUpstream(long l, Subscription subscription) {
        if (!this.nonScheduledRequests && Thread.currentThread() != this.get()) {
            this.worker.schedule((Runnable)new Request(subscription, l));
        } else {
            subscription.request(l);
        }
    }

    @Override
    public void run() {
        this.lazySet(Thread.currentThread());
        Publisher<T> publisher = this.source;
        this.source = null;
        publisher.subscribe((Subscriber)this);
    }
}
