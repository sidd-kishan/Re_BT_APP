/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Publisher
 *  java.util.concurrent.Flow$Subscriber
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowAdapters.FlowPublisherFromReactive<T>
implements Flow.Publisher<T> {
    final Publisher<? extends T> reactiveStreams;

    public FlowAdapters.FlowPublisherFromReactive(Publisher<? extends T> publisher) {
        this.reactiveStreams = publisher;
    }

    public void subscribe(Flow.Subscriber<? super T> object) {
        Publisher<? extends T> publisher = this.reactiveStreams;
        object = object == null ? null : new FlowAdapters.ReactiveToFlowSubscriber(object);
        publisher.subscribe((Subscriber)object);
    }
}
