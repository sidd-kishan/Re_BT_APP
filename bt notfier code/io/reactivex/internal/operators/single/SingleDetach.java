/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleDetach$DetachSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleDetach;

public final class SingleDetach<T>
extends Single<T> {
    final SingleSource<T> source;

    public SingleDetach(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DetachSingleObserver(singleObserver));
    }
}
