/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeToSingle$ToSingleMaybeSubscriber
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeToSingle;

public final class MaybeToSingle<T>
extends Single<T>
implements HasUpstreamMaybeSource<T> {
    final T defaultValue;
    final MaybeSource<T> source;

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.source = maybeSource;
        this.defaultValue = t;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((MaybeObserver)new ToSingleMaybeSubscriber(singleObserver, this.defaultValue));
    }
}
