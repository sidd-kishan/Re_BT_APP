/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTakeUntilPredicate.InnerSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    final Predicate<? super T> predicate;
    Subscription upstream;

    FlowableTakeUntilPredicate.InnerSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
        this.downstream = subscriber;
        this.predicate = predicate;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (!this.done) {
            this.done = true;
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        block2: {
            if (this.done) return;
            this.downstream.onNext(t);
            try {
                boolean bl = this.predicate.test(t);
                if (!bl) return;
                this.done = true;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
                break block2;
            }
            this.upstream.cancel();
            this.downstream.onComplete();
        }
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
