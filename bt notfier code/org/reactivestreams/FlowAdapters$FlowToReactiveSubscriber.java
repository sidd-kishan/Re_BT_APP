/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.util.concurrent.Flow$Subscriber
 *  java.util.concurrent.Flow$Subscription
 *  org.reactivestreams.FlowAdapters$ReactiveToFlowSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package org.reactivestreams;

import java.util.concurrent.Flow;
import org.reactivestreams.FlowAdapters;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowAdapters.FlowToReactiveSubscriber<T>
implements Flow.Subscriber<T> {
    final Subscriber<? super T> reactiveStreams;

    public FlowAdapters.FlowToReactiveSubscriber(Subscriber<? super T> subscriber) {
        this.reactiveStreams = subscriber;
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
        Subscriber<? super T> subscriber = this.reactiveStreams;
        object = object == null ? null : new FlowAdapters.ReactiveToFlowSubscription(object);
        subscriber.onSubscribe((Subscription)object);
    }
}
