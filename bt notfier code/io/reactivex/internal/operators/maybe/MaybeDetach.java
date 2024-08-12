/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeDetach$DetachMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeDetach;

public final class MaybeDetach<T>
extends AbstractMaybeWithUpstream<T, T> {
    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new DetachMaybeObserver(maybeObserver));
    }
}
