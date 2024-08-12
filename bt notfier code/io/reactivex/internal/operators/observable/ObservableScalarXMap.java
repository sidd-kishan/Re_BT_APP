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
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarXMapObservable
 *  io.reactivex.plugins.RxJavaPlugins
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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScalarXMap {
    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> scalarXMap(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.onAssembly((Observable)new ScalarXMapObservable(t, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> object, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        block8: {
            if (!(object instanceof Callable)) return false;
            try {
                object = ((Callable)object).call();
                if (object != null) break block8;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, observer);
                return true;
            }
            EmptyDisposable.complete(observer);
            return true;
        }
        try {
            object = (ObservableSource)ObjectHelper.requireNonNull((Object)function.apply(object), (String)"The mapper returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return true;
        }
        if (object instanceof Callable) {
            block9: {
                try {
                    object = ((Callable)object).call();
                    if (object != null) break block9;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptyDisposable.error((Throwable)throwable, observer);
                    return true;
                }
                EmptyDisposable.complete(observer);
                return true;
            }
            object = new ScalarDisposable(observer, object);
            observer.onSubscribe((Disposable)object);
            object.run();
        } else {
            object.subscribe(observer);
        }
        return true;
    }
}
