/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleFlatMap$SingleFlatMapCallback
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleFlatMap;

public final class SingleFlatMap<T, R>
extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final SingleSource<? extends T> source;

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.mapper = function;
        this.source = singleSource;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe((SingleObserver)new SingleFlatMapCallback(singleObserver, this.mapper));
    }
}
