/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableLimit$LimitSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import org.reactivestreams.Subscriber;

public final class FlowableLimit<T>
extends AbstractFlowableWithUpstream<T, T> {
    final long n;

    public FlowableLimit(Flowable<T> flowable, long l) {
        super(flowable);
        this.n = l;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new LimitSubscriber(subscriber, this.n));
    }
}
