/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableUsing$UsingObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableUsing;
import java.util.concurrent.Callable;

public final class ObservableUsing<T, D>
extends Observable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends ObservableSource<? extends T>> sourceSupplier;

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource observableSource;
        D d;
        try {
            d = this.resourceSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.sourceSupplier.apply(d), (String)"The sourceSupplier returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.disposer.accept(d);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                EmptyDisposable.error((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}), observer);
                return;
            }
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        observableSource.subscribe((Observer)new UsingObserver(observer, d, this.disposer, this.eager));
    }
}
