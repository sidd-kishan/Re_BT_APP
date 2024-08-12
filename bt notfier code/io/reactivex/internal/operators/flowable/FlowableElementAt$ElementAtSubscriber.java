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

static final class FlowableElementAt.ElementAtSubscriber<T>
extends DeferredScalarSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4066607327284737757L;
    long count;
    final T defaultValue;
    boolean done;
    final boolean errorOnFewer;
    final long index;
    Subscription upstream;

    FlowableElementAt.ElementAtSubscriber(Subscriber<? super T> subscriber, long l, T t, boolean bl) {
        super(subscriber);
        this.index = l;
        this.defaultValue = t;
        this.errorOnFewer = bl;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        T t = this.defaultValue;
        if (t == null) {
            if (this.errorOnFewer) {
                this.downstream.onError((Throwable)new NoSuchElementException());
            } else {
                this.downstream.onComplete();
            }
        } else {
            this.complete(t);
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
        long l = this.count;
        if (l == this.index) {
            this.done = true;
            this.upstream.cancel();
            this.complete(t);
            return;
        }
        this.count = l + 1L;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }
}
