/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeIsEmpty$IsEmptyMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeIsEmpty;

public final class MaybeIsEmpty<T>
extends AbstractMaybeWithUpstream<T, Boolean> {
    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected void subscribeActual(MaybeObserver<? super Boolean> maybeObserver) {
        this.source.subscribe((MaybeObserver)new IsEmptyMaybeObserver(maybeObserver));
    }
}
