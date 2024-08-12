/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableCache$CacheSubscription
 *  io.reactivex.internal.operators.flowable.FlowableCache$Node
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T>
extends AbstractFlowableWithUpstream<T, T>
implements FlowableSubscriber<T> {
    static final CacheSubscription[] EMPTY = new CacheSubscription[0];
    static final CacheSubscription[] TERMINATED = new CacheSubscription[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicBoolean once;
    volatile long size;
    final AtomicReference<CacheSubscription<T>[]> subscribers;
    Node<T> tail;
    int tailOffset;

    public FlowableCache(Flowable<T> node, int n) {
        super(node);
        this.capacityHint = n;
        this.once = new AtomicBoolean();
        this.head = node = new Node(n);
        this.tail = node;
        this.subscribers = new AtomicReference<CacheSubscription[]>(EMPTY);
    }

    void add(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArray;
        CacheSubscription<T>[] cacheSubscriptionArray2;
        do {
            if ((cacheSubscriptionArray2 = this.subscribers.get()) == TERMINATED) {
                return;
            }
            int n = cacheSubscriptionArray2.length;
            cacheSubscriptionArray = new CacheSubscription[n + 1];
            System.arraycopy(cacheSubscriptionArray2, 0, cacheSubscriptionArray, 0, n);
            cacheSubscriptionArray[n] = cacheSubscription;
        } while (!this.subscribers.compareAndSet(cacheSubscriptionArray2, cacheSubscriptionArray));
    }

    long cachedEventCount() {
        return this.size;
    }

    boolean hasSubscribers() {
        boolean bl = this.subscribers.get().length != 0;
        return bl;
    }

    boolean isConnected() {
        return this.once.get();
    }

    public void onComplete() {
        this.done = true;
        CacheSubscription[] cacheSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = cacheSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.replay(cacheSubscriptionArray[n2]);
            ++n2;
        }
    }

    public void onError(Throwable cacheSubscriptionArray) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)cacheSubscriptionArray);
            return;
        }
        this.error = cacheSubscriptionArray;
        this.done = true;
        cacheSubscriptionArray = this.subscribers.getAndSet(TERMINATED);
        int n = cacheSubscriptionArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.replay(cacheSubscriptionArray[n2]);
            ++n2;
        }
    }

    public void onNext(T object) {
        int n = this.tailOffset;
        int n2 = this.capacityHint;
        int n3 = 0;
        if (n == n2) {
            Node node = new Node(n);
            node.values[0] = object;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[n] = object;
            this.tailOffset = n + 1;
        }
        ++this.size;
        object = this.subscribers.get();
        n2 = ((T)object).length;
        while (n3 < n2) {
            this.replay((CacheSubscription<T>)object[n3]);
            ++n3;
        }
    }

    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    void remove(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArray;
        CacheSubscription<T>[] cacheSubscriptionArray2;
        do {
            int n;
            int n2;
            if ((n2 = (cacheSubscriptionArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (cacheSubscriptionArray2[n4] == cacheSubscription) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                cacheSubscriptionArray = EMPTY;
                continue;
            }
            cacheSubscriptionArray = new CacheSubscription[n2 - 1];
            System.arraycopy(cacheSubscriptionArray2, 0, cacheSubscriptionArray, 0, n);
            System.arraycopy(cacheSubscriptionArray2, n + 1, cacheSubscriptionArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(cacheSubscriptionArray2, cacheSubscriptionArray));
    }

    void replay(CacheSubscription<T> object) {
        if (object.getAndIncrement() != 0) {
            return;
        }
        long l = object.index;
        int n = object.offset;
        Node node = object.node;
        AtomicLong atomicLong = object.requested;
        Subscriber subscriber = object.downstream;
        int n2 = this.capacityHint;
        int n3 = 1;
        while (true) {
            boolean bl = this.done;
            int n4 = this.size == l ? 1 : 0;
            if (bl && n4 != 0) {
                object.node = null;
                object = this.error;
                if (object != null) {
                    subscriber.onError(object);
                } else {
                    subscriber.onComplete();
                }
                return;
            }
            if (n4 == 0) {
                long l2 = atomicLong.get();
                if (l2 == Long.MIN_VALUE) {
                    object.node = null;
                    return;
                }
                if (l2 != l) {
                    n4 = n;
                    Node node2 = node;
                    if (n == n2) {
                        node2 = node.next;
                        n4 = 0;
                    }
                    subscriber.onNext(node2.values[n4]);
                    n = n4 + 1;
                    ++l;
                    node = node2;
                    continue;
                }
            }
            object.index = l;
            object.offset = n;
            object.node = node;
            n3 = n4 = object.addAndGet(-n3);
            if (n4 == 0) return;
        }
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.onSubscribe((Subscription)cacheSubscription);
        this.add(cacheSubscription);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.source.subscribe((FlowableSubscriber)this);
        } else {
            this.replay(cacheSubscription);
        }
    }
}
