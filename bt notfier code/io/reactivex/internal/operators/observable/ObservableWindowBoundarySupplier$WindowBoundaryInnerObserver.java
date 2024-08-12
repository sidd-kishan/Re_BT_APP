/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryMainObserver
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B>
extends DisposableObserver<B> {
    boolean done;
    final ObservableWindowBoundarySupplier.WindowBoundaryMainObserver<T, B> parent;

    ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver(ObservableWindowBoundarySupplier.WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
        this.parent = windowBoundaryMainObserver;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.innerError(throwable);
    }

    public void onNext(B b) {
        if (this.done) {
            return;
        }
        this.done = true;
        this.dispose();
        this.parent.innerNext(this);
    }
}
