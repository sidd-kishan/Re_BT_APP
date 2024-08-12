/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector$FlatMapBiMainObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;

public final class MaybeFlatMapBiSelector<T, U, R>
extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.mapper = function;
        this.resultSelector = biFunction;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe((MaybeObserver)new FlatMapBiMainObserver(maybeObserver, this.mapper, this.resultSelector));
    }
}
