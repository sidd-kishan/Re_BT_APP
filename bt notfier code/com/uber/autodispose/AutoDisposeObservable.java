/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposingObserverImpl
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposingObserverImpl;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

final class AutoDisposeObservable<T>
extends Observable<T> {
    private final CompletableSource scope;
    private final ObservableSource<T> source;

    AutoDisposeObservable(ObservableSource<T> observableSource, CompletableSource completableSource) {
        this.source = observableSource;
        this.scope = completableSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new AutoDisposingObserverImpl(this.scope, observer));
    }
}
