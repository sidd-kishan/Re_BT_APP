/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.single.SingleDoOnTerminate$DoOnTerminate
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.single.SingleDoOnTerminate;

public final class SingleDoOnTerminate<T>
extends Single<T> {
    final Action onTerminate;
    final SingleSource<T> source;

    public SingleDoOnTerminate(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onTerminate = action;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoOnTerminate(this, singleObserver));
    }
}
