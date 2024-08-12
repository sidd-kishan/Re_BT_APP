/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.DeferredScalarDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T>
extends Observable<T>
implements Callable<T> {
    final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override
    public T call() throws Exception {
        return (T)ObjectHelper.requireNonNull(this.callable.call(), (String)"The callable returned a null value");
    }

    public void subscribeActual(Observer<? super T> observer) {
        Object object;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe((Disposable)deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            object = ObjectHelper.requireNonNull(this.callable.call(), (String)"Callable returned null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (!deferredScalarDisposable.isDisposed()) {
                observer.onError(throwable);
            } else {
                RxJavaPlugins.onError((Throwable)throwable);
            }
            return;
        }
        deferredScalarDisposable.complete(object);
    }
}
