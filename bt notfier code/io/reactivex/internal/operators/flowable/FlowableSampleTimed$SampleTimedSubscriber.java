/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static abstract class FlowableSampleTimed.SampleTimedSubscriber<T>
extends AtomicReference<T>
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final long period;
    final AtomicLong requested = new AtomicLong();
    final Scheduler scheduler;
    final SequentialDisposable timer = new SequentialDisposable();
    final TimeUnit unit;
    Subscription upstream;

    FlowableSampleTimed.SampleTimedSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = subscriber;
        this.period = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void cancel() {
        this.cancelTimer();
        this.upstream.cancel();
    }

    void cancelTimer() {
        DisposableHelper.dispose((AtomicReference)this.timer);
    }

    abstract void complete();

    void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 == null) return;
        if (this.requested.get() != 0L) {
            this.downstream.onNext(var1_1);
            BackpressureHelper.produced((AtomicLong)this.requested, (long)1L);
        } else {
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }

    public void onComplete() {
        this.cancelTimer();
        this.complete();
    }

    public void onError(Throwable throwable) {
        this.cancelTimer();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.lazySet(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        SequentialDisposable sequentialDisposable = this.timer;
        Scheduler scheduler = this.scheduler;
        long l = this.period;
        sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit));
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }
}
