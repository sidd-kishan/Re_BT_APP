/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R>
implements FlowableSubscriber<T>,
QueueSubscription<R> {
    protected boolean done;
    protected final Subscriber<? super R> downstream;
    protected QueueSubscription<T> qs;
    protected int sourceMode;
    protected Subscription upstream;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.downstream = subscriber;
    }

    protected void afterDownstream() {
    }

    protected boolean beforeDownstream() {
        return true;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void clear() {
        this.qs.clear();
    }

    protected final void fail(Throwable throwable) {
        Exceptions.throwIfFatal((Throwable)throwable);
        this.upstream.cancel();
        this.onError(throwable);
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
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

    public final void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            this.qs = (QueueSubscription)subscription;
        }
        if (!this.beforeDownstream()) return;
        this.downstream.onSubscribe((Subscription)this);
        this.afterDownstream();
    }

    public void request(long l) {
        this.upstream.request(l);
    }

    protected final int transitiveBoundaryFusion(int n) {
        QueueSubscription<T> queueSubscription = this.qs;
        if (queueSubscription == null) return 0;
        if ((n & 4) != 0) return 0;
        if ((n = queueSubscription.requestFusion(n)) == 0) return n;
        this.sourceMode = n;
        return n;
    }
}
