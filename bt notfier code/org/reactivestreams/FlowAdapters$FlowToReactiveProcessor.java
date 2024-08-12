/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Processor
 *  java.util.concurrent.Flow$Subscriber
 *  java.util.concurrent.Flow$Subscription
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowSubscriber
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowSubscription
 *  org.reactivestreams.Processor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowAdapters.FlowToReactiveProcessor<T, U>
implements Flow.Processor<T, U> {
    final Processor<? super T, ? extends U> reactiveStreams;

    public FlowAdapters.FlowToReactiveProcessor(Processor<? super T, ? extends U> processor) {
        this.reactiveStreams = processor;
    }

    public void onComplete() {
        this.reactiveStreams.onComplete();
    }

    public void onError(Throwable throwable) {
        this.reactiveStreams.onError(throwable);
    }

    public void onNext(T t) {
        this.reactiveStreams.onNext(t);
    }

    public void onSubscribe(Flow.Subscription object) {
        Processor<? super T, ? extends U> processor = this.reactiveStreams;
        object = object == null ? null : new FlowAdapters.ReactiveToFlowSubscription(object);
        processor.onSubscribe((Subscription)object);
    }

    public void subscribe(Flow.Subscriber<? super U> object) {
        Processor<? super T, ? extends U> processor = this.reactiveStreams;
        object = object == null ? null : new FlowAdapters.ReactiveToFlowSubscriber(object);
        processor.subscribe((Subscriber)object);
    }
}
