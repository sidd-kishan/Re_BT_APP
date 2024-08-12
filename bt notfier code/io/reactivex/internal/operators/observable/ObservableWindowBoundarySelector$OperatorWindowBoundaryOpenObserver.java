/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$WindowBoundaryMainObserver
 *  io.reactivex.observers.DisposableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.observers.DisposableObserver;

static final class ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver<T, B>
extends DisposableObserver<B> {
    final ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> parent;

    ObservableWindowBoundarySelector.OperatorWindowBoundaryOpenObserver(ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
        this.parent = windowBoundaryMainObserver;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.error(throwable);
    }

    public void onNext(B b) {
        this.parent.open(b);
    }
}
