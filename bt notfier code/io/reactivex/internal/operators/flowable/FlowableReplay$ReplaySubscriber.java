/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableReplay.ReplaySubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Disposable {
    static final FlowableReplay.InnerSubscription[] EMPTY = new FlowableReplay.InnerSubscription[0];
    static final FlowableReplay.InnerSubscription[] TERMINATED = new FlowableReplay.InnerSubscription[0];
    private static final long serialVersionUID = 7224554242710036740L;
    final FlowableReplay.ReplayBuffer<T> buffer;
    boolean done;
    final AtomicInteger management;
    long maxChildRequested;
    long maxUpstreamRequested;
    final AtomicBoolean shouldConnect;
    final AtomicReference<FlowableReplay.InnerSubscription<T>[]> subscribers;

    FlowableReplay.ReplaySubscriber(FlowableReplay.ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
        this.management = new AtomicInteger();
        this.subscribers = new AtomicReference<FlowableReplay.InnerSubscription[]>(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    boolean add(FlowableReplay.InnerSubscription<T> innerSubscription) {
        FlowableReplay.InnerSubscription[] innerSubscriptionArray;
        FlowableReplay.InnerSubscription<T>[] innerSubscriptionArray2;
        if (innerSubscription == null) throw null;
        do {
            if ((innerSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return false;
            }
            int n = innerSubscriptionArray2.length;
            innerSubscriptionArray = new FlowableReplay.InnerSubscription[n + 1];
            System.arraycopy(innerSubscriptionArray2, 0, innerSubscriptionArray, 0, n);
            innerSubscriptionArray[n] = innerSubscription;
        } while (!this.subscribers.compareAndSet(innerSubscriptionArray2, innerSubscriptionArray));
        return true;
    }

    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.subscribers.get() == TERMINATED;
        return bl;
    }

    void manageRequests() {
        int n;
        if (this.management.getAndIncrement() != 0) {
            return;
        }
        int n2 = 1;
        do {
            if (this.isDisposed()) {
                return;
            }
            Subscription subscription = this.subscribers.get();
            long l = this.maxChildRequested;
            int n3 = ((FlowableReplay.InnerSubscription<T>[])subscription).length;
            long l2 = l;
            for (n = 0; n < n3; ++n) {
                l2 = Math.max(l2, subscription[n].totalRequested.get());
            }
            long l3 = this.maxUpstreamRequested;
            subscription = (Subscription)this.get();
            if ((l = l2 - l) != 0L) {
                this.maxChildRequested = l2;
                if (subscription != null) {
                    if (l3 != 0L) {
                        this.maxUpstreamRequested = 0L;
                        subscription.request(l3 + l);
                    } else {
                        subscription.request(l);
                    }
                } else {
                    l2 = l = l3 + l;
                    if (l < 0L) {
                        l2 = Long.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = l2;
                }
            } else if (l3 != 0L && subscription != null) {
                this.maxUpstreamRequested = 0L;
                subscription.request(l3);
            }
            n2 = n = this.management.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.buffer.complete();
        FlowableReplay.InnerSubscription[] innerSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = innerSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            FlowableReplay.InnerSubscription innerSubscription = innerSubscriptionArray[n2];
            this.buffer.replay(innerSubscription);
            ++n2;
        }
    }

    public void onError(Throwable innerSubscriptionArray) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)innerSubscriptionArray);
            return;
        }
        this.done = true;
        this.buffer.error((Throwable)innerSubscriptionArray);
        innerSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = innerSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            FlowableReplay.InnerSubscription innerSubscription = innerSubscriptionArray[n2];
            this.buffer.replay(innerSubscription);
            ++n2;
        }
    }

    public void onNext(T object) {
        if (this.done) return;
        this.buffer.next(object);
        object = this.subscribers.get();
        int n = ((T)object).length;
        int n2 = 0;
        while (n2 < n) {
            T t = object[n2];
            this.buffer.replay(t);
            ++n2;
        }
    }

    public void onSubscribe(Subscription innerSubscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)innerSubscription)) return;
        this.manageRequests();
        FlowableReplay.InnerSubscription<T>[] innerSubscriptionArray = this.subscribers.get();
        int n = innerSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            innerSubscription = innerSubscriptionArray[n2];
            this.buffer.replay(innerSubscription);
            ++n2;
        }
    }

    void remove(FlowableReplay.InnerSubscription<T> innerSubscription) {
        FlowableReplay.InnerSubscription[] innerSubscriptionArray;
        FlowableReplay.InnerSubscription<T>[] innerSubscriptionArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerSubscriptionArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerSubscriptionArray2[n4].equals(innerSubscription)) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                innerSubscriptionArray = EMPTY;
                continue;
            }
            innerSubscriptionArray = new FlowableReplay.InnerSubscription[n2 - 1];
            System.arraycopy(innerSubscriptionArray2, 0, innerSubscriptionArray, 0, n);
            System.arraycopy(innerSubscriptionArray2, n + 1, innerSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(innerSubscriptionArray2, innerSubscriptionArray));
    }
}
