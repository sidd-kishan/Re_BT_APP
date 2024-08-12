/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeCount$CountMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeCount;

public final class MaybeCount<T>
extends Single<Long>
implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe((MaybeObserver)new CountMaybeObserver(singleObserver));
    }
}
