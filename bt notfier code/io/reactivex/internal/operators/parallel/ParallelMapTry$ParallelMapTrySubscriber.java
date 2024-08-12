/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelMapTry$1
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.parallel.ParallelFailureHandling
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelMapTry.ParallelMapTrySubscriber<T, R>
implements ConditionalSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super R> downstream;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;

    ParallelMapTry.ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.downstream = subscriber;
        this.mapper = function;
        this.errorHandler = biFunction;
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
        if (this.tryOnNext(t)) return;
        if (this.done) return;
        this.upstream.request(1L);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean tryOnNext(T t) {
        if (this.done) {
            return false;
        }
        long l = 0L;
        while (true) {
            Object object;
            try {
                object = ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null value");
            }
            catch (Throwable throwable) {
                int n;
                ParallelFailureHandling parallelFailureHandling;
                Exceptions.throwIfFatal((Throwable)throwable);
                try {
                    parallelFailureHandling = this.errorHandler;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.cancel();
                    this.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    return false;
                }
                if ((n = ParallelMapTry.1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[(parallelFailureHandling = (ParallelFailureHandling)ObjectHelper.requireNonNull((Object)parallelFailureHandling.apply((Object)(++l), (Object)throwable), (String)"The errorHandler returned a null item")).ordinal()]) == 1) continue;
                if (n == 2) return false;
                if (n != 3) {
                    this.cancel();
                    this.onError(throwable);
                    return false;
                }
                this.cancel();
                this.onComplete();
                return false;
            }
            this.downstream.onNext(object);
            return true;
        }
    }
}
