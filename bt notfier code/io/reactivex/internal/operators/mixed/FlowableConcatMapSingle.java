/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber
 *  io.reactivex.internal.util.ErrorMode
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapSingle<T, R>
extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int n) {
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber)new ConcatMapSingleSubscriber(subscriber, this.mapper, this.prefetch, this.errorMode));
    }
}
