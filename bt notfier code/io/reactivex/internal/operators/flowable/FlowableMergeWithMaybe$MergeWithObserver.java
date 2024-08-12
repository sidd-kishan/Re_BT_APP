/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver$OtherObserver
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableMergeWithMaybe.MergeWithObserver<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean cancelled;
    int consumed;
    final Subscriber<? super T> downstream;
    long emitted;
    final AtomicThrowable error;
    final int limit;
    volatile boolean mainDone;
    final AtomicReference<Subscription> mainSubscription;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    final int prefetch;
    volatile SimplePlainQueue<T> queue;
    final AtomicLong requested;
    T singleItem;

    FlowableMergeWithMaybe.MergeWithObserver(Subscriber<? super T> subscriber) {
        int n;
        this.downstream = subscriber;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.prefetch = n = Flowable.bufferSize();
        this.limit = n - (n >> 2);
    }

    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
        if (this.getAndIncrement() != 0) return;
        this.queue = null;
        this.singleItem = null;
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        Subscriber<? super T> subscriber = this.downstream;
        long l = this.emitted;
        int n = this.consumed;
        int n2 = this.limit;
        int n3 = 1;
        do {
            int n4;
            boolean bl;
            Object object;
            long l2 = this.requested.get();
            while (l != l2) {
                if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                }
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    subscriber.onError(this.error.terminate());
                    return;
                }
                int n5 = this.otherState;
                if (n5 == 1) {
                    object = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    subscriber.onNext(object);
                    ++l;
                    continue;
                }
                bl = this.mainDone;
                object = this.queue;
                object = object != null ? object.poll() : null;
                n4 = object == null ? 1 : 0;
                if (bl && n4 != 0 && n5 == 2) {
                    this.queue = null;
                    subscriber.onComplete();
                    return;
                }
                if (n4 != 0) break;
                subscriber.onNext(object);
                ++l;
                n = n4 = n + 1;
                if (n4 != n2) continue;
                this.mainSubscription.get().request((long)n2);
                n = 0;
            }
            if (l == l2) {
                if (this.cancelled) {
                    this.singleItem = null;
                    this.queue = null;
                    return;
                }
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    subscriber.onError(this.error.terminate());
                    return;
                }
                bl = this.mainDone;
                object = this.queue;
                n4 = object != null && !object.isEmpty() ? 0 : 1;
                if (bl && n4 != 0 && this.otherState == 2) {
                    this.queue = null;
                    subscriber.onComplete();
                    return;
                }
            }
            this.emitted = l;
            this.consumed = n;
        } while ((n3 = this.addAndGet(-n3)) != 0);
    }

    SimplePlainQueue<T> getOrCreateQueue() {
        SpscArrayQueue spscArrayQueue;
        SpscArrayQueue spscArrayQueue2 = spscArrayQueue = this.queue;
        if (spscArrayQueue != null) return spscArrayQueue2;
        this.queue = spscArrayQueue2 = new SpscArrayQueue(Flowable.bufferSize());
        return spscArrayQueue2;
    }

    public void onComplete() {
        this.mainDone = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            SubscriptionHelper.cancel(this.mainSubscription);
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.compareAndSet(0, 1)) {
            long l = this.emitted;
            if (this.requested.get() != l) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                if (simplePlainQueue != null && !simplePlainQueue.isEmpty()) {
                    simplePlainQueue.offer(t);
                } else {
                    this.emitted = l + 1L;
                    this.downstream.onNext(t);
                    int n = this.consumed + 1;
                    if (n == this.limit) {
                        this.consumed = 0;
                        this.mainSubscription.get().request((long)n);
                    } else {
                        this.consumed = n;
                    }
                }
            } else {
                this.getOrCreateQueue().offer(t);
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            this.getOrCreateQueue().offer(t);
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.mainSubscription, (Subscription)subscription, (long)this.prefetch);
    }

    void otherComplete() {
        this.otherState = 2;
        this.drain();
    }

    void otherError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            SubscriptionHelper.cancel(this.mainSubscription);
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void otherSuccess(T t) {
        if (this.compareAndSet(0, 1)) {
            long l = this.emitted;
            if (this.requested.get() != l) {
                this.emitted = l + 1L;
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (this.decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            this.singleItem = t;
            this.otherState = 1;
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
