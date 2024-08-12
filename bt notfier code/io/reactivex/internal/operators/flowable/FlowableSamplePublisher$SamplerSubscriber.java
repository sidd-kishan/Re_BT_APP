/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import org.reactivestreams.Subscription;

static final class FlowableSamplePublisher.SamplerSubscriber<T>
implements FlowableSubscriber<Object> {
    final FlowableSamplePublisher.SamplePublisherSubscriber<T> parent;

    FlowableSamplePublisher.SamplerSubscriber(FlowableSamplePublisher.SamplePublisherSubscriber<T> samplePublisherSubscriber) {
        this.parent = samplePublisherSubscriber;
    }

    public void onComplete() {
        this.parent.complete();
    }

    public void onError(Throwable throwable) {
        this.parent.error(throwable);
    }

    public void onNext(Object object) {
        this.parent.run();
    }

    public void onSubscribe(Subscription subscription) {
        this.parent.setOther(subscription);
    }
}
