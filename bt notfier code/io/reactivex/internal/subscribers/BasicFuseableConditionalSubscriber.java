/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableConditionalSubscriber<T, R>
implements ConditionalSubscriber<T>,
QueueSubscription<R> {
    protected boolean done;
    protected final ConditionalSubscriber<? super R> downstream;
    protected QueueSubscription<T> qs;
    protected int sourceMode;
    protected Subscription upstream;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.downstream = conditionalSubscriber;
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
