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
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeout.TimeoutSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription,
FlowableTimeout.TimeoutSelectorSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Subscriber<? super T> downstream;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final AtomicLong requested;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;

    FlowableTimeout.TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
        this.downstream = subscriber;
        this.itemTimeoutIndicator = function;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    public void onComplete() {
        if (this.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block3: {
            long l = this.get();
            if (l == Long.MAX_VALUE) return;
            long l2 = 1L + l;
            if (!this.compareAndSet(l, l2)) return;
            Disposable disposable = (Disposable)this.task.get();
            if (disposable != null) {
                disposable.dispose();
            }
            this.downstream.onNext(object);
            try {
                object = (Publisher)ObjectHelper.requireNonNull((Object)this.itemTimeoutIndicator.apply(object), (String)"The itemTimeoutIndicator returned a null Publisher.");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.get().cancel();
                this.getAndSet(Long.MAX_VALUE);
                this.downstream.onError(throwable);
                break block3;
            }
            disposable = new FlowableTimeout.TimeoutConsumer(l2, (FlowableTimeout.TimeoutSelectorSupport)this);
            if (!this.task.replace(disposable)) return;
            object.subscribe((Subscriber)disposable);
            return;
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void onTimeout(long l) {
        if (!this.compareAndSet(l, Long.MAX_VALUE)) return;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError((Throwable)new TimeoutException());
    }

    public void onTimeoutError(long l, Throwable throwable) {
        if (this.compareAndSet(l, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }

    void startFirstTimeout(Publisher<?> publisher) {
        if (publisher == null) return;
        FlowableTimeout.TimeoutConsumer timeoutConsumer = new FlowableTimeout.TimeoutConsumer(0L, (FlowableTimeout.TimeoutSelectorSupport)this);
        if (!this.task.replace((Disposable)timeoutConsumer)) return;
        publisher.subscribe((Subscriber)timeoutConsumer);
    }
}
