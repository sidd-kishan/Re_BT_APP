/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableSkipLast$SkipLastSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import org.reactivestreams.Subscriber;

public final class FlowableSkipLast<T>
extends AbstractFlowableWithUpstream<T, T> {
    final int skip;

    public FlowableSkipLast(Flowable<T> flowable, int n) {
        super(flowable);
        this.skip = n;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new SkipLastSubscriber(subscriber, this.skip));
    }
}
