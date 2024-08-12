/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Processor
 *  java.util.concurrent.Flow$Subscriber
 *  java.util.concurrent.Flow$Subscription
 *  org.reactivestreams.FlowAdapters$FlowToReactiveSubscriber
 *  org.reactivestreams.FlowAdapters$FlowToReactiveSubscription
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

static final class FlowAdapters.ReactiveToFlowProcessor<T, U>
implements Processor<T, U> {
    final Flow.Processor<? super T, ? extends U> flow;

    public FlowAdapters.ReactiveToFlowProcessor(Flow.Processor<? super T, ? extends U> processor) {
        this.flow = processor;
    }

    public void onComplete() {
        this.flow.onComplete();
    }

    public void onError(Throwable throwable) {
        this.flow.onError(throwable);
    }

    public void onNext(T t) {
        this.flow.onNext(t);
    }

    public void onSubscribe(Subscription object) {
        Flow.Processor<? super T, ? extends U> processor = this.flow;
        object = object == null ? null : new FlowAdapters.FlowToReactiveSubscription(object);
        processor.onSubscribe((Flow.Subscription)object);
    }

    public void subscribe(Subscriber<? super U> object) {
        Flow.Processor<? super T, ? extends U> processor = this.flow;
        object = object == null ? null : new FlowAdapters.FlowToReactiveSubscriber(object);
        processor.subscribe((Flow.Subscriber)object);
    }
}
