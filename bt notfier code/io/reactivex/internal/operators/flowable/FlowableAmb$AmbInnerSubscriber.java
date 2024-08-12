/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableAmb$AmbCoordinator
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableAmb.AmbInnerSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -1185974347409665484L;
    final Subscriber<? super T> downstream;
    final int index;
    final AtomicLong missedRequested = new AtomicLong();
    final FlowableAmb.AmbCoordinator<T> parent;
    boolean won;

    FlowableAmb.AmbInnerSubscriber(FlowableAmb.AmbCoordinator<T> ambCoordinator, int n, Subscriber<? super T> subscriber) {
        this.parent = ambCoordinator;
        this.index = n;
        this.downstream = subscriber;
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        if (this.won) {
            this.downstream.onComplete();
        } else if (this.parent.win(this.index)) {
            this.won = true;
            this.downstream.onComplete();
        } else {
            ((Subscription)this.get()).cancel();
        }
    }

    public void onError(Throwable throwable) {
        if (this.won) {
            this.downstream.onError(throwable);
        } else if (this.parent.win(this.index)) {
            this.won = true;
            this.downstream.onError(throwable);
        } else {
            ((Subscription)this.get()).cancel();
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.won) {
            this.downstream.onNext(t);
        } else if (this.parent.win(this.index)) {
            this.won = true;
            this.downstream.onNext(t);
        } else {
            ((Subscription)this.get()).cancel();
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce((AtomicReference)this, (AtomicLong)this.missedRequested, (Subscription)subscription);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest((AtomicReference)this, (AtomicLong)this.missedRequested, (long)l);
    }
}
