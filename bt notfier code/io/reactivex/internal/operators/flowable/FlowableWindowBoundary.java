/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryMainSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundary<T, B>
extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Publisher<B> other;

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int n) {
        super(flowable);
        this.other = publisher;
        this.capacityHint = n;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.capacityHint);
        subscriber.onSubscribe((Subscription)windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.innerNext();
        this.other.subscribe((Subscriber)windowBoundaryMainSubscriber.boundarySubscriber);
        this.source.subscribe((FlowableSubscriber)windowBoundaryMainSubscriber);
    }
}
