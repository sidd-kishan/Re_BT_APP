/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapCompletable<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;

    public FlowableFlatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        super(flowable);
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new FlatMapCompletableMainSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
