/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleError<T>
extends Single<T> {
    final Callable<? extends Throwable> errorSupplier;

    public SingleError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        Throwable throwable;
        try {
            throwable = (Throwable)ObjectHelper.requireNonNull((Object)this.errorSupplier.call(), (String)"Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
        }
        EmptyDisposable.error((Throwable)throwable, singleObserver);
    }
}
