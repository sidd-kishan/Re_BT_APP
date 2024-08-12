/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.flowable.FlowableDebounceTimed$DebounceEmitter
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
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDebounceTimed.DebounceTimedSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final Subscriber<? super T> downstream;
    volatile long index;
    final long timeout;
    Disposable timer;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker worker;

    FlowableDebounceTimed.DebounceTimedSubscriber(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = subscriber;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    void emit(long l, T t, FlowableDebounceTimed.DebounceEmitter<T> debounceEmitter) {
        if (l != this.index) return;
        if (this.get() != 0L) {
            this.downstream.onNext(t);
            BackpressureHelper.produced((AtomicLong)this, (long)1L);
            debounceEmitter.dispose();
        } else {
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        if ((disposable = (FlowableDebounceTimed.DebounceEmitter)disposable) != null) {
            disposable.emit();
        }
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(T object) {
        long l;
        if (this.done) {
            return;
        }
        this.index = l = this.index + 1L;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        object = new FlowableDebounceTimed.DebounceEmitter(object, l, this);
        this.timer = object;
        object.setResource(this.worker.schedule(object, this.timeout, this.unit));
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
}
