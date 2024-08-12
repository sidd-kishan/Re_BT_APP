/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeSource
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualCoordinator
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;

public final class MaybeEqualSingle<T>
extends Single<Boolean> {
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeSource<? extends T> source1;
    final MaybeSource<? extends T> source2;

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.source1 = maybeSource;
        this.source2 = maybeSource2;
        this.isEqual = biPredicate;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.isEqual);
        singleObserver.onSubscribe((Disposable)equalCoordinator);
        equalCoordinator.subscribe(this.source1, this.source2);
    }
}
