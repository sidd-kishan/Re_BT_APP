/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver
 *  io.reactivex.observers.DisposableObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;

static final class ObservableBufferBoundarySupplier.BufferBoundaryObserver<T, U extends Collection<? super T>, B>
extends DisposableObserver<B> {
    boolean once;
    final ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> parent;

    ObservableBufferBoundarySupplier.BufferBoundaryObserver(ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
        this.parent = bufferBoundarySupplierObserver;
    }

    public void onComplete() {
        if (this.once) {
            return;
        }
        this.once = true;
        this.parent.next();
    }

    public void onError(Throwable throwable) {
        if (this.once) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.once = true;
        this.parent.onError(throwable);
    }

    public void onNext(B b) {
        if (this.once) {
            return;
        }
        this.once = true;
        this.dispose();
        this.parent.next();
    }
}
