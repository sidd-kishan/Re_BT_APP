/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
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
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableReduce.ReduceSubscriber<T>
extends DeferredScalarSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4663883003264602070L;
    final BiFunction<T, T, T> reducer;
    Subscription upstream;

    FlowableReduce.ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
        super(subscriber);
        this.reducer = biFunction;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        if (this.upstream == SubscriptionHelper.CANCELLED) {
            return;
        }
        this.upstream = SubscriptionHelper.CANCELLED;
        Object object = this.value;
        if (object != null) {
            this.complete(object);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.upstream == SubscriptionHelper.CANCELLED) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.upstream = SubscriptionHelper.CANCELLED;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.upstream == SubscriptionHelper.CANCELLED) {
            return;
        }
        Object object = this.value;
        if (object == null) {
            this.value = t;
        } else {
            try {
                this.value = ObjectHelper.requireNonNull((Object)this.reducer.apply(object, t), (String)"The reducer returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
