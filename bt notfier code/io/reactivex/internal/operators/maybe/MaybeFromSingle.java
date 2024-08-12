/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.fuseable.HasUpstreamSingleSource
 *  io.reactivex.internal.operators.maybe.MaybeFromSingle$FromSingleObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.fuseable.HasUpstreamSingleSource;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;

public final class MaybeFromSingle<T>
extends Maybe<T>
implements HasUpstreamSingleSource<T> {
    final SingleSource<T> source;

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    public SingleSource<T> source() {
        return this.source;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((SingleObserver)new FromSingleObserver(maybeObserver));
    }
}
