/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSupport
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutTask
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimeoutTimed.TimeoutSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription,
FlowableTimeoutTimed.TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Subscriber<? super T> downstream;
    final AtomicLong requested;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Subscription> upstream;
    final Scheduler.Worker worker;

    FlowableTimeoutTimed.TimeoutSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = subscriber;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        if (this.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.worker.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.get();
        if (l == Long.MAX_VALUE) return;
        long l2 = 1L + l;
        if (!this.compareAndSet(l, l2)) return;
        ((Disposable)this.task.get()).dispose();
        this.downstream.onNext(t);
        this.startTimeout(l2);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void onTimeout(long l) {
        if (!this.compareAndSet(l, Long.MAX_VALUE)) return;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError((Throwable)new TimeoutException(ExceptionHelper.timeoutMessage((long)this.timeout, (TimeUnit)this.unit)));
        this.worker.dispose();
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }

    void startTimeout(long l) {
        this.task.replace(this.worker.schedule((Runnable)new FlowableTimeoutTimed.TimeoutTask(l, (FlowableTimeoutTimed.TimeoutSupport)this), this.timeout, this.unit));
    }
}
