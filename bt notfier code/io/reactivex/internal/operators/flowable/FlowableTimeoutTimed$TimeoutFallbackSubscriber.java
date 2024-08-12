/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$FallbackSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutTask
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeoutTimed.TimeoutFallbackSubscriber<T>
extends SubscriptionArbiter
implements FlowableSubscriber<T>,
FlowableTimeoutTimed.TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final Subscriber<? super T> downstream;
    Publisher<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Subscription> upstream;
    final Scheduler.Worker worker;

    FlowableTimeoutTimed.TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
        super(true);
        this.downstream = subscriber;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.fallback = publisher;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.index = new AtomicLong();
    }

    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.worker.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.index.get();
        if (l == Long.MAX_VALUE) return;
        AtomicLong atomicLong = this.index;
        long l2 = l + 1L;
        if (!atomicLong.compareAndSet(l, l2)) return;
        ((Disposable)this.task.get()).dispose();
        ++this.consumed;
        this.downstream.onNext(t);
        this.startTimeout(l2);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        this.setSubscription(subscription);
    }

    public void onTimeout(long l) {
        if (!this.index.compareAndSet(l, Long.MAX_VALUE)) return;
        SubscriptionHelper.cancel(this.upstream);
        l = this.consumed;
        if (l != 0L) {
            this.produced(l);
        }
        Publisher<? extends T> publisher = this.fallback;
        this.fallback = null;
        publisher.subscribe((Subscriber)new FlowableTimeoutTimed.FallbackSubscriber(this.downstream, (SubscriptionArbiter)this));
        this.worker.dispose();
    }

    void startTimeout(long l) {
        this.task.replace(this.worker.schedule((Runnable)new FlowableTimeoutTimed.TimeoutTask(l, (FlowableTimeoutTimed.TimeoutSupport)this), this.timeout, this.unit));
    }
}
