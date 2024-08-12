/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.single.SingleDoFinally$DoFinallyObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.single.SingleDoFinally;

public final class SingleDoFinally<T>
extends Single<T> {
    final Action onFinally;
    final SingleSource<T> source;

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onFinally = action;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoFinallyObserver(singleObserver, this.onFinally));
    }
}
