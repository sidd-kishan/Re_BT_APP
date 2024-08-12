/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableToList
 *  io.reactivex.internal.operators.observable.ObservableToListSingle$ToListObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>>
extends Single<U>
implements FuseToObservable<U> {
    final Callable<U> collectionSupplier;
    final ObservableSource<T> source;

    public ObservableToListSingle(ObservableSource<T> observableSource, int n) {
        this.source = observableSource;
        this.collectionSupplier = Functions.createArrayList((int)n);
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.source = observableSource;
        this.collectionSupplier = callable;
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableToList(this.source, this.collectionSupplier));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), (String)"The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        this.source.subscribe((Observer)new ToListObserver(singleObserver, collection));
    }
}
