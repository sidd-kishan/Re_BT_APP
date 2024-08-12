/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T>
extends Observable<T> {
    final Callable<? extends Throwable> errorSupplier;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Throwable throwable;
        try {
            throwable = (Throwable)ObjectHelper.requireNonNull((Object)this.errorSupplier.call(), (String)"Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
        }
        EmptyDisposable.error((Throwable)throwable, observer);
    }
}
