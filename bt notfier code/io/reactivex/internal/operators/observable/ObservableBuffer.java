/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableBuffer$BufferExactObserver
 *  io.reactivex.internal.operators.observable.ObservableBuffer$BufferSkipObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBuffer<T, U extends Collection<? super T>>
extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int count;
    final int skip;

    public ObservableBuffer(ObservableSource<T> observableSource, int n, int n2, Callable<U> callable) {
        super(observableSource);
        this.count = n;
        this.skip = n2;
        this.bufferSupplier = callable;
    }

    protected void subscribeActual(Observer<? super U> bufferExactObserver) {
        int n = this.skip;
        int n2 = this.count;
        if (n == n2) {
            if (!(bufferExactObserver = new BufferExactObserver(bufferExactObserver, n2, this.bufferSupplier)).createBuffer()) return;
            this.source.subscribe((Observer)bufferExactObserver);
        } else {
            this.source.subscribe((Observer)new BufferSkipObserver((Observer)bufferExactObserver, this.count, this.skip, this.bufferSupplier));
        }
    }
}
