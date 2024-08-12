/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$1
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapDelayed
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapImmediate
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap
 *  io.reactivex.internal.util.ErrorMode
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMap<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int n, ErrorMode errorMode) {
        super(flowable);
        this.mapper = function;
        this.prefetch = n;
        this.errorMode = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int n, ErrorMode errorMode) {
        int n2 = 1.$SwitchMap$io$reactivex$internal$util$ErrorMode[errorMode.ordinal()];
        if (n2 == 1) return new ConcatMapDelayed(subscriber, function, n, false);
        if (n2 == 2) return new ConcatMapDelayed(subscriber, function, n, true);
        return new ConcatMapImmediate(subscriber, function, n);
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe((Publisher)this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableConcatMap.subscribe(subscriber, this.mapper, this.prefetch, this.errorMode));
    }
}
