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

static final class FlowableTakeLastTimed.TakeLastTimedSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
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

    FlowableTakeLastTimed.TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        this.downstream = subscriber;
        this.count = l;
        this.time = l2;
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

    boolean checkTerminated(boolean bl, Subscriber<? super T> subscriber, boolean bl2) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        }
        if (bl2) {
            if (!bl) return false;
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
        if (!bl) return false;
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
        int n2 = 1;
        do {
            if (this.done) {
                if (this.checkTerminated(spscLinkedArrayQueue.isEmpty(), subscriber, bl)) {
                    return;
                }
                long l = this.requested.get();
                long l2 = 0L;
                while (true) {
                    boolean bl2;
                    if (this.checkTerminated(bl2 = spscLinkedArrayQueue.peek() == null, subscriber, bl)) {
                        return;
                    }
                    if (l == l2) {
                        if (l2 == 0L) break;
                        BackpressureHelper.produced((AtomicLong)this.requested, (long)l2);
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    subscriber.onNext(spscLinkedArrayQueue.poll());
                    ++l2;
                }
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        this.trim(this.scheduler.now(this.unit), this.queue);
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.delayError) {
            this.trim(this.scheduler.now(this.unit), this.queue);
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(T t) {
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        long l = this.scheduler.now(this.unit);
        spscLinkedArrayQueue.offer((Object)l, t);
        this.trim(l, spscLinkedArrayQueue);
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

    void trim(long l, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
        long l2 = this.time;
        long l3 = this.count;
        boolean bl = l3 == Long.MAX_VALUE;
        while (!spscLinkedArrayQueue.isEmpty()) {
            if ((Long)spscLinkedArrayQueue.peek() >= l - l2) {
                if (bl) return;
                if ((long)(spscLinkedArrayQueue.size() >> 1) <= l3) return;
            }
            spscLinkedArrayQueue.poll();
            spscLinkedArrayQueue.poll();
        }
    }
}
