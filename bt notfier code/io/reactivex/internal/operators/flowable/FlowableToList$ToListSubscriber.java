/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableToList.ToListSubscriber<T, U extends Collection<? super T>>
extends DeferredScalarSubscription<U>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -8134157938864266736L;
    Subscription upstream;

    FlowableToList.ToListSubscriber(Subscriber<? super U> subscriber, U u) {
        super(subscriber);
        this.value = u;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        this.complete(this.value);
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        Collection collection = (Collection)this.value;
        if (collection == null) return;
        collection.add(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
