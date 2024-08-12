/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.FuseToMaybe
 *  io.reactivex.internal.fuseable.HasUpstreamMaybeSource
 *  io.reactivex.internal.operators.maybe.MaybeIsEmpty
 *  io.reactivex.internal.operators.maybe.MaybeIsEmptySingle$IsEmptyMaybeObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.operators.maybe.MaybeIsEmpty;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T>
extends Single<Boolean>
implements HasUpstreamMaybeSource<T>,
FuseToMaybe<Boolean> {
    final MaybeSource<T> source;

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly((Maybe)new MaybeIsEmpty(this.source));
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((MaybeObserver)new IsEmptyMaybeObserver(singleObserver));
    }
}
