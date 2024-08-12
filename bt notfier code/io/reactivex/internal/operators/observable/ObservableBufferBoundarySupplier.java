/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier$BufferBoundarySupplierObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B>
extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.boundarySupplier = callable;
        this.bufferSupplier = callable2;
    }

    protected void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe((Observer)new BufferBoundarySupplierObserver((Observer)new SerializedObserver(observer), this.bufferSupplier, this.boundarySupplier));
    }
}
