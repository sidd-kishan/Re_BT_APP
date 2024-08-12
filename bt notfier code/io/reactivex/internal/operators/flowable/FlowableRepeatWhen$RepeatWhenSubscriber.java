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

static final class FlowableRepeatWhen.RepeatWhenSubscriber<T>
extends FlowableRepeatWhen.WhenSourceSubscriber<T, Object> {
    private static final long serialVersionUID = -2680129890138081029L;

    FlowableRepeatWhen.RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
        super(subscriber, flowableProcessor, subscription);
    }

    public void onComplete() {
        this.again(0);
    }

    public void onError(Throwable throwable) {
        this.receiver.cancel();
        this.downstream.onError(throwable);
    }
}
