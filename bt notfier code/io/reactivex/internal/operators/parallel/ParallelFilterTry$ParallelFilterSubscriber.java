/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelFilterTry$1
 *  io.reactivex.internal.operators.parallel.ParallelFilterTry$BaseFilterSubscriber
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
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelFilterTry.ParallelFilterSubscriber<T>
extends ParallelFilterTry.BaseFilterSubscriber<T> {
    final Subscriber<? super T> downstream;

    ParallelFilterTry.ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        super(predicate, biFunction);
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

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean tryOnNext(T t) {
        if (this.done) return false;
        long l = 0L;
        while (true) {
            try {
                boolean bl = this.predicate.test(t);
                if (!bl) return false;
            }
            catch (Throwable throwable) {
                int n;
                BiFunction biFunction;
                Exceptions.throwIfFatal((Throwable)throwable);
                try {
                    biFunction = this.errorHandler;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    this.cancel();
                    this.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                }
                if ((n = ParallelFilterTry.1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[(biFunction = (ParallelFailureHandling)ObjectHelper.requireNonNull((Object)biFunction.apply((Object)(++l), (Object)throwable), (String)"The errorHandler returned a null item")).ordinal()]) == 1) continue;
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
            break;
        }
        return false;
    }
}
