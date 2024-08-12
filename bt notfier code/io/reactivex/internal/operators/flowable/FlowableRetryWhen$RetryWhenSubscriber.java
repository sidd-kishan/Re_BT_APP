/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber
 *  io.reactivex.processors.FlowableProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.processors.FlowableProcessor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableRetryWhen.RetryWhenSubscriber<T>
extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
    private static final long serialVersionUID = -2680129890138081029L;

    FlowableRetryWhen.RetryWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Subscription subscription) {
        super(subscriber, flowableProcessor, subscription);
    }

    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.again(throwable);
    }
}
