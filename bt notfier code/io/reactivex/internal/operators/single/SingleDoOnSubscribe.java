/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.single.SingleDoOnSubscribe$DoOnSubscribeSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;

public final class SingleDoOnSubscribe<T>
extends Single<T> {
    final Consumer<? super Disposable> onSubscribe;
    final SingleSource<T> source;

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.source = singleSource;
        this.onSubscribe = consumer;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new DoOnSubscribeSingleObserver(singleObserver, this.onSubscribe));
    }
}
