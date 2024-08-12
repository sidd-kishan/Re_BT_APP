/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import org.reactivestreams.Subscription;

static abstract class ParallelFilter.BaseFilterSubscriber<T>
implements ConditionalSubscriber<T>,
Subscription {
    boolean done;
    final Predicate<? super T> predicate;
    Subscription upstream;

    ParallelFilter.BaseFilterSubscriber(Predicate<? super T> predicate) {
        this.predicate = predicate;
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
