/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableSingle$SingleElementSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableSingle;
import org.reactivestreams.Subscriber;

public final class FlowableSingle<T>
extends AbstractFlowableWithUpstream<T, T> {
    final T defaultValue;
    final boolean failOnEmpty;

    public FlowableSingle(Flowable<T> flowable, T t, boolean bl) {
        super(flowable);
        this.defaultValue = t;
        this.failOnEmpty = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new SingleElementSubscriber(subscriber, this.defaultValue, this.failOnEmpty));
    }
}
