/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.fuseable.ScalarCallable
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

public final class ObservableJust<T>
extends Observable<T>
implements ScalarCallable<T> {
    private final T value;

    public ObservableJust(T t) {
        this.value = t;
    }

    public T call() {
        return this.value;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.value);
        observer.onSubscribe((Disposable)scalarDisposable);
        scalarDisposable.run();
    }
}
