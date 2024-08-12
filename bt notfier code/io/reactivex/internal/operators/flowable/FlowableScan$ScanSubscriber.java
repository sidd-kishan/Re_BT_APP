/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableScan.ScanSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final BiFunction<T, T, T> accumulator;
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;
    T value;

    FlowableScan.ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
        this.downstream = subscriber;
        this.accumulator = biFunction;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        Subscriber<? super T> subscriber = this.downstream;
        T t = this.value;
        if (t == null) {
            this.value = object;
            subscriber.onNext(object);
        } else {
            try {
                object = ObjectHelper.requireNonNull((Object)this.accumulator.apply(t, object), (String)"The value returned by the accumulator is null");
                this.value = object;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
            subscriber.onNext(object);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
