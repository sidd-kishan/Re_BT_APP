/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T>
extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = l;
        this.unit = timeUnit;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        block5: {
            T t;
            Disposable disposable = Disposables.empty();
            maybeObserver.onSubscribe(disposable);
            if (disposable.isDisposed()) return;
            try {
                t = this.timeout <= 0L ? this.future.get() : this.future.get(this.timeout, this.unit);
            }
            catch (Throwable throwable) {
                Throwable throwable2 = throwable;
                if (throwable instanceof ExecutionException) {
                    throwable2 = throwable.getCause();
                }
                Exceptions.throwIfFatal((Throwable)throwable2);
                if (disposable.isDisposed()) return;
                maybeObserver.onError(throwable2);
                break block5;
            }
            if (disposable.isDisposed()) return;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        }
    }
}
