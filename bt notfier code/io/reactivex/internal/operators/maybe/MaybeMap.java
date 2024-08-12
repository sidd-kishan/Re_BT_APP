/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeMap$MapMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeMap;

public final class MaybeMap<T, R>
extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends R> mapper;

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.mapper = function;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe((MaybeObserver)new MapMaybeObserver(maybeObserver, this.mapper));
    }
}
