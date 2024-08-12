/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableObserveOn.ObserveOnSubscriber<T>
extends FlowableObserveOn.BaseObserveOnSubscriber<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4547113800637756442L;
    final Subscriber<? super T> downstream;

    FlowableObserveOn.ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean bl, int n) {
        super(worker, bl, n);
        this.downstream = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = 1;
                this.queue = queueSubscription;
                this.done = true;
                this.downstream.onSubscribe((Subscription)this);
                return;
            }
            if (n == 2) {
                this.sourceMode = 2;
                this.queue = queueSubscription;
                this.downstream.onSubscribe((Subscription)this);
                subscription.request((long)this.prefetch);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)this.prefetch);
    }

    public T poll() throws Exception {
        Object object = this.queue.poll();
        if (object == null) return (T)object;
        if (this.sourceMode == 1) return (T)object;
        long l = this.produced + 1L;
        if (l == (long)this.limit) {
            this.produced = 0L;
            this.upstream.request(l);
        } else {
            this.produced = l;
        }
        return (T)object;
    }

    void runAsync() {
        Subscriber<? super T> subscriber = this.downstream;
        SimpleQueue simpleQueue = this.queue;
        long l = this.produced;
        int n = 1;
        while (true) {
            long l2 = this.requested.get();
            while (l != l2) {
                long l3;
                boolean bl;
                Object object;
                boolean bl2 = this.done;
                try {
                    object = simpleQueue.poll();
                    bl = object == null;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.cancelled = true;
                    this.upstream.cancel();
                    simpleQueue.clear();
                    subscriber.onError(throwable);
                    this.worker.dispose();
                    return;
                }
                if (this.checkTerminated(bl2, bl, subscriber)) {
                    return;
                }
                if (bl) break;
                subscriber.onNext(object);
                l = l3 = l + 1L;
                if (l3 != (long)this.limit) continue;
                long l4 = l2;
                if (l2 != Long.MAX_VALUE) {
                    l4 = this.requested.addAndGet(-l3);
                }
                this.upstream.request(l3);
                l = 0L;
                l2 = l4;
            }
            if (l == l2 && this.checkTerminated(this.done, simpleQueue.isEmpty(), subscriber)) {
                return;
            }
            int n2 = this.get();
            if (n == n2) {
                this.produced = l;
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            n = n2;
        }
    }

    void runBackfused() {
        int n;
        int n2 = 1;
        do {
            if (this.cancelled) {
                return;
            }
            boolean bl = this.done;
            this.downstream.onNext(null);
            if (bl) {
                this.cancelled = true;
                Throwable throwable = this.error;
                if (throwable != null) {
                    this.downstream.onError(throwable);
                } else {
                    this.downstream.onComplete();
                }
                this.worker.dispose();
                return;
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    void runSync() {
        Subscriber<? super T> subscriber = this.downstream;
        SimpleQueue simpleQueue = this.queue;
        long l = this.produced;
        int n = 1;
        while (true) {
            long l2 = this.requested.get();
            while (l != l2) {
                Object object;
                block8: {
                    try {
                        object = simpleQueue.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (object != null) break block8;
                        this.cancelled = true;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.cancelled = true;
                        this.upstream.cancel();
                        subscriber.onError(throwable);
                        this.worker.dispose();
                        return;
                    }
                    subscriber.onComplete();
                    this.worker.dispose();
                    return;
                }
                subscriber.onNext(object);
                ++l;
            }
            if (this.cancelled) {
                return;
            }
            if (simpleQueue.isEmpty()) {
                this.cancelled = true;
                subscriber.onComplete();
                this.worker.dispose();
                return;
            }
            int n2 = this.get();
            if (n == n2) {
                this.produced = l;
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            n = n2;
        }
    }
}
