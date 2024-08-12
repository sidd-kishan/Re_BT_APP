/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher$FlatMapPublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class MaybeFlatMapPublisher<T, R>
extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapPublisher(MaybeSource<T> maybeSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((MaybeObserver)new FlatMapPublisherSubscriber(subscriber, this.mapper));
    }
}
