/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import java.util.concurrent.Callable;

public final class ObservableWindowBoundarySupplier<T, B>
extends AbstractObservableWithUpstream<T, Observable<T>> {
    final int capacityHint;
    final Callable<? extends ObservableSource<B>> other;

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int n) {
        super(observableSource);
        this.other = callable;
        this.capacityHint = n;
    }

    public void subscribeActual(Observer<? super Observable<T>> windowBoundaryMainObserver) {
        windowBoundaryMainObserver = new WindowBoundaryMainObserver(windowBoundaryMainObserver, this.capacityHint, this.other);
        this.source.subscribe((Observer)windowBoundaryMainObserver);
    }
}
