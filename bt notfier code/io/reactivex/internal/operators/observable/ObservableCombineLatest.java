/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import java.util.Iterator;

public final class ObservableCombineLatest<T, R>
extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArray, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n, boolean bl) {
        this.sources = observableSourceArray;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = n;
        this.delayError = bl;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int n;
        ObservableSource<? extends T>[] observableSourceArray = this.sources;
        if (observableSourceArray == null) {
            Observable[] observableArray = new Observable[8];
            Iterator<ObservableSource<T>> iterator = this.sourcesIterable.iterator();
            int n2 = 0;
            while (true) {
                observableSourceArray = observableArray;
                n = ++n2;
                if (iterator.hasNext()) {
                    ObservableSource<? extends T> observableSource = iterator.next();
                    observableSourceArray = observableArray;
                    if (n2 == observableArray.length) {
                        observableSourceArray = new ObservableSource[(n2 >> 2) + n2];
                        System.arraycopy(observableArray, 0, observableSourceArray, 0, n2);
                    }
                    observableSourceArray[n2] = observableSource;
                    observableArray = observableSourceArray;
                    continue;
                }
                break;
            }
        } else {
            n = observableSourceArray.length;
        }
        if (n == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        new LatestCoordinator(observer, this.combiner, n, this.bufferSize, this.delayError).subscribe(observableSourceArray);
    }
}
