/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeDefer<T>
extends Maybe<T> {
    final Callable<? extends MaybeSource<? extends T>> maybeSupplier;

    public MaybeDefer(Callable<? extends MaybeSource<? extends T>> callable) {
        this.maybeSupplier = callable;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeSource maybeSource;
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.maybeSupplier.call(), (String)"The maybeSupplier returned a null MaybeSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, maybeObserver);
            return;
        }
        maybeSource.subscribe(maybeObserver);
    }
}
