/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Scheduler;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

static final class ParallelRunOn.RunOnConditionalSubscriber<T>
extends ParallelRunOn.BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final ConditionalSubscriber<? super T> downstream;

    ParallelRunOn.RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int n, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(n, spscArrayQueue, worker);
        this.downstream = conditionalSubscriber;
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
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
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
                    conditionalSubscriber.onError((Throwable)object);
                    this.worker.dispose();
                    return;
                }
                object = spscArrayQueue.poll();
                n3 = object == null ? 1 : 0;
                if (bl && n3 != 0) {
                    conditionalSubscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                if (n3 != 0) break;
                long l3 = l2;
                if (conditionalSubscriber.tryOnNext(object)) {
                    l3 = l2 + 1L;
                }
                if ((n3 = n + 1) == n2) {
                    this.upstream.request((long)n3);
                    n3 = 0;
                }
                n = n3;
                l2 = l3;
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
                        conditionalSubscriber.onError((Throwable)object);
                        this.worker.dispose();
                        return;
                    }
                    if (spscArrayQueue.isEmpty()) {
                        conditionalSubscriber.onComplete();
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
