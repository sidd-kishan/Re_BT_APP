/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.parallel.ParallelFilter$BaseFilterSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelFilter.ParallelFilterSubscriber<T>
extends ParallelFilter.BaseFilterSubscriber<T> {
    final Subscriber<? super T> downstream;

    ParallelFilter.ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
        super(predicate);
        this.downstream = subscriber;
    }

    public void onComplete() {
        if (this.done) return;
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

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public boolean tryOnNext(T t) {
        block2: {
            if (this.done) return false;
            try {
                boolean bl = this.predicate.test(t);
                if (!bl) return false;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                this.onError(throwable);
                break block2;
            }
            this.downstream.onNext(t);
            return true;
        }
        return false;
    }
}
