/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleHide$HideSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleHide;

public final class SingleHide<T>
extends Single<T> {
    final SingleSource<? extends T> source;

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new HideSingleObserver(singleObserver));
    }
}
