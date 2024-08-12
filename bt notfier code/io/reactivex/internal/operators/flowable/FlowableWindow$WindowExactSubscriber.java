/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindow.WindowExactSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    final int bufferSize;
    final Subscriber<? super Flowable<T>> downstream;
    long index;
    final AtomicBoolean once;
    final long size;
    Subscription upstream;
    UnicastProcessor<T> window;

    FlowableWindow.WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long l, int n) {
        super(1);
        this.downstream = subscriber;
        this.size = l;
        this.once = new AtomicBoolean();
        this.bufferSize = n;
    }

    public void cancel() {
        if (!this.once.compareAndSet(false, true)) return;
        this.run();
    }

    public void onComplete() {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l = this.index;
        UnicastProcessor unicastProcessor = this.window;
        if (l == 0L) {
            this.getAndIncrement();
            this.window = unicastProcessor = UnicastProcessor.create((int)this.bufferSize, (Runnable)this);
            this.downstream.onNext((Object)unicastProcessor);
        }
        unicastProcessor.onNext(t);
        if (++l == this.size) {
            this.index = 0L;
            this.window = null;
            unicastProcessor.onComplete();
        } else {
            this.index = l;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        l = BackpressureHelper.multiplyCap((long)this.size, (long)l);
        this.upstream.request(l);
    }

    @Override
    public void run() {
        if (this.decrementAndGet() != 0) return;
        this.upstream.cancel();
    }
}
