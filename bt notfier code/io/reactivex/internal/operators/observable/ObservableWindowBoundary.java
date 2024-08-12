/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundary$WindowBoundaryMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;

public final class ObservableWindowBoundary<T, B>
extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final ObservableSource<B> other;

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int n) {
        super(observableSource);
        this.other = observableSource2;
        this.capacityHint = n;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.capacityHint);
        observer.onSubscribe((Disposable)windowBoundaryMainObserver);
        this.other.subscribe((Observer)windowBoundaryMainObserver.boundaryObserver);
        this.source.subscribe((Observer)windowBoundaryMainObserver);
    }
}
