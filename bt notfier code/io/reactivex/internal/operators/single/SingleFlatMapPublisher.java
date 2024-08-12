/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleFlatMapPublisher$SingleFlatMapPublisherObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapPublisher<T, R>
extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final SingleSource<T> source;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((SingleObserver)new SingleFlatMapPublisherObserver(subscriber, this.mapper));
    }
}
