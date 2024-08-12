/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleResumeNext$ResumeMainSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleResumeNext;

public final class SingleResumeNext<T>
extends Single<T> {
    final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;
    final SingleSource<? extends T> source;

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.source = singleSource;
        this.nextFunction = function;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new ResumeMainSingleObserver(singleObserver, this.nextFunction));
    }
}
