/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableScanSeed$ScanSeedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R>
extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> accumulator;
    final Callable<R> seedSupplier;

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }

    public void subscribeActual(Observer<? super R> observer) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.seedSupplier.call(), (String)"The seed supplied is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        this.source.subscribe((Observer)new ScanSeedObserver(observer, this.accumulator, object));
    }
}
