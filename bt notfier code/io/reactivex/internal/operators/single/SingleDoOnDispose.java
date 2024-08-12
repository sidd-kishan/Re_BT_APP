/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.single.SingleDoOnDispose$DoOnDisposeObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.single.SingleDoOnDispose;

public final class SingleDoOnDispose<T>
extends Single<T> {
    final Action onDispose;
    final SingleSource<T> source;

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onDispose = action;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoOnDisposeObserver(singleObserver, this.onDispose));
    }
}
