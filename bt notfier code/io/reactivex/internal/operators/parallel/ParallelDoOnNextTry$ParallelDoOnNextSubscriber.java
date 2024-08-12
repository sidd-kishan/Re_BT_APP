/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1
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
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelDoOnNextTry.ParallelDoOnNextSubscriber<T>
implements ConditionalSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Consumer<? super T> onNext;
    Subscription upstream;

    ParallelDoOnNextTry.ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.downstream = subscriber;
        this.onNext = consumer;
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
            try {
                this.onNext.accept(t);
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
                if ((n = ParallelDoOnNextTry.1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[(parallelFailureHandling = (ParallelFailureHandling)ObjectHelper.requireNonNull((Object)parallelFailureHandling.apply((Object)(++l), (Object)throwable), (String)"The errorHandler returned a null item")).ordinal()]) == 1) continue;
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
            this.downstream.onNext(t);
            return true;
        }
    }
}
