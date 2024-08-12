/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleMap$MapSingleObserver
 *  io.reactivex.internal.operators.single.SingleZipArray$SingletonArrayFunc
 *  io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;

public final class SingleZipArray<T, R>
extends Single<R> {
    final SingleSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArray, Function<? super Object[], ? extends R> function) {
        this.sources = singleSourceArray;
        this.zipper = function;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArray = this.sources;
        int n = singleSourceArray.length;
        int n2 = 0;
        if (n == 1) {
            singleSourceArray[0].subscribe((SingleObserver)new SingleMap.MapSingleObserver(singleObserver, (Function)new SingletonArrayFunc(this)));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, n, this.zipper);
        singleObserver.onSubscribe((Disposable)zipCoordinator);
        while (n2 < n) {
            if (zipCoordinator.isDisposed()) {
                return;
            }
            singleObserver = singleSourceArray[n2];
            if (singleObserver == null) {
                zipCoordinator.innerError((Throwable)new NullPointerException("One of the sources is null"), n2);
                return;
            }
            singleObserver.subscribe((SingleObserver)zipCoordinator.observers[n2]);
            ++n2;
        }
    }
}
