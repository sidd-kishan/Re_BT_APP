/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscription
 *  io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionDelayError
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T>
extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int n, boolean bl) {
        this.source = parallelFlowable;
        this.prefetch = n;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Object object = this.delayErrors ? new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch) : new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        subscriber.onSubscribe((Subscription)object);
        this.source.subscribe((Subscriber[])object.subscribers);
    }
}
