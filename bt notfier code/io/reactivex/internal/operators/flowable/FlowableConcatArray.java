/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.flowable.FlowableConcatArray$ConcatArraySubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T>
extends Flowable<T> {
    final boolean delayError;
    final Publisher<? extends T>[] sources;

    public FlowableConcatArray(Publisher<? extends T>[] publisherArray, boolean bl) {
        this.sources = publisherArray;
        this.delayError = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.sources, this.delayError, subscriber);
        subscriber.onSubscribe((Subscription)concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
