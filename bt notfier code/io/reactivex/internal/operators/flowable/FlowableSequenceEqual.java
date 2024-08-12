/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinator
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T>
extends Flowable<Boolean> {
    final BiPredicate<? super T, ? super T> comparer;
    final Publisher<? extends T> first;
    final int prefetch;
    final Publisher<? extends T> second;

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int n) {
        this.first = publisher;
        this.second = publisher2;
        this.comparer = biPredicate;
        this.prefetch = n;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.prefetch, this.comparer);
        subscriber.onSubscribe((Subscription)equalCoordinator);
        equalCoordinator.subscribe(this.first, this.second);
    }
}
