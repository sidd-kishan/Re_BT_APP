/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe$ConcatMapMaybeSubscriber
 *  io.reactivex.internal.util.ErrorMode
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapMaybe<T, R>
extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int n) {
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber)new ConcatMapMaybeSubscriber(subscriber, this.mapper, this.prefetch, this.errorMode));
    }
}
