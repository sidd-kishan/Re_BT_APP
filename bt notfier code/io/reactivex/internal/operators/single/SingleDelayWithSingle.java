/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleDelayWithSingle$OtherObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;

public final class SingleDelayWithSingle<T, U>
extends Single<T> {
    final SingleSource<U> other;
    final SingleSource<T> source;

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.source = singleSource;
        this.other = singleSource2;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe((SingleObserver)new OtherObserver(singleObserver, this.source));
    }
}
