/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapInner
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapSupport
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

static abstract class FlowableConcatMap.BaseConcatMapSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
FlowableConcatMap.ConcatMapSupport<R>,
Subscription {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final AtomicThrowable errors;
    final FlowableConcatMap.ConcatMapInner<R> inner;
    final int limit;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    int sourceMode;
    Subscription upstream;

    FlowableConcatMap.BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        this.mapper = function;
        this.prefetch = n;
        this.limit = n - (n >> 2);
        this.inner = new FlowableConcatMap.ConcatMapInner((FlowableConcatMap.ConcatMapSupport)this);
        this.errors = new AtomicThrowable();
    }

    abstract void drain();

    public final void innerComplete() {
        this.active = false;
        this.drain();
    }

    public final void onComplete() {
        this.done = true;
        this.drain();
    }

    public final void onNext(T t) {
        if (this.sourceMode != 2 && !this.queue.offer(t)) {
            this.upstream.cancel();
            this.onError(new IllegalStateException("Queue full?!"));
            return;
        }
        this.drain();
    }

    public final void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.subscribeActual();
                this.drain();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.subscribeActual();
                subscription.request((long)this.prefetch);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.prefetch);
        this.subscribeActual();
        subscription.request((long)this.prefetch);
    }

    abstract void subscribeActual();
}
