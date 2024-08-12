/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutConsumer
 *  io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutSelectorSupport
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$FallbackSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeout.TimeoutFallbackSubscriber<T>
extends SubscriptionArbiter
implements FlowableSubscriber<T>,
FlowableTimeout.TimeoutSelectorSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final Subscriber<? super T> downstream;
    Publisher<? extends T> fallback;
    final AtomicLong index;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;

    FlowableTimeout.TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
        super(true);
        this.downstream = subscriber;
        this.itemTimeoutIndicator = function;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.fallback = publisher;
        this.index = new AtomicLong();
    }

    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.task.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.task.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block3: {
            long l = this.index.get();
            if (l == Long.MAX_VALUE) return;
            AtomicLong atomicLong = this.index;
            long l2 = l + 1L;
            if (!atomicLong.compareAndSet(l, l2)) return;
            atomicLong = (Disposable)this.task.get();
            if (atomicLong != null) {
                atomicLong.dispose();
            }
            ++this.consumed;
            this.downstream.onNext(object);
            try {
                object = (Publisher)ObjectHelper.requireNonNull((Object)this.itemTimeoutIndicator.apply(object), (String)"The itemTimeoutIndicator returned a null Publisher.");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.get().cancel();
                this.index.getAndSet(Long.MAX_VALUE);
                this.downstream.onError(throwable);
                break block3;
            }
            atomicLong = new FlowableTimeout.TimeoutConsumer(l2, (FlowableTimeout.TimeoutSelectorSupport)this);
            if (!this.task.replace((Disposable)atomicLong)) return;
            object.subscribe((Subscriber)atomicLong);
            return;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        this.setSubscription(subscription);
    }

    public void onTimeout(long l) {
        if (!this.index.compareAndSet(l, Long.MAX_VALUE)) return;
        SubscriptionHelper.cancel(this.upstream);
        Publisher<? extends T> publisher = this.fallback;
        this.fallback = null;
        l = this.consumed;
        if (l != 0L) {
            this.produced(l);
        }
        publisher.subscribe((Subscriber)new FlowableTimeoutTimed.FallbackSubscriber(this.downstream, (SubscriptionArbiter)this));
    }

    public void onTimeoutError(long l, Throwable throwable) {
        if (this.index.compareAndSet(l, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void startFirstTimeout(Publisher<?> publisher) {
        if (publisher == null) return;
        FlowableTimeout.TimeoutConsumer timeoutConsumer = new FlowableTimeout.TimeoutConsumer(0L, (FlowableTimeout.TimeoutSelectorSupport)this);
        if (!this.task.replace((Disposable)timeoutConsumer)) return;
        publisher.subscribe((Subscriber)timeoutConsumer);
    }
}
