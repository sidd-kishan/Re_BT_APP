/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableToList$ToListObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableToList;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>>
extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> collectionSupplier;

    public ObservableToList(ObservableSource<T> observableSource, int n) {
        super(observableSource);
        this.collectionSupplier = Functions.createArrayList((int)n);
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.collectionSupplier = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        Collection collection;
        try {
            collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), (String)"The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        this.source.subscribe((Observer)new ToListObserver(observer, collection));
    }
}
