/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleToObservable$SingleToObservableObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleToObservable;

public final class SingleToObservable<T>
extends Observable<T> {
    final SingleSource<? extends T> source;

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public static <T> SingleObserver<T> create(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(SingleToObservable.create(observer));
    }
}
