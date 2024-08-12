/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableScanSeed.ScanSeedSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -1776795561228106469L;
    final BiFunction<R, ? super T, R> accumulator;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    Throwable error;
    final int limit;
    final int prefetch;
    final SimplePlainQueue<R> queue;
    final AtomicLong requested;
    Subscription upstream;
    R value;

    FlowableScanSeed.ScanSeedSubscriber(Subscriber<? super R> spscArrayQueue, BiFunction<R, ? super T, R> biFunction, R r, int n) {
        this.downstream = spscArrayQueue;
        this.accumulator = biFunction;
        this.value = r;
        this.prefetch = n;
        this.limit = n - (n >> 2);
        this.queue = spscArrayQueue = new SpscArrayQueue(n);
        spscArrayQueue.offer(r);
        this.requested = new AtomicLong();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        SimplePlainQueue<R> simplePlainQueue = this.queue;
        int n2 = this.limit;
        int n3 = this.consumed;
        int n4 = 1;
        do {
            Object object;
            long l = this.requested.get();
            long l2 = 0L;
            while (l2 != l) {
                if (this.cancelled) {
                    simplePlainQueue.clear();
                    return;
                }
                boolean bl = this.done;
                if (bl && (object = this.error) != null) {
                    simplePlainQueue.clear();
                    subscriber.onError((Throwable)object);
                    return;
                }
                object = simplePlainQueue.poll();
                n = object == null ? 1 : 0;
                if (bl && n != 0) {
                    subscriber.onComplete();
                    return;
                }
                if (n != 0) break;
                subscriber.onNext(object);
                long l3 = l2 + 1L;
                n3 = n = n3 + 1;
                l2 = l3;
                if (n != n2) continue;
                this.upstream.request((long)n2);
                n3 = 0;
                l2 = l3;
            }
            if (l2 == l && this.done) {
                object = this.error;
                if (object != null) {
                    simplePlainQueue.clear();
                    subscriber.onError((Throwable)object);
                    return;
                }
                if (simplePlainQueue.isEmpty()) {
                    subscriber.onComplete();
                    return;
                }
            }
            if (l2 != 0L) {
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l2);
            }
            this.consumed = n3;
            n4 = n = this.addAndGet(-n4);
        } while (n != 0);
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        R r = this.value;
        try {
            object = ObjectHelper.requireNonNull((Object)this.accumulator.apply(r, object), (String)"The accumulator returned a null value");
            this.value = object;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        this.queue.offer(object);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)(this.prefetch - 1));
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
