/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscribers.DeferredScalarSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelReduce.ParallelReduceSubscriber<T, R>
extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final BiFunction<R, ? super T, R> reducer;

    ParallelReduce.ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
        super(subscriber);
        this.accumulator = r;
        this.reducer = biFunction;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        R r = this.accumulator;
        this.accumulator = null;
        this.complete(r);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        if (this.done) return;
        try {
            object = ObjectHelper.requireNonNull((Object)this.reducer.apply(this.accumulator, object), (String)"The reducer returned a null value");
            this.accumulator = object;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.onError(throwable);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
