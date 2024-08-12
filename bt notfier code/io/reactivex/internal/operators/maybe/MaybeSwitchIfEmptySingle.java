/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;

public final class MaybeSwitchIfEmptySingle<T>
extends Single<T>
implements HasUpstreamMaybeSource<T> {
    final SingleSource<? extends T> other;
    final MaybeSource<T> source;

    public MaybeSwitchIfEmptySingle(MaybeSource<T> maybeSource, SingleSource<? extends T> singleSource) {
        this.source = maybeSource;
        this.other = singleSource;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((MaybeObserver)new SwitchIfEmptyMaybeObserver(singleObserver, this.other));
    }
}
