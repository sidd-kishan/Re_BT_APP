/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapMaybe<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int maxConcurrency;

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl, int n) {
        super(flowable);
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber)new FlatMapMaybeSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
