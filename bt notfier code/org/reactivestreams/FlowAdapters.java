/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Processor
 *  java.util.concurrent.Flow$Publisher
 *  java.util.concurrent.Flow$Subscriber
 *  org.reactivestreams.FlowAdapters$FlowPublisherFromReactive
 *  org.reactivestreams.FlowAdapters$FlowToReactiveProcessor
 *  org.reactivestreams.FlowAdapters$FlowToReactiveSubscriber
 *  org.reactivestreams.FlowAdapters$ReactivePublisherFromFlow
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowProcessor
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowSubscriber
 *  org.reactivestreams.Processor
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package org.reactivestreams;

import java.util.Objects;
import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowAdapters {
    private FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flow.Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "reactiveStreamsProcessor");
        if (processor instanceof ReactiveToFlowProcessor) {
            processor = ((ReactiveToFlowProcessor)processor).flow;
        } else {
            if (processor instanceof Flow.Processor) return processor;
            processor = new FlowToReactiveProcessor((Processor)processor);
        }
        return processor;
    }

    public static <T> Flow.Publisher<T> toFlowPublisher(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "reactiveStreamsPublisher");
        if (publisher instanceof ReactivePublisherFromFlow) {
            publisher = ((ReactivePublisherFromFlow)publisher).flow;
        } else {
            if (publisher instanceof Flow.Publisher) return publisher;
            publisher = new FlowPublisherFromReactive((Publisher)publisher);
        }
        return publisher;
    }

    public static <T> Flow.Subscriber<T> toFlowSubscriber(Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        if (subscriber instanceof ReactiveToFlowSubscriber) {
            subscriber = ((ReactiveToFlowSubscriber)subscriber).flow;
        } else {
            if (subscriber instanceof Flow.Subscriber) return subscriber;
            subscriber = new FlowToReactiveSubscriber((Subscriber)subscriber);
        }
        return subscriber;
    }

    public static <T, U> Processor<T, U> toProcessor(Flow.Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "flowProcessor");
        if (processor instanceof FlowToReactiveProcessor) {
            processor = ((FlowToReactiveProcessor)processor).reactiveStreams;
        } else {
            if (processor instanceof Processor) return processor;
            processor = new ReactiveToFlowProcessor((Flow.Processor)processor);
        }
        return processor;
    }

    public static <T> Publisher<T> toPublisher(Flow.Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "flowPublisher");
        if (publisher instanceof FlowPublisherFromReactive) {
            publisher = ((FlowPublisherFromReactive)publisher).reactiveStreams;
        } else {
            if (publisher instanceof Publisher) return publisher;
            publisher = new ReactivePublisherFromFlow((Flow.Publisher)publisher);
        }
        return publisher;
    }

    public static <T> Subscriber<T> toSubscriber(Flow.Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "flowSubscriber");
        if (subscriber instanceof FlowToReactiveSubscriber) {
            subscriber = ((FlowToReactiveSubscriber)subscriber).reactiveStreams;
        } else {
            if (subscriber instanceof Subscriber) return subscriber;
            subscriber = new ReactiveToFlowSubscriber((Flow.Subscriber)subscriber);
        }
        return subscriber;
    }
}
