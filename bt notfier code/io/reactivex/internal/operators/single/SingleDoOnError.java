/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.single.SingleDoOnError$DoOnError
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.single.SingleDoOnError;

public final class SingleDoOnError<T>
extends Single<T> {
    final Consumer<? super Throwable> onError;
    final SingleSource<T> source;

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.source = singleSource;
        this.onError = consumer;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoOnError(this, singleObserver));
    }
}
