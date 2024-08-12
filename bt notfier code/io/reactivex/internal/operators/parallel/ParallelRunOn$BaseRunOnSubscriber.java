/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;

static abstract class ParallelRunOn.BaseRunOnSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    final Scheduler.Worker worker;

    ParallelRunOn.BaseRunOnSubscriber(int n, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        this.prefetch = n;
        this.queue = spscArrayQueue;
        this.limit = n - (n >> 2);
        this.worker = worker;
    }

    public final void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.schedule();
    }

    public final void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.schedule();
    }

    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (!this.queue.offer(t)) {
            this.upstream.cancel();
            this.onError((Throwable)new MissingBackpressureException("Queue is full?!"));
            return;
        }
        this.schedule();
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.schedule();
    }

    final void schedule() {
        if (this.getAndIncrement() != 0) return;
        this.worker.schedule((Runnable)this);
    }
}
