/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.maybe.MaybeMap$MapMaybeObserver
 *  io.reactivex.internal.operators.maybe.MaybeZipArray$SingletonArrayFunc
 *  io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;

public final class MaybeZipArray<T, R>
extends Maybe<R> {
    final MaybeSource<? extends T>[] sources;
    final Function<? super Object[], ? extends R> zipper;

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArray, Function<? super Object[], ? extends R> function) {
        this.sources = maybeSourceArray;
        this.zipper = function;
    }

    protected void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArray = this.sources;
        int n = maybeSourceArray.length;
        int n2 = 0;
        if (n == 1) {
            maybeSourceArray[0].subscribe((MaybeObserver)new MaybeMap.MapMaybeObserver(maybeObserver, (Function)new SingletonArrayFunc(this)));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, n, this.zipper);
        maybeObserver.onSubscribe((Disposable)zipCoordinator);
        while (n2 < n) {
            if (zipCoordinator.isDisposed()) {
                return;
            }
            maybeObserver = maybeSourceArray[n2];
            if (maybeObserver == null) {
                zipCoordinator.innerError((Throwable)new NullPointerException("One of the sources is null"), n2);
                return;
            }
            maybeObserver.subscribe((MaybeObserver)zipCoordinator.observers[n2]);
            ++n2;
        }
    }
}
