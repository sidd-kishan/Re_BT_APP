/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector$WindowBoundaryMainObserver
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;

static final class ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver<T, V>
extends DisposableObserver<V> {
    boolean done;
    final ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> parent;
    final UnicastSubject<T> w;

    ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver(ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
        this.parent = windowBoundaryMainObserver;
        this.w = unicastSubject;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.parent.close(this);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.error(throwable);
    }

    public void onNext(V v) {
        this.dispose();
        this.onComplete();
    }
}
