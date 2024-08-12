/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe$TimeoutMainMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;

public final class MaybeTimeoutMaybe<T, U>
extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<? extends T> fallback;
    final MaybeSource<U> other;

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.other = maybeSource2;
        this.fallback = maybeSource3;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.fallback);
        maybeObserver.onSubscribe((Disposable)timeoutMainMaybeObserver);
        this.other.subscribe((MaybeObserver)timeoutMainMaybeObserver.other);
        this.source.subscribe((MaybeObserver)timeoutMainMaybeObserver);
    }
}
