/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;

static final class FlowableInternalHelper.SubscriberOnNext<T>
implements Consumer<T> {
    final Subscriber<T> subscriber;

    FlowableInternalHelper.SubscriberOnNext(Subscriber<T> subscriber) {
        this.subscriber = subscriber;
    }

    public void accept(T t) throws Exception {
        this.subscriber.onNext(t);
    }
}
