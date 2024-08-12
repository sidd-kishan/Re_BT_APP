/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.MulticastProcessor$MulticastSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.MulticastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(value=BackpressureKind.FULL)
@SchedulerSupport(value="none")
public final class MulticastProcessor<T>
extends FlowableProcessor<T> {
    static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
    static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
    final int bufferSize;
    int consumed;
    volatile boolean done;
    volatile Throwable error;
    int fusionMode;
    final int limit;
    final AtomicBoolean once;
    volatile SimpleQueue<T> queue;
    final boolean refcount;
    final AtomicReference<MulticastSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicInteger wip;

    MulticastProcessor(int n, boolean bl) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        this.bufferSize = n;
        this.limit = n - (n >> 2);
        this.wip = new AtomicInteger();
        this.subscribers = new AtomicReference<MulticastSubscription[]>(EMPTY);
        this.upstream = new AtomicReference();
        this.refcount = bl;
        this.once = new AtomicBoolean();
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<T>(MulticastProcessor.bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int n) {
        return new MulticastProcessor<T>(n, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int n, boolean bl) {
        return new MulticastProcessor<T>(n, bl);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean bl) {
        return new MulticastProcessor<T>(MulticastProcessor.bufferSize(), bl);
    }

    boolean add(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArray;
        MulticastSubscription<T>[] multicastSubscriptionArray2;
        do {
            if ((multicastSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = multicastSubscriptionArray2.length;
            multicastSubscriptionArray = new MulticastSubscription[n + 1];
            System.arraycopy(multicastSubscriptionArray2, 0, multicastSubscriptionArray, 0, n);
            multicastSubscriptionArray[n] = multicastSubscription;
        } while (!this.subscribers.compareAndSet(multicastSubscriptionArray2, multicastSubscriptionArray));
        return true;
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        MulticastSubscription[] multicastSubscriptionArray = this.subscribers;
        int n = this.consumed;
        int n2 = this.limit;
        int n3 = this.fusionMode;
        int n4 = 1;
        block2: while (true) {
            int n5;
            SimpleQueue<T> simpleQueue = this.queue;
            int n6 = n;
            if (simpleQueue != null) {
                MulticastSubscription<T>[] multicastSubscriptionArray2 = multicastSubscriptionArray.get();
                n6 = n;
                if (multicastSubscriptionArray2.length != 0) {
                    long l;
                    Object object;
                    n5 = multicastSubscriptionArray2.length;
                    long l2 = -1L;
                    for (n6 = 0; n6 < n5; ++n6) {
                        object = multicastSubscriptionArray2[n6];
                        long l3 = object.get();
                        l = l2;
                        if (l3 >= 0L) {
                            l = l2 == -1L ? l3 - object.emitted : Math.min(l2, l3 - object.emitted);
                        }
                        l2 = l;
                    }
                    while (l2 > 0L) {
                        object = multicastSubscriptionArray.get();
                        if (object == TERMINATED) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArray2 != object) continue block2;
                        boolean bl = this.done;
                        try {
                            object = simpleQueue.poll();
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            SubscriptionHelper.cancel(this.upstream);
                            this.error = throwable;
                            this.done = true;
                            object = null;
                            bl = true;
                        }
                        n6 = object == null ? 1 : 0;
                        if (bl && n6 != 0) {
                            object = this.error;
                            if (object != null) {
                                multicastSubscriptionArray = multicastSubscriptionArray.getAndSet(TERMINATED);
                                n4 = multicastSubscriptionArray.length;
                                n = 0;
                                while (n < n4) {
                                    multicastSubscriptionArray[n].onError(object);
                                    ++n;
                                }
                                return;
                            }
                            object = multicastSubscriptionArray.getAndSet(TERMINATED);
                            n4 = ((MulticastSubscription<T>[])object).length;
                            n = 0;
                            while (n < n4) {
                                object[n].onComplete();
                                ++n;
                            }
                            return;
                        }
                        if (n6 != 0) break;
                        n5 = multicastSubscriptionArray2.length;
                        for (n6 = 0; n6 < n5; ++n6) {
                            multicastSubscriptionArray2[n6].onNext(object);
                        }
                        l2 = l = l2 - 1L;
                        if (n3 == 1) continue;
                        n = n6 = n + 1;
                        l2 = l;
                        if (n6 != n2) continue;
                        this.upstream.get().request((long)n2);
                        n = 0;
                        l2 = l;
                    }
                    if (l2 == 0L) {
                        object = multicastSubscriptionArray.get();
                        if (object == TERMINATED) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArray2 != object) continue;
                        if (this.done && simpleQueue.isEmpty()) {
                            object = this.error;
                            if (object != null) {
                                multicastSubscriptionArray = multicastSubscriptionArray.getAndSet(TERMINATED);
                                n4 = multicastSubscriptionArray.length;
                                n = 0;
                                while (n < n4) {
                                    multicastSubscriptionArray[n].onError(object);
                                    ++n;
                                }
                                return;
                            }
                            object = multicastSubscriptionArray.getAndSet(TERMINATED);
                            n4 = ((MulticastSubscription<T>[])object).length;
                            n = 0;
                            while (n < n4) {
                                object[n].onComplete();
                                ++n;
                            }
                            return;
                        }
                    }
                    n6 = n;
                }
            }
            n5 = this.wip.addAndGet(-n4);
            n = n6;
            n4 = n5;
            if (n5 == 0) return;
        }
    }

    public Throwable getThrowable() {
        Throwable throwable = this.once.get() ? this.error : null;
        return throwable;
    }

    public boolean hasComplete() {
        boolean bl = this.once.get() && this.error == null;
        return bl;
    }

    public boolean hasSubscribers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.once.get() && this.error != null;
        return bl;
    }

    public boolean offer(T t) {
        if (this.once.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, (String)"offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.fusionMode != 0) return false;
        if (!this.queue.offer(t)) return false;
        this.drain();
        return true;
    }

    public void onComplete() {
        if (!this.once.compareAndSet(false, true)) return;
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.once.compareAndSet(false, true)) {
            this.error = throwable;
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.once.get()) {
            return;
        }
        if (this.fusionMode == 0) {
            ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.queue.offer(t)) {
                SubscriptionHelper.cancel(this.upstream);
                this.onError((Throwable)new MissingBackpressureException());
                return;
            }
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(3);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.drain();
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                subscription.request((long)this.bufferSize);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.bufferSize);
        subscription.request((long)this.bufferSize);
    }

    void remove(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            int n;
            MulticastSubscription<T>[] multicastSubscriptionArray;
            int n2;
            if ((n2 = (multicastSubscriptionArray = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (multicastSubscriptionArray[n4] == multicastSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) return;
            if (n2 == 1) {
                if (this.refcount) {
                    if (!this.subscribers.compareAndSet(multicastSubscriptionArray, TERMINATED)) continue;
                    SubscriptionHelper.cancel(this.upstream);
                    this.once.set(true);
                    break;
                }
                if (!this.subscribers.compareAndSet(multicastSubscriptionArray, EMPTY)) continue;
                break;
            }
            MulticastSubscription[] multicastSubscriptionArray2 = new MulticastSubscription[n2 - 1];
            System.arraycopy(multicastSubscriptionArray, 0, multicastSubscriptionArray2, 0, n);
            System.arraycopy(multicastSubscriptionArray, n + 1, multicastSubscriptionArray2, n, n2 - n - 1);
            if (this.subscribers.compareAndSet(multicastSubscriptionArray, multicastSubscriptionArray2)) return;
        }
    }

    public void start() {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)EmptySubscription.INSTANCE)) return;
        this.queue = new SpscArrayQueue(this.bufferSize);
    }

    public void startUnbounded() {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)EmptySubscription.INSTANCE)) return;
        this.queue = new SpscLinkedArrayQueue(this.bufferSize);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)object);
        if (this.add((MulticastSubscription<T>)object)) {
            if (object.get() == Long.MIN_VALUE) {
                this.remove((MulticastSubscription<T>)object);
            } else {
                this.drain();
            }
        } else {
            if ((this.once.get() || !this.refcount) && (object = this.error) != null) {
                subscriber.onError((Throwable)object);
                return;
            }
            subscriber.onComplete();
        }
    }
}
