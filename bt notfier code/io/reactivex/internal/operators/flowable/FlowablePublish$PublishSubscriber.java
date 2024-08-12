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
 *  io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.NotificationLite
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
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowablePublish.PublishSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Disposable {
    static final FlowablePublish.InnerSubscriber[] EMPTY = new FlowablePublish.InnerSubscriber[0];
    static final FlowablePublish.InnerSubscriber[] TERMINATED = new FlowablePublish.InnerSubscriber[0];
    private static final long serialVersionUID = -202316842419149694L;
    final int bufferSize;
    final AtomicReference<FlowablePublish.PublishSubscriber<T>> current;
    volatile SimpleQueue<T> queue;
    final AtomicBoolean shouldConnect;
    int sourceMode;
    final AtomicReference<FlowablePublish.InnerSubscriber<T>[]> subscribers;
    volatile Object terminalEvent;
    final AtomicReference<Subscription> upstream = new AtomicReference();

    FlowablePublish.PublishSubscriber(AtomicReference<FlowablePublish.PublishSubscriber<T>> atomicReference, int n) {
        this.subscribers = new AtomicReference<FlowablePublish.InnerSubscriber[]>(EMPTY);
        this.current = atomicReference;
        this.shouldConnect = new AtomicBoolean();
        this.bufferSize = n;
    }

    boolean add(FlowablePublish.InnerSubscriber<T> innerSubscriber) {
        FlowablePublish.InnerSubscriber[] innerSubscriberArray;
        FlowablePublish.InnerSubscriber<T>[] innerSubscriberArray2;
        do {
            if ((innerSubscriberArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = innerSubscriberArray2.length;
            innerSubscriberArray = new FlowablePublish.InnerSubscriber[n + 1];
            System.arraycopy(innerSubscriberArray2, 0, innerSubscriberArray, 0, n);
            innerSubscriberArray[n] = innerSubscriber;
        } while (!this.subscribers.compareAndSet(innerSubscriberArray2, innerSubscriberArray));
        return true;
    }

    boolean checkTerminated(Object innerSubscriberArray, boolean bl) {
        int n = 0;
        int n2 = 0;
        if (innerSubscriberArray == null) return false;
        if (NotificationLite.isComplete((Object)innerSubscriberArray)) {
            if (!bl) return false;
            this.current.compareAndSet(this, null);
            innerSubscriberArray = this.subscribers.getAndSet(TERMINATED);
            n = innerSubscriberArray.length;
            while (n2 < n) {
                innerSubscriberArray[n2].child.onComplete();
                ++n2;
            }
            return true;
        }
        Throwable throwable = NotificationLite.getError((Object)innerSubscriberArray);
        this.current.compareAndSet(this, null);
        innerSubscriberArray = this.subscribers.getAndSet(TERMINATED);
        if (innerSubscriberArray.length == 0) {
            RxJavaPlugins.onError((Throwable)throwable);
            return true;
        }
        int n3 = innerSubscriberArray.length;
        n2 = n;
        while (n2 < n3) {
            innerSubscriberArray[n2].child.onError(throwable);
            ++n2;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void dispatch() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        var16_1 = this.subscribers;
        var12_2 = var16_1.get();
        var1_3 = 1;
        var2_4 = 1;
        block4: while (true) {
            var14_14 = this.terminalEvent;
            var13_12 /* !! */  = this.queue;
            var7_9 = var13_12 /* !! */  == null || var13_12 /* !! */ .isEmpty();
            if (this.checkTerminated(var14_14, var7_9)) {
                return;
            }
            var3_5 = var1_3;
            if (var7_9) ** GOTO lbl73
            var5_7 = var12_2.length;
            var6_8 = var12_2.length;
            var4_6 = 0;
            var8_10 = 0x7FFFFFFFFFFFFFFFL;
            for (var3_5 = 0; var3_5 < var6_8; ++var3_5) {
                var14_14 = var12_2[var3_5];
                var10_11 = var14_14.get();
                if (var10_11 != -9223372036854775808L) {
                    var8_10 = Math.min(var8_10, var10_11 - var14_14.emitted);
                    continue;
                }
                ++var4_6;
            }
            if (var5_7 == var4_6) {
                var14_14 = this.terminalEvent;
                try {
                    var13_12 /* !! */  = var13_12 /* !! */ .poll();
                }
                catch (Throwable var13_13) {
                    Exceptions.throwIfFatal((Throwable)var13_13);
                    this.upstream.get().cancel();
                    var14_14 = NotificationLite.error((Throwable)var13_13);
                    this.terminalEvent = var14_14;
                    var13_12 /* !! */  = null;
                }
                var7_9 = var13_12 /* !! */  == null;
                if (this.checkTerminated(var14_14, var7_9)) {
                    return;
                }
                if (this.sourceMode == var1_3) continue;
                this.upstream.get().request(1L);
                continue;
            }
            var1_3 = 0;
            do {
                if ((var10_11 = (long)var1_3) >= var8_10) ** GOTO lbl-1000
                var15_16 = this.terminalEvent;
                try {
                    var14_14 = var13_12 /* !! */ .poll();
                }
                catch (Throwable var14_15) {
                    Exceptions.throwIfFatal((Throwable)var14_15);
                    this.upstream.get().cancel();
                    var15_16 = NotificationLite.error((Throwable)var14_15);
                    this.terminalEvent = var15_16;
                    var14_14 = null;
                }
                var7_9 = var14_14 == null;
                if (this.checkTerminated(var15_16, var7_9)) {
                    return;
                }
                if (!var7_9) {
                    var14_14 = NotificationLite.getValue(var14_14);
                    var5_7 = var12_2.length;
                    var3_5 = 0;
                } else lbl-1000:
                // 2 sources

                {
                    if (var1_3 != 0 && this.sourceMode != 1) {
                        this.upstream.get().request(var10_11);
                    }
                    var4_6 = 1;
                    var1_3 = 1;
                    var3_5 = var4_6;
                    if (var8_10 != 0L) {
                        var3_5 = var4_6;
                        if (!var7_9) continue block4;
                    }
lbl73:
                    // 4 sources

                    if ((var2_4 = this.addAndGet(-var2_4)) == 0) {
                        return;
                    }
                    var12_2 = var16_1.get();
                    var1_3 = var3_5;
                    continue block4;
                }
                for (var4_6 = 0; var4_6 < var5_7; ++var4_6) {
                    var15_16 = var12_2[var4_6];
                    var10_11 = var15_16.get();
                    if (var10_11 != -9223372036854775808L) {
                        if (var10_11 != 0x7FFFFFFFFFFFFFFFL) {
                            ++var15_16.emitted;
                        }
                        var15_16.child.onNext(var14_14);
                        continue;
                    }
                    var3_5 = 1;
                }
                ++var1_3;
                var14_14 = var16_1.get();
            } while (var3_5 == 0 && var14_14 == var12_2);
            if (var1_3 != 0 && this.sourceMode != 1) {
                this.upstream.get().request((long)var1_3);
            }
            var12_2 = var14_14;
            var1_3 = 1;
        }
    }

    public void dispose() {
        FlowablePublish.InnerSubscriber[] innerSubscriberArray;
        FlowablePublish.InnerSubscriber<T>[] innerSubscriberArray2 = this.subscribers.get();
        if (innerSubscriberArray2 == (innerSubscriberArray = TERMINATED)) return;
        if (this.subscribers.getAndSet(innerSubscriberArray) == TERMINATED) return;
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.upstream);
    }

    public boolean isDisposed() {
        boolean bl = this.subscribers.get() == TERMINATED;
        return bl;
    }

    public void onComplete() {
        if (this.terminalEvent != null) return;
        this.terminalEvent = NotificationLite.complete();
        this.dispatch();
    }

    public void onError(Throwable throwable) {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.error((Throwable)throwable);
            this.dispatch();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.onError((Throwable)new MissingBackpressureException("Prefetch queue is full?!"));
            return;
        }
        this.dispatch();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.terminalEvent = NotificationLite.complete();
                this.dispatch();
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

    void remove(FlowablePublish.InnerSubscriber<T> innerSubscriber) {
        FlowablePublish.InnerSubscriber<T>[] innerSubscriberArray;
        int n;
        while ((n = (innerSubscriberArray = this.subscribers.get()).length) != 0) {
            FlowablePublish.InnerSubscriber[] innerSubscriberArray2;
            int n2;
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n2 = n3;
                if (n4 >= n) break;
                if (innerSubscriberArray[n4].equals(innerSubscriber)) {
                    n2 = n4;
                    break;
                }
                ++n4;
            }
            if (n2 < 0) {
                return;
            }
            if (n == 1) {
                innerSubscriberArray2 = EMPTY;
            } else {
                innerSubscriberArray2 = new FlowablePublish.InnerSubscriber[n - 1];
                System.arraycopy(innerSubscriberArray, 0, innerSubscriberArray2, 0, n2);
                System.arraycopy(innerSubscriberArray, n2 + 1, innerSubscriberArray2, n2, n - n2 - 1);
            }
            if (!this.subscribers.compareAndSet(innerSubscriberArray, innerSubscriberArray2)) continue;
        }
    }
}
