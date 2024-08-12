/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableCollect.CollectSubscriber<T, U>
extends DeferredScalarSubscription<U>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3589550218733891694L;
    final BiConsumer<? super U, ? super T> collector;
    boolean done;
    final U u;
    Subscription upstream;

    FlowableCollect.CollectSubscriber(Subscriber<? super U> subscriber, U u, BiConsumer<? super U, ? super T> biConsumer) {
        super(subscriber);
        this.collector = biConsumer;
        this.u = u;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.complete(this.u);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            this.collector.accept(this.u, t);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
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
