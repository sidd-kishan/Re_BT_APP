/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

static final class ParallelMap.ParallelMapConditionalSubscriber<T, R>
implements ConditionalSubscriber<T>,
Subscription {
    boolean done;
    final ConditionalSubscriber<? super R> downstream;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;

    ParallelMap.ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
        this.downstream = conditionalSubscriber;
        this.mapper = function;
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

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.onError(throwable);
            return;
        }
        this.downstream.onNext(object);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }

    public boolean tryOnNext(T object) {
        if (this.done) {
            return false;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.onError(throwable);
            return false;
        }
        return this.downstream.tryOnNext(object);
    }
}
