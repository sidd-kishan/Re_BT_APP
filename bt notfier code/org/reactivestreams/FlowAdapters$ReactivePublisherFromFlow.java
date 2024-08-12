/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Publisher
 *  java.util.concurrent.Flow$Subscriber
 *  org.reactivestreams.FlowAdapters$FlowToReactiveSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowAdapters.ReactivePublisherFromFlow<T>
implements Publisher<T> {
    final Flow.Publisher<? extends T> flow;

    public FlowAdapters.ReactivePublisherFromFlow(Flow.Publisher<? extends T> publisher) {
        this.flow = publisher;
    }

    public void subscribe(Subscriber<? super T> object) {
        Flow.Publisher<? extends T> publisher = this.flow;
        object = object == null ? null : new FlowAdapters.FlowToReactiveSubscriber(object);
        publisher.subscribe((Flow.Subscriber)object);
    }
}
