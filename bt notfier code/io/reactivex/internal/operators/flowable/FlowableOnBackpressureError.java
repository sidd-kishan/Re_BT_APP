/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureError$BackpressureErrorSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureError<T>
extends AbstractFlowableWithUpstream<T, T> {
    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new BackpressureErrorSubscriber(subscriber));
    }
}
