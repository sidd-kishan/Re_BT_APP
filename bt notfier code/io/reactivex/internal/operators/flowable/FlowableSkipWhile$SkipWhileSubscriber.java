/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSkipWhile.SkipWhileSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    final Subscriber<? super T> downstream;
    boolean notSkipping;
    final Predicate<? super T> predicate;
    Subscription upstream;

    FlowableSkipWhile.SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
        this.downstream = subscriber;
        this.predicate = predicate;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        block5: {
            block4: {
                if (this.notSkipping) {
                    this.downstream.onNext(t);
                } else {
                    try {
                        boolean bl = this.predicate.test(t);
                        if (!bl) break block4;
                    }
                    catch (Throwable throwable) {
                        Exceptions.throwIfFatal((Throwable)throwable);
                        this.upstream.cancel();
                        this.downstream.onError(throwable);
                        return;
                    }
                    this.upstream.request(1L);
                }
                break block5;
            }
            this.notSkipping = true;
            this.downstream.onNext(t);
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
