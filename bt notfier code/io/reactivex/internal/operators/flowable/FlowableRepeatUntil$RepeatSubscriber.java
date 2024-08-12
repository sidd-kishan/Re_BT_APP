/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableRepeatUntil.RepeatSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    long produced;
    final SubscriptionArbiter sa;
    final Publisher<? extends T> source;
    final BooleanSupplier stop;

    FlowableRepeatUntil.RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.stop = booleanSupplier;
    }

    public void onComplete() {
        block3: {
            block2: {
                try {
                    boolean bl = this.stop.getAsBoolean();
                    if (!bl) break block2;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                this.downstream.onComplete();
                break block3;
            }
            this.subscribeNext();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
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
