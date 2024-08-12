/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelRunOn.RunOnSubscriber<T>
extends ParallelRunOn.BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final Subscriber<? super T> downstream;

    ParallelRunOn.RunOnSubscriber(Subscriber<? super T> subscriber, int n, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(n, spscArrayQueue, worker);
        this.downstream = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)this.prefetch);
    }

    public void run() {
        int n = this.consumed;
        SpscArrayQueue spscArrayQueue = this.queue;
        Subscriber<? super T> subscriber = this.downstream;
        int n2 = this.limit;
        int n3 = 1;
        while (true) {
            int n4;
            Object object;
            long l = this.requested.get();
            long l2 = 0L;
            int n5 = n3;
            while (l2 != l) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                boolean bl = this.done;
                if (bl && (object = this.error) != null) {
                    spscArrayQueue.clear();
                    subscriber.onError((Throwable)object);
                    this.worker.dispose();
                    return;
                }
                object = spscArrayQueue.poll();
                n3 = object == null ? 1 : 0;
                if (bl && n3 != 0) {
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                if (n3 != 0) break;
                subscriber.onNext(object);
                ++l2;
                n3 = n + 1;
                if (n3 == n2) {
                    this.upstream.request((long)n3);
                    n3 = 0;
                }
                n = n3;
            }
            if (l2 == l) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                }
                if (this.done) {
                    object = this.error;
                    if (object != null) {
                        spscArrayQueue.clear();
                        subscriber.onError((Throwable)object);
                        this.worker.dispose();
                        return;
                    }
                    if (spscArrayQueue.isEmpty()) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (l2 != 0L && l != Long.MAX_VALUE) {
                this.requested.addAndGet(-l2);
            }
            n3 = n4 = this.get();
            if (n4 != n5) continue;
            this.consumed = n;
            n3 = n5 = this.addAndGet(-n5);
            if (n5 == 0) return;
        }
    }
}
