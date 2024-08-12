/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Subscriber
 *  java.util.concurrent.Flow$Subscription
 *  org.reactivestreams.FlowAdapters$FlowToReactiveSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowAdapters.ReactiveToFlowSubscriber<T>
implements Subscriber<T> {
    final Flow.Subscriber<? super T> flow;

    public FlowAdapters.ReactiveToFlowSubscriber(Flow.Subscriber<? super T> subscriber) {
        this.flow = subscriber;
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
        Flow.Subscriber<? super T> subscriber = this.flow;
        object = object == null ? null : new FlowAdapters.FlowToReactiveSubscription(object);
        subscriber.onSubscribe((Flow.Subscription)object);
    }
}
