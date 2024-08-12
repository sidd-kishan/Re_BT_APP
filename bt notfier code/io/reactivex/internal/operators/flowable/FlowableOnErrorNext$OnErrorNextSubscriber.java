/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableOnErrorNext.OnErrorNextSubscriber<T>
extends SubscriptionArbiter
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4063763155303814625L;
    final boolean allowFatal;
    boolean done;
    final Subscriber<? super T> downstream;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
    boolean once;
    long produced;

    FlowableOnErrorNext.OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean bl) {
        super(false);
        this.downstream = subscriber;
        this.nextSupplier = function;
        this.allowFatal = bl;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.once = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Publisher publisher;
        block5: {
            long l;
            if (this.once) {
                if (this.done) {
                    RxJavaPlugins.onError((Throwable)throwable);
                    return;
                }
                this.downstream.onError(throwable);
                return;
            }
            this.once = true;
            if (this.allowFatal && !(throwable instanceof Exception)) {
                this.downstream.onError(throwable);
                return;
            }
            try {
                publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.nextSupplier.apply((Object)throwable), (String)"The nextSupplier returned a null Publisher");
                l = this.produced;
                if (l == 0L) break block5;
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
            this.produced(l);
        }
        publisher.subscribe((Subscriber)this);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (!this.once) {
            ++this.produced;
        }
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.setSubscription(subscription);
    }
}
