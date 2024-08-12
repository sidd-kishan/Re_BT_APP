/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeOnErrorNext$OnErrorNextMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;

public final class MaybeOnErrorNext<T>
extends AbstractMaybeWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean bl) {
        super(maybeSource);
        this.resumeFunction = function;
        this.allowFatal = bl;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new OnErrorNextMaybeObserver(maybeObserver, this.resumeFunction, this.allowFatal));
    }
}
