/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRefCount
 *  io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableRefCount.RefCountSubscriber<T>
extends AtomicBoolean
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -7419642935409022375L;
    final FlowableRefCount.RefConnection connection;
    final Subscriber<? super T> downstream;
    final FlowableRefCount<T> parent;
    Subscription upstream;

    FlowableRefCount.RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, FlowableRefCount.RefConnection refConnection) {
        this.downstream = subscriber;
        this.parent = flowableRefCount;
        this.connection = refConnection;
    }

    public void cancel() {
        this.upstream.cancel();
        if (!this.compareAndSet(false, true)) return;
        this.parent.cancel(this.connection);
    }

    public void onComplete() {
        if (!this.compareAndSet(false, true)) return;
        this.parent.terminated(this.connection);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.compareAndSet(false, true)) {
            this.parent.terminated(this.connection);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
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
