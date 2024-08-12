/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.single.SingleMap$MapSingleObserver
 *  io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator
 *  io.reactivex.internal.operators.single.SingleZipIterable$SingletonArrayFunc
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class SingleZipIterable<T, R>
extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.sources = iterable;
        this.zipper = function;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArray;
        int n;
        int n2;
        Object object;
        block8: {
            object = new SingleSource[8];
            try {
                Iterator<SingleSource<T>> iterator = this.sources.iterator();
                n2 = 0;
                n = 0;
                while (iterator.hasNext()) {
                    SingleSource<? extends T> singleSource = iterator.next();
                    if (singleSource == null) {
                        object = new NullPointerException("One of the sources is null");
                        EmptyDisposable.error((Throwable)object, singleObserver);
                        return;
                    }
                    singleSourceArray = object;
                    if (n == ((SingleSource[])object).length) {
                        singleSourceArray = (SingleSource[])Arrays.copyOf(object, (n >> 2) + n);
                    }
                    singleSourceArray[n] = singleSource;
                    ++n;
                    object = singleSourceArray;
                }
                if (n != 0) break block8;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, singleObserver);
                return;
            }
            EmptyDisposable.error((Throwable)new NoSuchElementException(), singleObserver);
            return;
        }
        if (n == 1) {
            object[0].subscribe((SingleObserver)new SingleMap.MapSingleObserver(singleObserver, (Function)new SingletonArrayFunc(this)));
            return;
        }
        singleSourceArray = new SingleZipArray.ZipCoordinator(singleObserver, n, this.zipper);
        singleObserver.onSubscribe((Disposable)singleSourceArray);
        while (n2 < n) {
            if (singleSourceArray.isDisposed()) {
                return;
            }
            object[n2].subscribe((SingleObserver)singleSourceArray.observers[n2]);
            ++n2;
        }
    }
}
