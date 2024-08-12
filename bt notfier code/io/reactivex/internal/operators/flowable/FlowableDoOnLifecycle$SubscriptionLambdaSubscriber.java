/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.LongConsumer
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDoOnLifecycle.SubscriptionLambdaSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final Subscriber<? super T> downstream;
    final Action onCancel;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    Subscription upstream;

    FlowableDoOnLifecycle.SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        this.downstream = subscriber;
        this.onSubscribe = consumer;
        this.onCancel = action;
        this.onRequest = longConsumer;
    }

    public void cancel() {
        Subscription subscription = this.upstream;
        if (subscription == SubscriptionHelper.CANCELLED) return;
        this.upstream = SubscriptionHelper.CANCELLED;
        try {
            this.onCancel.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        subscription.cancel();
    }

    public void onComplete() {
        if (this.upstream == SubscriptionHelper.CANCELLED) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.upstream != SubscriptionHelper.CANCELLED) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        try {
            this.onSubscribe.accept((Object)subscription);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            subscription.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            EmptySubscription.error((Throwable)throwable, this.downstream);
            return;
        }
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        try {
            this.onRequest.accept(l);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.request(l);
    }
}
