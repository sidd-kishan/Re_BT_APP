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

static final class FlowableInternalHelper.SubscriberOnError<T>
implements Consumer<Throwable> {
    final Subscriber<T> subscriber;

    FlowableInternalHelper.SubscriberOnError(Subscriber<T> subscriber) {
        this.subscriber = subscriber;
    }

    public void accept(Throwable throwable) throws Exception {
        this.subscriber.onError(throwable);
    }
}
