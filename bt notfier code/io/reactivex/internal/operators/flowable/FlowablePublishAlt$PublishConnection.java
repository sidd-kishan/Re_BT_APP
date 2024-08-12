/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowablePublishAlt.PublishConnection<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Disposable {
    static final FlowablePublishAlt.InnerSubscription[] EMPTY = new FlowablePublishAlt.InnerSubscription[0];
    static final FlowablePublishAlt.InnerSubscription[] TERMINATED = new FlowablePublishAlt.InnerSubscription[0];
    private static final long serialVersionUID = -1672047311619175801L;
    final int bufferSize;
    final AtomicBoolean connect;
    int consumed;
    final AtomicReference<FlowablePublishAlt.PublishConnection<T>> current;
    volatile boolean done;
    Throwable error;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    final AtomicReference<FlowablePublishAlt.InnerSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;

    FlowablePublishAlt.PublishConnection(AtomicReference<FlowablePublishAlt.PublishConnection<T>> atomicReference, int n) {
        this.current = atomicReference;
        this.upstream = new AtomicReference();
        this.connect = new AtomicBoolean();
        this.bufferSize = n;
        this.subscribers = new AtomicReference<FlowablePublishAlt.InnerSubscription[]>(EMPTY);
    }

    boolean add(FlowablePublishAlt.InnerSubscription<T> innerSubscription) {
        FlowablePublishAlt.InnerSubscription[] innerSubscriptionArray;
        FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArray2;
        do {
            if ((innerSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = innerSubscriptionArray2.length;
            innerSubscriptionArray = new FlowablePublishAlt.InnerSubscription[n + 1];
            System.arraycopy(innerSubscriptionArray2, 0, innerSubscriptionArray, 0, n);
            innerSubscriptionArray[n] = innerSubscription;
        } while (!this.subscribers.compareAndSet(innerSubscriptionArray2, innerSubscriptionArray));
        return true;
    }

    boolean checkTerminated(boolean bl, boolean bl2) {
        int n = 0;
        if (!bl) return false;
        if (!bl2) return false;
        Throwable throwable = this.error;
        if (throwable != null) {
            this.signalError(throwable);
            return true;
        }
        FlowablePublishAlt.InnerSubscription[] innerSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n2 = innerSubscriptionArray.length;
        while (n < n2) {
            throwable = innerSubscriptionArray[n];
            if (!throwable.isCancelled()) {
                ((FlowablePublishAlt.InnerSubscription)throwable).downstream.onComplete();
            }
            ++n;
        }
        return true;
    }

    public void dispose() {
        this.subscribers.getAndSet(TERMINATED);
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.upstream);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        SimpleQueue<T> simpleQueue = this.queue;
        int n = this.consumed;
        int n2 = this.bufferSize;
        int n3 = n2 - (n2 >> 2);
        boolean bl = this.sourceMode != 1;
        int n4 = 1;
        block2: while (true) {
            int n5;
            n2 = n;
            if (simpleQueue != null) {
                long l = Long.MAX_VALUE;
                FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArray = this.subscribers.get();
                int n6 = innerSubscriptionArray.length;
                n5 = 0;
                for (n2 = 0; n2 < n6; ++n2) {
                    FlowablePublishAlt.InnerSubscription<T> innerSubscription = innerSubscriptionArray[n2];
                    long l2 = innerSubscription.get();
                    long l3 = l;
                    if (l2 != Long.MIN_VALUE) {
                        l3 = Math.min(l2 - innerSubscription.emitted, l);
                        n5 = 1;
                    }
                    l = l3;
                }
                n2 = n;
                if (n5 == 0) {
                    l = 0L;
                    n2 = n;
                }
                while (l != 0L) {
                    Object object;
                    boolean bl2 = this.done;
                    try {
                        object = simpleQueue.poll();
                        boolean bl3 = object == null;
                        if (this.checkTerminated(bl2, bl3)) {
                            return;
                        }
                        if (bl3) {
                            break;
                        }
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.upstream.get().cancel();
                        simpleQueue.clear();
                        this.done = true;
                        this.signalError(throwable);
                        return;
                    }
                    for (FlowablePublishAlt.InnerSubscription<T> innerSubscription : innerSubscriptionArray) {
                        if (innerSubscription.isCancelled()) continue;
                        innerSubscription.downstream.onNext(object);
                        ++innerSubscription.emitted;
                    }
                    n = n2++;
                    if (bl) {
                        n = n2;
                        if (n2 == n3) {
                            this.upstream.get().request((long)n3);
                            n = 0;
                        }
                    }
                    --l;
                    if (innerSubscriptionArray != this.subscribers.get()) continue block2;
                    n2 = n;
                }
                if (this.checkTerminated(this.done, simpleQueue.isEmpty())) {
                    return;
                }
            }
            this.consumed = n2;
            n5 = this.addAndGet(-n4);
            if (n5 == 0) {
                return;
            }
            n = n2;
            n4 = n5;
            if (simpleQueue != null) continue;
            simpleQueue = this.queue;
            n = n2;
            n4 = n5;
        }
    }

    public boolean isDisposed() {
        boolean bl = this.subscribers.get() == TERMINATED;
        return bl;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.error = throwable;
            this.done = true;
            this.drain();
        }
    }

    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.onError((Throwable)new MissingBackpressureException("Prefetch queue is full?!"));
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.drain();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                subscription.request((long)this.bufferSize);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.bufferSize);
        subscription.request((long)this.bufferSize);
    }

    void remove(FlowablePublishAlt.InnerSubscription<T> innerSubscription) {
        FlowablePublishAlt.InnerSubscription<T>[] innerSubscriptionArray;
        int n;
        while ((n = (innerSubscriptionArray = this.subscribers.get()).length) != 0) {
            FlowablePublishAlt.InnerSubscription[] innerSubscriptionArray2;
            int n2;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n2 = n3;
                if (n4 >= n) break;
                if (innerSubscriptionArray[n4] == innerSubscription) {
                    n2 = n4;
                    break;
                }
                ++n4;
            }
            if (n2 < 0) {
                return;
            }
            if (n == 1) {
                innerSubscriptionArray2 = EMPTY;
            } else {
                innerSubscriptionArray2 = new FlowablePublishAlt.InnerSubscription[n - 1];
                System.arraycopy(innerSubscriptionArray, 0, innerSubscriptionArray2, 0, n2);
                System.arraycopy(innerSubscriptionArray, n2 + 1, innerSubscriptionArray2, n2, n - n2 - 1);
            }
            if (!this.subscribers.compareAndSet(innerSubscriptionArray, innerSubscriptionArray2)) continue;
        }
    }

    void signalError(Throwable throwable) {
        FlowablePublishAlt.InnerSubscription[] innerSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = innerSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            FlowablePublishAlt.InnerSubscription innerSubscription = innerSubscriptionArray[n2];
            if (!innerSubscription.isCancelled()) {
                innerSubscription.downstream.onError(throwable);
            }
            ++n2;
        }
    }
}
