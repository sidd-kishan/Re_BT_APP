/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher$RailSubscription
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelFromPublisher.ParallelDispatcher<T>
extends AtomicInteger
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4470634016609963609L;
    volatile boolean cancelled;
    volatile boolean done;
    final long[] emissions;
    Throwable error;
    int index;
    final int limit;
    final int prefetch;
    int produced;
    SimpleQueue<T> queue;
    final AtomicLongArray requests;
    int sourceMode;
    final AtomicInteger subscriberCount = new AtomicInteger();
    final Subscriber<? super T>[] subscribers;
    Subscription upstream;

    ParallelFromPublisher.ParallelDispatcher(Subscriber<? super T>[] object, int n) {
        this.subscribers = object;
        this.prefetch = n;
        this.limit = n - (n >> 2);
        n = ((Subscriber<? super T>[])object).length;
        int n2 = n + n;
        this.requests = object = new AtomicLongArray(n2 + 1);
        ((AtomicLongArray)object).lazySet(n2, n);
        this.emissions = new long[n];
    }

    void cancel(int n) {
        if (this.requests.decrementAndGet(n) != 0L) return;
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        if (this.sourceMode == 1) {
            this.drainSync();
        } else {
            this.drainAsync();
        }
    }

    void drainAsync() {
        SimpleQueue<T> simpleQueue = this.queue;
        Subscriber<? super T>[] subscriberArray = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] lArray = this.emissions;
        int n = lArray.length;
        int n2 = this.index;
        int n3 = this.produced;
        int n4 = 1;
        while (true) {
            int n5;
            int n6;
            int n7;
            int n8 = 0;
            int n9 = 0;
            int n10 = 0;
            int n11 = 0;
            do {
                long l;
                Object object;
                if (this.cancelled) {
                    simpleQueue.clear();
                    return;
                }
                boolean bl = this.done;
                if (bl && (object = this.error) != null) {
                    simpleQueue.clear();
                    n4 = subscriberArray.length;
                    n6 = n10;
                    while (n6 < n4) {
                        subscriberArray[n6].onError((Throwable)object);
                        ++n6;
                    }
                    return;
                }
                boolean bl2 = simpleQueue.isEmpty();
                if (bl && bl2) {
                    n4 = subscriberArray.length;
                    n6 = n8;
                    while (n6 < n4) {
                        subscriberArray[n6].onComplete();
                        ++n6;
                    }
                    return;
                }
                if (bl2) {
                    n6 = n2;
                    n5 = n3;
                    break;
                }
                long l2 = atomicLongArray.get(n2);
                if (l2 != (l = lArray[n2]) && atomicLongArray.get(n + n2) == 0L) {
                    try {
                        object = simpleQueue.poll();
                        if (object == null) {
                            n6 = n2;
                            n5 = n3;
                            break;
                        }
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.upstream.cancel();
                        n4 = subscriberArray.length;
                        n6 = n9;
                        while (n6 < n4) {
                            subscriberArray[n6].onError(throwable);
                            ++n6;
                        }
                        return;
                    }
                    subscriberArray[n2].onNext(object);
                    lArray[n2] = l + 1L;
                    n5 = n6 = n3 + 1;
                    if (n6 == this.limit) {
                        this.upstream.request((long)n6);
                        n5 = 0;
                    }
                    n7 = 0;
                } else {
                    n7 = n11 + 1;
                    n5 = n3;
                }
                n6 = ++n2;
                if (n2 == n) {
                    n6 = 0;
                }
                n2 = n6;
                n3 = n5;
                n11 = n7;
            } while (n7 != n);
            n2 = this.get();
            if (n2 == n4) {
                this.index = n6;
                this.produced = n5;
                n7 = this.addAndGet(-n4);
                n2 = n6;
                n3 = n5;
                n4 = n7;
                if (n7 != 0) continue;
                return;
            }
            n4 = n2;
            n2 = n6;
            n3 = n5;
        }
    }

    void drainSync() {
        SimpleQueue<T> simpleQueue = this.queue;
        Subscriber<? super T>[] subscriberArray = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] lArray = this.emissions;
        int n = lArray.length;
        int n2 = this.index;
        int n3 = 1;
        while (true) {
            int n4;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = n2;
            do {
                long l;
                if (this.cancelled) {
                    simpleQueue.clear();
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    n3 = subscriberArray.length;
                    n2 = n7;
                    while (n2 < n3) {
                        subscriberArray[n2].onComplete();
                        ++n2;
                    }
                    return;
                }
                long l2 = atomicLongArray.get(n9);
                if (l2 != (l = lArray[n9]) && atomicLongArray.get(n + n9) == 0L) {
                    Object object;
                    block13: {
                        try {
                            object = simpleQueue.poll();
                            if (object != null) break block13;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            this.upstream.cancel();
                            n3 = subscriberArray.length;
                            n2 = n6;
                            while (n2 < n3) {
                                subscriberArray[n2].onError(throwable);
                                ++n2;
                            }
                            return;
                        }
                        n3 = subscriberArray.length;
                        n2 = n5;
                        while (n2 < n3) {
                            subscriberArray[n2].onComplete();
                            ++n2;
                        }
                        return;
                    }
                    subscriberArray[n9].onNext(object);
                    lArray[n9] = l + 1L;
                    n4 = 0;
                } else {
                    n4 = n8 + 1;
                }
                n2 = ++n9;
                if (n9 == n) {
                    n2 = 0;
                }
                n9 = n2;
                n8 = n4;
            } while (n4 != n);
            n4 = this.get();
            if (n4 == n3) {
                this.index = n2;
                n3 = n4 = this.addAndGet(-n3);
                if (n4 != 0) continue;
                return;
            }
            n3 = n4;
        }
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
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.upstream.cancel();
            this.onError((Throwable)new MissingBackpressureException("Queue is full?"));
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.setupSubscribers();
                this.drain();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.setupSubscribers();
                subscription.request((long)this.prefetch);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.prefetch);
        this.setupSubscribers();
        subscription.request((long)this.prefetch);
    }

    void setupSubscribers() {
        Subscriber<? super T>[] subscriberArray = this.subscribers;
        int n = subscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (this.cancelled) {
                return;
            }
            AtomicInteger atomicInteger = this.subscriberCount;
            int n3 = n2 + 1;
            atomicInteger.lazySet(n3);
            subscriberArray[n2].onSubscribe((Subscription)new RailSubscription(this, n2, n));
            n2 = n3;
        }
    }
}
