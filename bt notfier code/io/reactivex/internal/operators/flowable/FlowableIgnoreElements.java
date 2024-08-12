/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableIgnoreElements$IgnoreElementsSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import org.reactivestreams.Subscriber;

public final class FlowableIgnoreElements<T>
extends AbstractFlowableWithUpstream<T, T> {
    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new IgnoreElementsSubscriber(subscriber));
    }
}
