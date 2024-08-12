/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableGroupBy.State<T, K>
extends BasicIntQueueSubscription<T>
implements Publisher<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Subscriber<? super T>> actual;
    final AtomicBoolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once;
    boolean outputFused;
    final FlowableGroupBy.GroupBySubscriber<?, K, T> parent;
    int produced;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();

    FlowableGroupBy.State(int n, FlowableGroupBy.GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean bl) {
        this.cancelled = new AtomicBoolean();
        this.actual = new AtomicReference();
        this.once = new AtomicBoolean();
        this.queue = new SpscLinkedArrayQueue(n);
        this.parent = groupBySubscriber;
        this.key = k;
        this.delayError = bl;
    }

    public void cancel() {
        if (!this.cancelled.compareAndSet(false, true)) return;
        this.parent.cancel(this.key);
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<? super T> subscriber, boolean bl3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            Throwable throwable = this.error;
            if (throwable != null) {
                subscriber.onError(throwable);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable throwable = this.error;
        if (throwable != null) {
            this.queue.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    public void clear() {
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    void drainFused() {
        Object object = this.queue;
        Subscriber<? super T> subscriber = this.actual.get();
        int n = 1;
        while (true) {
            int n2;
            if (subscriber != null) {
                Throwable throwable;
                if (this.cancelled.get()) {
                    object.clear();
                    return;
                }
                boolean bl = this.done;
                if (bl && !this.delayError && (throwable = this.error) != null) {
                    object.clear();
                    subscriber.onError(throwable);
                    return;
                }
                subscriber.onNext(null);
                if (bl) {
                    object = this.error;
                    if (object != null) {
                        subscriber.onError(object);
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
            }
            if ((n2 = this.addAndGet(-n)) == 0) {
                return;
            }
            n = n2;
            if (subscriber != null) continue;
            subscriber = this.actual.get();
            n = n2;
        }
    }

    void drainNormal() {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        Subscriber<? super T> subscriber = this.actual.get();
        int n = 1;
        while (true) {
            int n2;
            if (subscriber != null) {
                long l;
                long l2 = this.requested.get();
                for (l = 0L; l != l2; ++l) {
                    boolean bl2 = this.done;
                    Object object = spscLinkedArrayQueue.poll();
                    boolean bl3 = object == null;
                    if (this.checkTerminated(bl2, bl3, subscriber, bl)) {
                        return;
                    }
                    if (bl3) break;
                    subscriber.onNext(object);
                }
                if (l == l2 && this.checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, bl)) {
                    return;
                }
                if (l != 0L) {
                    if (l2 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-l);
                    }
                    this.parent.upstream.request(l);
                }
            }
            if ((n2 = this.addAndGet(-n)) == 0) {
                return;
            }
            n = n2;
            if (subscriber != null) continue;
            subscriber = this.actual.get();
            n = n2;
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
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
        this.queue.offer(t);
        this.drain();
    }

    public T poll() {
        Object object = this.queue.poll();
        if (object != null) {
            ++this.produced;
            return (T)object;
        }
        int n = this.produced;
        if (n == 0) return null;
        this.produced = 0;
        this.parent.upstream.request((long)n);
        return null;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    public int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.outputFused = true;
        return 2;
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        if (this.once.compareAndSet(false, true)) {
            subscriber.onSubscribe((Subscription)this);
            this.actual.lazySet(subscriber);
            this.drain();
        } else {
            EmptySubscription.error((Throwable)new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }
    }
}
