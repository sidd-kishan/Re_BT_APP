/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SampleMainEmitLast
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SampleMainNoLast
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSamplePublisher<T>
extends Flowable<T> {
    final boolean emitLast;
    final Publisher<?> other;
    final Publisher<T> source;

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean bl) {
        this.source = publisher;
        this.other = publisher2;
        this.emitLast = bl;
    }

    protected void subscribeActual(Subscriber<? super T> serializedSubscriber) {
        serializedSubscriber = new SerializedSubscriber(serializedSubscriber);
        if (this.emitLast) {
            this.source.subscribe((Subscriber)new SampleMainEmitLast((Subscriber)serializedSubscriber, this.other));
        } else {
            this.source.subscribe((Subscriber)new SampleMainNoLast((Subscriber)serializedSubscriber, this.other));
        }
    }
}
