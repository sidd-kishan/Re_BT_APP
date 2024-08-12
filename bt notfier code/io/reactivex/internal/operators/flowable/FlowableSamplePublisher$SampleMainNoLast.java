/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowableSamplePublisher.SampleMainNoLast<T>
extends FlowableSamplePublisher.SamplePublisherSubscriber<T> {
    private static final long serialVersionUID = -3029755663834015785L;

    FlowableSamplePublisher.SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
        super(subscriber, publisher);
    }

    void completion() {
        this.downstream.onComplete();
    }

    void run() {
        this.emit();
    }
}
