/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableCount$CountSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableCount;
import org.reactivestreams.Subscriber;

public final class FlowableCount<T>
extends AbstractFlowableWithUpstream<T, Long> {
    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe((FlowableSubscriber)new CountSubscriber(subscriber));
    }
}
