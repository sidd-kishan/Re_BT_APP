/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe$TakeUntilMainMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;

public final class MaybeTakeUntilMaybe<T, U>
extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> other;

    public MaybeTakeUntilMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        super(maybeSource);
        this.other = maybeSource2;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe((Disposable)takeUntilMainMaybeObserver);
        this.other.subscribe((MaybeObserver)takeUntilMainMaybeObserver.other);
        this.source.subscribe((MaybeObserver)takeUntilMainMaybeObserver);
    }
}
