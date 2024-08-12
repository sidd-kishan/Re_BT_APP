/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import java.util.concurrent.Callable;

static final class ObservableScalarXMap.ScalarXMapObservable<T, R>
extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final T value;

    ObservableScalarXMap.ScalarXMapObservable(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.value = t;
        this.mapper = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        Object object;
        try {
            object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(this.value), (String)"The mapper returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        if (object instanceof Callable) {
            block6: {
                try {
                    object = ((Callable)object).call();
                    if (object != null) break block6;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return;
                }
                EmptyDisposable.complete(observer);
                return;
            }
            object = new ObservableScalarXMap.ScalarDisposable(observer, object);
            observer.onSubscribe((Disposable)object);
            object.run();
        } else {
            object.subscribe(observer);
        }
    }
}
