/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap
 *  io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSwitchMap<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        super(flowable);
        this.mapper = function;
        this.bufferSize = n;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe((Publisher)this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber)new SwitchMapSubscriber(subscriber, this.mapper, this.bufferSize, this.delayErrors));
    }
}
