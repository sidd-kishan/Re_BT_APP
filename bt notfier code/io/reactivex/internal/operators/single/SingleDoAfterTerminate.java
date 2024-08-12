/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.single.SingleDoAfterTerminate$DoAfterTerminateObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;

public final class SingleDoAfterTerminate<T>
extends Single<T> {
    final Action onAfterTerminate;
    final SingleSource<T> source;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onAfterTerminate = action;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoAfterTerminateObserver(singleObserver, this.onAfterTerminate));
    }
}
