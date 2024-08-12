/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.flowable.FlowableTake$TakeSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableTakePublisher<T>
extends Flowable<T> {
    final long limit;
    final Publisher<T> source;

    public FlowableTakePublisher(Publisher<T> publisher, long l) {
        this.source = publisher;
        this.limit = l;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((Subscriber)new FlowableTake.TakeSubscriber(subscriber, this.limit));
    }
}
