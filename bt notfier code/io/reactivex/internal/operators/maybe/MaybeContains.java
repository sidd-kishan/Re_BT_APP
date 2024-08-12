/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeContains$ContainsMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeContains;

public final class MaybeContains<T>
extends Single<Boolean>
implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;
    final Object value;

    public MaybeContains(MaybeSource<T> maybeSource, Object object) {
        this.source = maybeSource;
        this.value = object;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((MaybeObserver)new ContainsMaybeObserver(singleObserver, this.value));
    }
}
