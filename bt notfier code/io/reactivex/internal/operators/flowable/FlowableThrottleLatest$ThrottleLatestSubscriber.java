/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableThrottleLatest.ThrottleLatestSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final boolean emitLast;
    long emitted;
    Throwable error;
    final AtomicReference<T> latest;
    final AtomicLong requested;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker worker;

    FlowableThrottleLatest.ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker, boolean bl) {
        this.downstream = subscriber;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.emitLast = bl;
        this.latest = new AtomicReference();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (this.getAndIncrement() != 0) return;
        this.latest.lazySet(null);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<T> atomicReference = this.latest;
        AtomicLong atomicLong = this.requested;
        Subscriber<? super T> subscriber = this.downstream;
        int n = 1;
        while (true) {
            long l;
            block17: {
                int n2;
                block16: {
                    block15: {
                        if (this.cancelled) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean bl = this.done;
                        if (bl && this.error != null) {
                            atomicReference.lazySet(null);
                            subscriber.onError(this.error);
                            this.worker.dispose();
                            return;
                        }
                        n2 = atomicReference.get() == null ? 1 : 0;
                        if (bl) {
                            if (n2 == 0 && this.emitLast) {
                                atomicReference = atomicReference.getAndSet(null);
                                l = this.emitted;
                                if (l != atomicLong.get()) {
                                    this.emitted = l + 1L;
                                    subscriber.onNext(atomicReference);
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError((Throwable)new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            } else {
                                atomicReference.lazySet(null);
                                subscriber.onComplete();
                            }
                            this.worker.dispose();
                            return;
                        }
                        if (n2 == 0) break block15;
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                        break block16;
                    }
                    if (!this.timerRunning || this.timerFired) break block17;
                }
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            Object var9_8 = atomicReference.getAndSet(null);
            l = this.emitted;
            if (l == atomicLong.get()) {
                this.upstream.cancel();
                subscriber.onError((Throwable)new MissingBackpressureException("Could not emit value due to lack of requests"));
                this.worker.dispose();
                return;
            }
            subscriber.onNext(var9_8);
            this.emitted = l + 1L;
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.schedule((Runnable)this, this.timeout, this.unit);
        }
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
        this.latest.set(t);
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
    }

    @Override
    public void run() {
        this.timerFired = true;
        this.drain();
    }
}
