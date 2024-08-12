/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableMap
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$SingletonArrayFunc
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestFromObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import java.util.Arrays;
import java.util.Iterator;

public final class ObservableWithLatestFromMany<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final ObservableSource<?>[] otherArray;
    final Iterable<? extends ObservableSource<?>> otherIterable;

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArray, Function<? super Object[], R> function) {
        super(observableSource);
        this.otherArray = observableSourceArray;
        this.otherIterable = null;
        this.combiner = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        int n;
        ObservableSource[] observableSourceArray;
        ObservableSource[] observableSourceArray2;
        block7: {
            observableSourceArray2 = this.otherArray;
            if (observableSourceArray2 == null) {
                observableSourceArray = new ObservableSource[8];
                try {
                    Iterator<ObservableSource<?>> iterator = this.otherIterable.iterator();
                    int n2 = 0;
                    while (true) {
                        observableSourceArray2 = observableSourceArray;
                        n = ++n2;
                        if (iterator.hasNext()) {
                            ObservableSource<?> observableSource = iterator.next();
                            observableSourceArray2 = observableSourceArray;
                            if (n2 == observableSourceArray.length) {
                                observableSourceArray2 = (ObservableSource[])Arrays.copyOf(observableSourceArray, (n2 >> 1) + n2);
                            }
                            observableSourceArray2[n2] = observableSource;
                            observableSourceArray = observableSourceArray2;
                            continue;
                        }
                        break block7;
                        break;
                    }
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return;
                }
            }
            n = observableSourceArray2.length;
        }
        if (n == 0) {
            new ObservableMap(this.source, (Function)new SingletonArrayFunc(this)).subscribeActual(observer);
            return;
        }
        observableSourceArray = new WithLatestFromObserver(observer, this.combiner, n);
        observer.onSubscribe((Disposable)observableSourceArray);
        observableSourceArray.subscribe(observableSourceArray2, n);
        this.source.subscribe((Observer)observableSourceArray);
    }
}
