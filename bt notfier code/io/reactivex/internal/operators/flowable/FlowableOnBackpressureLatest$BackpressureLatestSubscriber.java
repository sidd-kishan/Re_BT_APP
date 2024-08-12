/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableOnBackpressureLatest.BackpressureLatestSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 163080509307634843L;
    volatile boolean cancelled;
    final AtomicReference<T> current;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;

    FlowableOnBackpressureLatest.BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
        this.current = new AtomicReference();
        this.downstream = subscriber;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        if (this.getAndIncrement() != 0) return;
        this.current.lazySet(null);
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!bl) return false;
        Throwable throwable = this.error;
        if (throwable != null) {
            atomicReference.lazySet(null);
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    void drain() {
        int n;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super T> subscriber = this.downstream;
        AtomicLong atomicLong = this.requested;
        AtomicReference<T> atomicReference = this.current;
        int n2 = 1;
        do {
            boolean bl;
            boolean bl2;
            boolean bl3;
            long l = 0L;
            while (true) {
                long l2 = atomicLong.get();
                bl3 = false;
                if (l == l2) break;
                bl2 = this.done;
                Object var12_11 = atomicReference.getAndSet(null);
                bl = var12_11 == null;
                if (this.checkTerminated(bl2, bl, subscriber, atomicReference)) {
                    return;
                }
                if (bl) break;
                subscriber.onNext(var12_11);
                ++l;
            }
            if (l == atomicLong.get()) {
                bl2 = this.done;
                bl = bl3;
                if (atomicReference.get() == null) {
                    bl = true;
                }
                if (this.checkTerminated(bl2, bl, subscriber, atomicReference)) {
                    return;
                }
            }
            if (l != 0L) {
                BackpressureHelper.produced((AtomicLong)atomicLong, (long)l);
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
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
        this.current.lazySet(t);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
