/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapSingle$FlatMapSingleSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapSingle<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;

    public FlowableFlatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl, int n) {
        super(flowable);
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber)new FlatMapSingleSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
