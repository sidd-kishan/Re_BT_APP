/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapSingle$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;

public final class MaybeFlatMapSingle<T, R>
extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe((MaybeObserver)new FlatMapMaybeObserver(singleObserver, this.mapper));
    }
}
