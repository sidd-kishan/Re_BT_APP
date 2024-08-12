/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.parallel.ParallelFailureHandling
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.parallel.ParallelFailureHandling;
import org.reactivestreams.Subscription;

static abstract class ParallelFilterTry.BaseFilterSubscriber<T>
implements ConditionalSubscriber<T>,
Subscription {
    boolean done;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Predicate<? super T> predicate;
    Subscription upstream;

    ParallelFilterTry.BaseFilterSubscriber(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.predicate = predicate;
        this.errorHandler = biFunction;
    }

    public final void cancel() {
        this.upstream.cancel();
    }

    public final void onNext(T t) {
        if (this.tryOnNext(t)) return;
        if (this.done) return;
        this.upstream.request(1L);
    }

    public final void request(long l) {
        this.upstream.request(l);
    }
}
