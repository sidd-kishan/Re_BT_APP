/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.maybe.MaybeDoOnTerminate$DoOnTerminate
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.maybe.MaybeDoOnTerminate;

public final class MaybeDoOnTerminate<T>
extends Maybe<T> {
    final Action onTerminate;
    final MaybeSource<T> source;

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.source = maybeSource;
        this.onTerminate = action;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new DoOnTerminate(this, maybeObserver));
    }
}
