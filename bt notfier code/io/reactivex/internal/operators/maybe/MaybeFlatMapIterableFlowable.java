/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable$FlatMapIterableObserver
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import org.reactivestreams.Subscriber;

public final class MaybeFlatMapIterableFlowable<T, R>
extends Flowable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapIterableFlowable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((MaybeObserver)new FlatMapIterableObserver(subscriber, this.mapper));
    }
}
