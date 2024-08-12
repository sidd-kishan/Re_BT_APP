/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableFromArray;

public final class ObservableFromArray<T>
extends Observable<T> {
    final T[] array;

    public ObservableFromArray(T[] TArray) {
        this.array = TArray;
    }

    public void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, (Object[])this.array);
        observer.onSubscribe((Disposable)fromArrayDisposable);
        if (fromArrayDisposable.fusionMode) {
            return;
        }
        fromArrayDisposable.run();
    }
}
