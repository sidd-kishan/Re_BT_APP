/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.BlockingObservableIterable$BlockingObservableIterator
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import java.util.Iterator;

public final class BlockingObservableIterable<T>
implements Iterable<T> {
    final int bufferSize;
    final ObservableSource<? extends T> source;

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int n) {
        this.source = observableSource;
        this.bufferSize = n;
    }

    @Override
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.bufferSize);
        this.source.subscribe((Observer)blockingObservableIterator);
        return blockingObservableIterator;
    }
}
