/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableTakeLast$TakeLastSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import org.reactivestreams.Subscriber;

public final class FlowableTakeLast<T>
extends AbstractFlowableWithUpstream<T, T> {
    final int count;

    public FlowableTakeLast(Flowable<T> flowable, int n) {
        super(flowable);
        this.count = n;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new TakeLastSubscriber(subscriber, this.count));
    }
}
