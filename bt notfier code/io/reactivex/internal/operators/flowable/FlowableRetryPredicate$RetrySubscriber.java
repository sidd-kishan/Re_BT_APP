/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableRetryPredicate.RetrySubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final Predicate<? super Throwable> predicate;
    long produced;
    long remaining;
    final SubscriptionArbiter sa;
    final Publisher<? extends T> source;

    FlowableRetryPredicate.RetrySubscriber(Subscriber<? super T> subscriber, long l, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.predicate = predicate;
        this.remaining = l;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        long l = this.remaining;
        if (l != Long.MAX_VALUE) {
            this.remaining = l - 1L;
        }
        if (l == 0L) {
            this.downstream.onError(throwable);
        } else {
            block5: {
                try {
                    boolean bl = this.predicate.test((Object)throwable);
                    if (bl) break block5;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    return;
                }
                this.downstream.onError(throwable);
                return;
            }
            this.subscribeNext();
        }
    }

    public void onNext(T t) {
        ++this.produced;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.sa.setSubscription(subscription);
    }

    void subscribeNext() {
        int n;
        if (this.getAndIncrement() != 0) return;
        int n2 = 1;
        do {
            if (this.sa.isCancelled()) {
                return;
            }
            long l = this.produced;
            if (l != 0L) {
                this.produced = 0L;
                this.sa.produced(l);
            }
            this.source.subscribe((Subscriber)this);
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }
}
