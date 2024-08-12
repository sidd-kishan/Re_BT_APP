/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.QueueDrainHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowablePublishMulticast.MulticastProcessor<T>
extends Flowable<T>
implements FlowableSubscriber<T>,
Disposable {
    static final FlowablePublishMulticast.MulticastSubscription[] EMPTY = new FlowablePublishMulticast.MulticastSubscription[0];
    static final FlowablePublishMulticast.MulticastSubscription[] TERMINATED = new FlowablePublishMulticast.MulticastSubscription[0];
    int consumed;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    final AtomicReference<FlowablePublishMulticast.MulticastSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicInteger wip;

    FlowablePublishMulticast.MulticastProcessor(int n, boolean bl) {
        this.prefetch = n;
        this.limit = n - (n >> 2);
        this.delayError = bl;
        this.wip = new AtomicInteger();
        this.upstream = new AtomicReference();
        this.subscribers = new AtomicReference<FlowablePublishMulticast.MulticastSubscription[]>(EMPTY);
    }

    boolean add(FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription) {
        FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArray;
        FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArray2;
        do {
            if ((multicastSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = multicastSubscriptionArray2.length;
            multicastSubscriptionArray = new FlowablePublishMulticast.MulticastSubscription[n + 1];
            System.arraycopy(multicastSubscriptionArray2, 0, multicastSubscriptionArray, 0, n);
            multicastSubscriptionArray[n] = multicastSubscription;
        } while (!this.subscribers.compareAndSet(multicastSubscriptionArray2, multicastSubscriptionArray));
        return true;
    }

    void completeAll() {
        FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = multicastSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            FlowablePublishMulticast.MulticastSubscription multicastSubscription = multicastSubscriptionArray[n2];
            if (multicastSubscription.get() != Long.MIN_VALUE) {
                multicastSubscription.downstream.onComplete();
            }
            ++n2;
        }
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        if (this.wip.getAndIncrement() != 0) return;
        SimpleQueue<T> simpleQueue = this.queue;
        if (simpleQueue == null) return;
        simpleQueue.clear();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Object object = this.queue;
        int n = this.consumed;
        int n2 = this.limit;
        boolean bl = this.sourceMode != 1;
        Serializable serializable = this.subscribers;
        Object object2 = ((AtomicReference)serializable).get();
        int n3 = 1;
        while (true) {
            Object object3;
            block33: {
                int n4 = ((FlowablePublishMulticast.MulticastSubscription<T>[])object2).length;
                if (object != null && n4 != 0) {
                    boolean bl2;
                    long l;
                    int n5;
                    int n6;
                    int n7 = ((FlowablePublishMulticast.MulticastSubscription<T>[])object2).length;
                    long l2 = Long.MAX_VALUE;
                    for (n6 = 0; n6 < n7; ++n6) {
                        object3 = object2[n6];
                        long l3 = object3.get() - object3.emitted;
                        if (l3 != Long.MIN_VALUE) {
                            n5 = n4;
                            l = l2;
                            if (l2 > l3) {
                                l = l3;
                                n5 = n4;
                            }
                        } else {
                            n5 = n4 - 1;
                            l = l2;
                        }
                        n4 = n5;
                        l2 = l;
                    }
                    n6 = n;
                    if (n4 == 0) {
                        l2 = 0L;
                        n6 = n;
                    }
                    while (l2 != 0L) {
                        Object object4;
                        if (this.isDisposed()) {
                            object.clear();
                            return;
                        }
                        bl2 = this.done;
                        if (bl2 && !this.delayError && (object3 = this.error) != null) {
                            this.errorAll((Throwable)object3);
                            return;
                        }
                        try {
                            object4 = object.poll();
                            n = object4 == null ? 1 : 0;
                            if (bl2 && n != 0) {
                                serializable = this.error;
                                if (serializable != null) {
                                    this.errorAll((Throwable)serializable);
                                } else {
                                    this.completeAll();
                                }
                                return;
                            }
                            if (n != 0) {
                                break;
                            }
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            SubscriptionHelper.cancel(this.upstream);
                            this.errorAll(throwable);
                            return;
                        }
                        n5 = ((Object)object2).length;
                        n4 = 0;
                        for (n = 0; n < n5; ++n) {
                            object3 = object2[n];
                            l = object3.get();
                            if (l != Long.MIN_VALUE) {
                                if (l != Long.MAX_VALUE) {
                                    ++object3.emitted;
                                }
                                object3.downstream.onNext(object4);
                                continue;
                            }
                            n4 = 1;
                        }
                        --l2;
                        n = n6++;
                        if (bl) {
                            n = n6;
                            if (n6 == n2) {
                                this.upstream.get().request((long)n2);
                                n = 0;
                            }
                        }
                        object3 = (FlowablePublishMulticast.MulticastSubscription[])((AtomicReference)serializable).get();
                        if (n4 == 0 && object3 == object2) {
                            n6 = n;
                            continue;
                        }
                        object2 = object3;
                        object3 = object;
                        object = serializable;
                        break block33;
                    }
                    n = n6;
                    object2 = serializable;
                    if (l2 == 0L) {
                        if (this.isDisposed()) {
                            object.clear();
                            return;
                        }
                        bl2 = this.done;
                        if (bl2 && !this.delayError && (object2 = this.error) != null) {
                            this.errorAll((Throwable)object2);
                            return;
                        }
                        n = n6;
                        object2 = serializable;
                        if (bl2) {
                            n = n6;
                            object2 = serializable;
                            if (object.isEmpty()) {
                                serializable = this.error;
                                if (serializable != null) {
                                    this.errorAll((Throwable)serializable);
                                } else {
                                    this.completeAll();
                                }
                                return;
                            }
                        }
                    }
                } else {
                    object2 = serializable;
                }
                this.consumed = n;
                if ((n3 = this.wip.addAndGet(-n3)) == 0) {
                    return;
                }
                serializable = object;
                if (object == null) {
                    serializable = this.queue;
                }
                object3 = (FlowablePublishMulticast.MulticastSubscription[])((AtomicReference)object2).get();
                object = object2;
                object2 = object3;
                object3 = serializable;
            }
            serializable = object;
            object = object3;
        }
    }

    void errorAll(Throwable throwable) {
        FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = multicastSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            FlowablePublishMulticast.MulticastSubscription multicastSubscription = multicastSubscriptionArray[n2];
            if (multicastSubscription.get() != Long.MIN_VALUE) {
                multicastSubscription.downstream.onError(throwable);
            }
            ++n2;
        }
    }

    public boolean isDisposed() {
        boolean bl = this.upstream.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        if (this.done) return;
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

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.upstream.get().cancel();
            this.onError((Throwable)new MissingBackpressureException());
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(3);
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
                QueueDrainHelper.request((Subscription)subscription, (int)this.prefetch);
                return;
            }
        }
        this.queue = QueueDrainHelper.createQueue((int)this.prefetch);
        QueueDrainHelper.request((Subscription)subscription, (int)this.prefetch);
    }

    void remove(FlowablePublishMulticast.MulticastSubscription<T> multicastSubscription) {
        FlowablePublishMulticast.MulticastSubscription[] multicastSubscriptionArray;
        FlowablePublishMulticast.MulticastSubscription<T>[] multicastSubscriptionArray2;
        do {
            int n;
            int n2;
            if ((n2 = (multicastSubscriptionArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (multicastSubscriptionArray2[n4] == multicastSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                multicastSubscriptionArray = EMPTY;
                continue;
            }
            multicastSubscriptionArray = new FlowablePublishMulticast.MulticastSubscription[n2 - 1];
            System.arraycopy(multicastSubscriptionArray2, 0, multicastSubscriptionArray, 0, n);
            System.arraycopy(multicastSubscriptionArray2, n + 1, multicastSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(multicastSubscriptionArray2, multicastSubscriptionArray));
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object = new FlowablePublishMulticast.MulticastSubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)object);
        if (this.add((FlowablePublishMulticast.MulticastSubscription<T>)object)) {
            if (object.isCancelled()) {
                this.remove((FlowablePublishMulticast.MulticastSubscription<T>)object);
                return;
            }
            this.drain();
        } else {
            object = this.error;
            if (object != null) {
                subscriber.onError((Throwable)object);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
