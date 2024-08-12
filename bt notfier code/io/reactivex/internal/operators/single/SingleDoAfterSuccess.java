/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.single.SingleDoAfterSuccess$DoAfterObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;

public final class SingleDoAfterSuccess<T>
extends Single<T> {
    final Consumer<? super T> onAfterSuccess;
    final SingleSource<T> source;

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onAfterSuccess = consumer;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoAfterObserver(singleObserver, this.onAfterSuccess));
    }
}
