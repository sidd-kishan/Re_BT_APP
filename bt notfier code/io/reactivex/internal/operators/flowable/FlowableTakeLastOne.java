/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableTakeLastOne$TakeLastOneSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import org.reactivestreams.Subscriber;

public final class FlowableTakeLastOne<T>
extends AbstractFlowableWithUpstream<T, T> {
    public FlowableTakeLastOne(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new TakeLastOneSubscriber(subscriber));
    }
}
