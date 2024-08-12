/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableThrottleFirstTimed.DebounceTimedSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final Subscriber<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final SequentialDisposable timer = new SequentialDisposable();
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker worker;

    FlowableThrottleFirstTimed.DebounceTimedSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = subscriber;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        if (this.gate) return;
        this.gate = true;
        if (this.get() != 0L) {
            this.downstream.onNext(object);
            BackpressureHelper.produced((AtomicLong)this, (long)1L);
            object = (Disposable)this.timer.get();
            if (object != null) {
                object.dispose();
            }
            this.timer.replace(this.worker.schedule((Runnable)this, this.timeout, this.unit));
        } else {
            this.done = true;
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
    }

    @Override
    public void run() {
        this.gate = false;
    }
}
