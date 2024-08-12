/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapNotification$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import java.util.concurrent.Callable;

public final class MaybeFlatMapNotification<T, R>
extends AbstractMaybeWithUpstream<T, R> {
    final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        super(maybeSource);
        this.onSuccessMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe((MaybeObserver)new FlatMapMaybeObserver(maybeObserver, this.onSuccessMapper, this.onErrorMapper, this.onCompleteSupplier));
    }
}
