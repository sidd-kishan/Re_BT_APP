/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T>
extends Maybe<T>
implements Callable<T> {
    final Callable<? extends T> callable;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override
    public T call() throws Exception {
        return this.callable.call();
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        block6: {
            T t;
            Disposable disposable = Disposables.empty();
            maybeObserver.onSubscribe(disposable);
            if (disposable.isDisposed()) return;
            try {
                t = this.callable.call();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                if (!disposable.isDisposed()) {
                    maybeObserver.onError(throwable);
                } else {
                    RxJavaPlugins.onError((Throwable)throwable);
                }
                break block6;
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
