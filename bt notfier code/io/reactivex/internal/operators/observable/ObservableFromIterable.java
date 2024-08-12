/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.ObservableFromIterable$FromIterableDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableFromIterable;

public final class ObservableFromIterable<T>
extends Observable<T> {
    final Iterable<? extends T> source;

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.source = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        FromIterableDisposable fromIterableDisposable;
        block4: {
            try {
                fromIterableDisposable = this.source.iterator();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, observer);
                return;
            }
            try {
                boolean bl = fromIterableDisposable.hasNext();
                if (bl) break block4;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, observer);
                return;
            }
            EmptyDisposable.complete(observer);
            return;
        }
        fromIterableDisposable = new FromIterableDisposable(observer, fromIterableDisposable);
        observer.onSubscribe((Disposable)fromIterableDisposable);
        if (fromIterableDisposable.fusionMode) return;
        fromIterableDisposable.run();
    }
}
