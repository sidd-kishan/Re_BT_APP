/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSingle.SingleElementSubscriber<T>
extends DeferredScalarSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -5526049321428043809L;
    final T defaultValue;
    boolean done;
    final boolean failOnEmpty;
    Subscription upstream;

    FlowableSingle.SingleElementSubscriber(Subscriber<? super T> subscriber, T t, boolean bl) {
        super(subscriber);
        this.defaultValue = t;
        this.failOnEmpty = bl;
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
        Object object = this.value;
        this.value = null;
        Object object2 = object;
        if (object == null) {
            object2 = this.defaultValue;
        }
        if (object2 == null) {
            if (this.failOnEmpty) {
                this.downstream.onError((Throwable)new NoSuchElementException());
            } else {
                this.downstream.onComplete();
            }
        } else {
            this.complete(object2);
        }
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
        if (this.value != null) {
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError((Throwable)new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
