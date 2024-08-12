/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.maybe.MaybeMap$MapMaybeObserver
 *  io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator
 *  io.reactivex.internal.operators.maybe.MaybeZipIterable$SingletonArrayFunc
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import java.util.Arrays;
import java.util.Iterator;

public final class MaybeZipIterable<T, R>
extends Maybe<R> {
    final Iterable<? extends MaybeSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.sources = iterable;
        this.zipper = function;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArray;
        int n;
        int n2;
        Object object;
        block8: {
            object = new MaybeSource[8];
            try {
                Iterator<MaybeSource<T>> iterator = this.sources.iterator();
                n2 = 0;
                n = 0;
                while (iterator.hasNext()) {
                    MaybeSource<? extends T> maybeSource = iterator.next();
                    if (maybeSource == null) {
                        object = new NullPointerException("One of the sources is null");
                        EmptyDisposable.error((Throwable)object, maybeObserver);
                        return;
                    }
                    maybeSourceArray = object;
                    if (n == ((MaybeSource[])object).length) {
                        maybeSourceArray = (MaybeSource[])Arrays.copyOf(object, (n >> 2) + n);
                    }
                    maybeSourceArray[n] = maybeSource;
                    ++n;
                    object = maybeSourceArray;
                }
                if (n != 0) break block8;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, maybeObserver);
                return;
            }
            EmptyDisposable.complete(maybeObserver);
            return;
        }
        if (n == 1) {
            object[0].subscribe((MaybeObserver)new MaybeMap.MapMaybeObserver(maybeObserver, (Function)new SingletonArrayFunc(this)));
            return;
        }
        maybeSourceArray = new MaybeZipArray.ZipCoordinator(maybeObserver, n, this.zipper);
        maybeObserver.onSubscribe((Disposable)maybeSourceArray);
        while (n2 < n) {
            if (maybeSourceArray.isDisposed()) {
                return;
            }
            object[n2].subscribe((MaybeObserver)maybeSourceArray.observers[n2]);
            ++n2;
        }
    }
}
