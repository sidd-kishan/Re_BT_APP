/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.maybe.MaybeFilterSingle$FilterMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;

public final class MaybeFilterSingle<T>
extends Maybe<T> {
    final Predicate<? super T> predicate;
    final SingleSource<T> source;

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.source = singleSource;
        this.predicate = predicate;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((SingleObserver)new FilterMaybeObserver(maybeObserver, this.predicate));
    }
}
