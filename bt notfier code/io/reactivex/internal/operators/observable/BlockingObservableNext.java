/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.internal.operators.observable.BlockingObservableNext$NextIterator
 *  io.reactivex.internal.operators.observable.BlockingObservableNext$NextObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import java.util.Iterator;

public final class BlockingObservableNext<T>
implements Iterable<T> {
    final ObservableSource<T> source;

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override
    public Iterator<T> iterator() {
        NextObserver nextObserver = new NextObserver();
        return new NextIterator(this.source, nextObserver);
    }
}
