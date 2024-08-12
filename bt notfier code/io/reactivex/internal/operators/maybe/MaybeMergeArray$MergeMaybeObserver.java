/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

static final class MaybeMergeArray.MergeMaybeObserver<T>
extends BasicIntQueueSubscription<T>
implements MaybeObserver<T> {
    private static final long serialVersionUID = -660395290758764731L;
    volatile boolean cancelled;
    long consumed;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    boolean outputFused;
    final MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> queue;
    final AtomicLong requested;
    final CompositeDisposable set;
    final int sourceCount;

    MaybeMergeArray.MergeMaybeObserver(Subscriber<? super T> subscriber, int n, MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
        this.downstream = subscriber;
        this.sourceCount = n;
        this.set = new CompositeDisposable();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
        this.queue = simpleQueueWithConsumerIndex;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.set.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
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
        int n;
        Subscriber<? super T> subscriber = this.downstream;
        MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
        int n2 = 1;
        do {
            if (this.cancelled) {
                simpleQueueWithConsumerIndex.clear();
                return;
            }
            Throwable throwable = (Throwable)this.error.get();
            if (throwable != null) {
                simpleQueueWithConsumerIndex.clear();
                subscriber.onError(throwable);
                return;
            }
            n = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount ? 1 : 0;
            if (!simpleQueueWithConsumerIndex.isEmpty()) {
                subscriber.onNext(null);
            }
            if (n != 0) {
                subscriber.onComplete();
                return;
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    void drainNormal() {
        int n;
        Subscriber<? super T> subscriber = this.downstream;
        MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
        long l = this.consumed;
        int n2 = 1;
        do {
            long l2 = this.requested.get();
            while (l != l2) {
                if (this.cancelled) {
                    simpleQueueWithConsumerIndex.clear();
                    return;
                }
                if ((Throwable)this.error.get() != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(this.error.terminate());
                    return;
                }
                if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                    subscriber.onComplete();
                    return;
                }
                Object object = simpleQueueWithConsumerIndex.poll();
                if (object == null) break;
                if (object == NotificationLite.COMPLETE) continue;
                subscriber.onNext(object);
                ++l;
            }
            if (l == l2) {
                if ((Throwable)this.error.get() != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(this.error.terminate());
                    return;
                }
                while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                    simpleQueueWithConsumerIndex.drop();
                }
                if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                    subscriber.onComplete();
                    return;
                }
            }
            this.consumed = l;
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.queue.offer((Object)NotificationLite.COMPLETE);
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            this.set.dispose();
            this.queue.offer((Object)NotificationLite.COMPLETE);
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.set.add(disposable);
    }

    public void onSuccess(T t) {
        this.queue.offer(t);
        this.drain();
    }

    public T poll() throws Exception {
        Object object;
        while ((object = this.queue.poll()) == NotificationLite.COMPLETE) {
        }
        return (T)object;
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
}
