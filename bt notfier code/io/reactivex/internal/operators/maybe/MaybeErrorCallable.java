/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeErrorCallable<T>
extends Maybe<T> {
    final Callable<? extends Throwable> errorSupplier;

    public MaybeErrorCallable(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Throwable throwable;
        maybeObserver.onSubscribe(Disposables.disposed());
        try {
            throwable = (Throwable)ObjectHelper.requireNonNull((Object)this.errorSupplier.call(), (String)"Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
        }
        maybeObserver.onError(throwable);
    }
}
