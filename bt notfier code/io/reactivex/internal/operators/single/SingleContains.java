/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.internal.operators.single.SingleContains$ContainsSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.operators.single.SingleContains;

public final class SingleContains<T>
extends Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    public SingleContains(SingleSource<T> singleSource, Object object, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = object;
        this.comparer = biPredicate;
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((SingleObserver)new ContainsSingleObserver(this, singleObserver));
    }
}
