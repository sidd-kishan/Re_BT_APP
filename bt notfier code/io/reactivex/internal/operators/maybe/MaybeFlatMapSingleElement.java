/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;

public final class MaybeFlatMapSingleElement<T, R>
extends Maybe<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapSingleElement(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe((MaybeObserver)new FlatMapMaybeObserver(maybeObserver, this.mapper));
    }
}
