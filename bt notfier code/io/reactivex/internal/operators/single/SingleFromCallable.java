/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T>
extends Single<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        Object object;
        Disposable disposable = Disposables.empty();
        singleObserver.onSubscribe(disposable);
        if (disposable.isDisposed()) {
            return;
        }
        try {
            object = ObjectHelper.requireNonNull(this.callable.call(), (String)"The callable returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (!disposable.isDisposed()) {
                singleObserver.onError(throwable);
            } else {
                RxJavaPlugins.onError((Throwable)throwable);
            }
            return;
        }
        if (disposable.isDisposed()) return;
        singleObserver.onSuccess(object);
    }
}
