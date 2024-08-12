/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSkipLastTimed.SkipLastTimedSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested = new AtomicLong();
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;
    Subscription upstream;

    FlowableSkipLastTimed.SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        this.downstream = subscriber;
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.queue = new SpscLinkedArrayQueue(n);
        this.delayError = bl;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<? super T> subscriber, boolean bl3) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            Throwable throwable = this.error;
            if (throwable != null) {
                subscriber.onError(throwable);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable throwable = this.error;
        if (throwable != null) {
            this.queue.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.downstream;
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        TimeUnit timeUnit = this.unit;
        Scheduler scheduler = this.scheduler;
        long l = this.time;
        int n2 = 1;
        do {
            long l2;
            long l3 = this.requested.get();
            for (l2 = 0L; l2 != l3; ++l2) {
                boolean bl2 = this.done;
                Long l4 = (Long)spscLinkedArrayQueue.peek();
                boolean bl3 = l4 == null;
                long l5 = scheduler.now(timeUnit);
                if (!bl3 && l4 > l5 - l) {
                    bl3 = true;
                }
                if (this.checkTerminated(bl2, bl3, subscriber, bl)) {
                    return;
                }
                if (bl3) break;
                spscLinkedArrayQueue.poll();
                subscriber.onNext(spscLinkedArrayQueue.poll());
            }
            if (l2 != 0L) {
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l2);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(T t) {
        long l = this.scheduler.now(this.unit);
        this.queue.offer((Object)l, t);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
