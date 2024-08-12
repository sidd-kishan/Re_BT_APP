/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinSubscription
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.parallel.ParallelFlowable;
import java.util.Comparator;
import java.util.List;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T>
extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.source = parallelFlowable;
        this.comparator = comparator;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe((Subscription)sortedJoinSubscription);
        this.source.subscribe((Subscriber[])sortedJoinSubscription.subscribers);
    }
}
