/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.BlockingObservableLatest$BlockingObservableLatestIterator
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import java.util.Iterator;

public final class BlockingObservableLatest<T>
implements Iterable<T> {
    final ObservableSource<T> source;

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.source).materialize().subscribe((Observer)blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
