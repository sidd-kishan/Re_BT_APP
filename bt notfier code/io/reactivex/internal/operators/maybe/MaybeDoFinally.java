/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeDoFinally$DoFinallyObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;

public final class MaybeDoFinally<T>
extends AbstractMaybeWithUpstream<T, T> {
    final Action onFinally;

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.onFinally = action;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new DoFinallyObserver(maybeObserver, this.onFinally));
    }
}
