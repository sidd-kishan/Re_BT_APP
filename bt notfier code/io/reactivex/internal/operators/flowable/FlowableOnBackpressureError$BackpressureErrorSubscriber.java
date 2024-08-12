/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableOnBackpressureError.BackpressureErrorSubscriber<T>
extends AtomicLong
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -3176480756392482682L;
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;

    FlowableOnBackpressureError.BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.upstream.cancel();
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

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.get() != 0L) {
            this.downstream.onNext(t);
            BackpressureHelper.produced((AtomicLong)this, (long)1L);
        } else {
            this.onError((Throwable)new MissingBackpressureException("could not emit value due to lack of requests"));
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
    }
}
