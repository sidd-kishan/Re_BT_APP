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
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T>
extends Observable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public ObservableFromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = l;
        this.unit = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        block2: {
            Object object;
            DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
            observer.onSubscribe((Disposable)deferredScalarDisposable);
            if (deferredScalarDisposable.isDisposed()) return;
            try {
                object = this.unit != null ? this.future.get(this.timeout, this.unit) : this.future.get();
                object = ObjectHelper.requireNonNull(object, (String)"Future returned null");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                if (deferredScalarDisposable.isDisposed()) return;
                observer.onError(throwable);
                break block2;
            }
            deferredScalarDisposable.complete(object);
        }
    }
}
