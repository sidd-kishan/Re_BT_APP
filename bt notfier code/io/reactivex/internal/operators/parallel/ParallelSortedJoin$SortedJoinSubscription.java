/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelSortedJoin.SortedJoinSubscription<T>
extends AtomicInteger
implements Subscription {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final Subscriber<? super T> downstream;
    final AtomicReference<Throwable> error;
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining;
    final AtomicLong requested = new AtomicLong();
    final ParallelSortedJoin.SortedJoinInnerSubscriber<T>[] subscribers;

    ParallelSortedJoin.SortedJoinSubscription(Subscriber<? super T> sortedJoinInnerSubscriberArray, int n, Comparator<? super T> comparator) {
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        this.downstream = sortedJoinInnerSubscriberArray;
        this.comparator = comparator;
        sortedJoinInnerSubscriberArray = new ParallelSortedJoin.SortedJoinInnerSubscriber[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.subscribers = sortedJoinInnerSubscriberArray;
                this.lists = new List[n];
                this.indexes = new int[n];
                this.remaining.lazySet(n);
                return;
            }
            sortedJoinInnerSubscriberArray[n2] = new ParallelSortedJoin.SortedJoinInnerSubscriber(this, n2);
            ++n2;
        }
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.cancelAll();
        if (this.getAndIncrement() != 0) return;
        Arrays.fill(this.lists, null);
    }

    void cancelAll() {
        ParallelSortedJoin.SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArray = this.subscribers;
        int n = sortedJoinInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            sortedJoinInnerSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.downstream;
        Object[] objectArray = this.lists;
        int[] nArray = this.indexes;
        int n = nArray.length;
        int n2 = 1;
        while (true) {
            int n3;
            int n4;
            Object object;
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                if (this.cancelled) {
                    Arrays.fill(objectArray, null);
                    return;
                }
                object = this.error.get();
                if (object != null) {
                    this.cancelAll();
                    Arrays.fill(objectArray, null);
                    subscriber.onError((Throwable)object);
                    return;
                }
                n4 = -1;
                Throwable throwable = null;
                for (n3 = 0; n3 < n; ++n3) {
                    int n5;
                    block21: {
                        Object object2 = objectArray[n3];
                        int n6 = nArray[n3];
                        object = throwable;
                        n5 = n4;
                        if (object2.size() != n6) {
                            if (throwable == null) {
                                object = object2.get(n6);
                            } else {
                                object2 = object2.get(n6);
                                try {
                                    n5 = this.comparator.compare(throwable, object2);
                                    n6 = n5 > 0 ? 1 : 0;
                                    object = throwable;
                                    n5 = n4;
                                    if (n6 == 0) break block21;
                                    object = object2;
                                }
                                catch (Throwable throwable2) {
                                    Exceptions.throwIfFatal((Throwable)throwable2);
                                    this.cancelAll();
                                    Arrays.fill(objectArray, null);
                                    if (!this.error.compareAndSet(null, throwable2)) {
                                        RxJavaPlugins.onError((Throwable)throwable2);
                                    }
                                    subscriber.onError(this.error.get());
                                    return;
                                }
                            }
                            n5 = n3;
                        }
                    }
                    throwable = object;
                    n4 = n5;
                }
                if (throwable == null) {
                    Arrays.fill(objectArray, null);
                    subscriber.onComplete();
                    return;
                }
                subscriber.onNext(throwable);
                nArray[n4] = nArray[n4] + 1;
            }
            if (l == l2) {
                block22: {
                    if (this.cancelled) {
                        Arrays.fill(objectArray, null);
                        return;
                    }
                    object = this.error.get();
                    if (object != null) {
                        this.cancelAll();
                        Arrays.fill(objectArray, null);
                        subscriber.onError((Throwable)object);
                        return;
                    }
                    for (n3 = 0; n3 < n; ++n3) {
                        if (nArray[n3] == objectArray[n3].size()) continue;
                        n3 = 0;
                        break block22;
                    }
                    n3 = 1;
                }
                if (n3 != 0) {
                    Arrays.fill(objectArray, null);
                    subscriber.onComplete();
                    return;
                }
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n3 = n4 = this.get();
            if (n4 == n2) {
                n3 = n2 = this.addAndGet(-n2);
                if (n2 == 0) {
                    return;
                }
            }
            n2 = n3;
        }
    }

    void innerError(Throwable throwable) {
        if (this.error.compareAndSet(null, throwable)) {
            this.drain();
        } else {
            if (throwable == this.error.get()) return;
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerNext(List<T> list, int n) {
        this.lists[n] = list;
        if (this.remaining.decrementAndGet() != 0) return;
        this.drain();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        if (this.remaining.get() != 0) return;
        this.drain();
    }
}
