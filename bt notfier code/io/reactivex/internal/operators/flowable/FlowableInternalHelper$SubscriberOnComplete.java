/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import org.reactivestreams.Subscriber;

static final class FlowableInternalHelper.SubscriberOnComplete<T>
implements Action {
    final Subscriber<T> subscriber;

    FlowableInternalHelper.SubscriberOnComplete(Subscriber<T> subscriber) {
        this.subscriber = subscriber;
    }

    public void run() throws Exception {
        this.subscriber.onComplete();
    }
}
