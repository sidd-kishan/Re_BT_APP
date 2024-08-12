/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableSerialized<T>
extends AbstractFlowableWithUpstream<T, T> {
    public FlowableSerialized(Flowable<T> flowable) {
        super(flowable);
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new SerializedSubscriber(subscriber));
    }
}
