/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.BlockingObservableMostRecent$MostRecentObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import java.util.Iterator;

public final class BlockingObservableMostRecent<T>
implements Iterable<T> {
    final T initialValue;
    final ObservableSource<T> source;

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.source = observableSource;
        this.initialValue = t;
    }

    @Override
    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.initialValue);
        this.source.subscribe((Observer)mostRecentObserver);
        return mostRecentObserver.getIterable();
    }
}
