/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.ObservableAmb$AmbCoordinator
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import java.util.Iterator;

public final class ObservableAmb<T>
extends Observable<T> {
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArray, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.sources = observableSourceArray;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int n;
        ObservableSource<? extends T>[] observableSourceArray;
        block9: {
            observableSourceArray = this.sources;
            if (observableSourceArray == null) {
                Object object = new Observable[8];
                try {
                    Iterator<ObservableSource<T>> iterator = this.sourcesIterable.iterator();
                    int n2 = 0;
                    while (true) {
                        observableSourceArray = object;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            ObservableSource<? extends T> observableSource = iterator.next();
                            if (observableSource == null) {
                                object = new NullPointerException("One of the sources is null");
                                EmptyDisposable.error((Throwable)object, observer);
                                return;
                            }
                            observableSourceArray = object;
                            if (n2 == ((Observable[])object).length) {
                                observableSourceArray = new ObservableSource[(n2 >> 2) + n2];
                                System.arraycopy(object, 0, observableSourceArray, 0, n2);
                            }
                            observableSourceArray[n2] = observableSource;
                            object = observableSourceArray;
                            continue;
                        }
                        break block9;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return;
                }
            }
            n = observableSourceArray.length;
        }
        if (n == 0) {
            EmptyDisposable.complete(observer);
            return;
        }
        if (n == 1) {
            observableSourceArray[0].subscribe(observer);
            return;
        }
        new AmbCoordinator(observer, n).subscribe(observableSourceArray);
    }
}
