/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableRetryBiPredicate.RetryBiSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    long produced;
    int retries;
    final SubscriptionArbiter sa;
    final Publisher<? extends T> source;

    FlowableRetryBiPredicate.RetryBiSubscriber(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.predicate = biPredicate;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        block2: {
            try {
                int n;
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
                this.retries = n = this.retries + 1;
                boolean bl = biPredicate.test((Object)n, (Object)throwable);
                if (bl) break block2;
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
