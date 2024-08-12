/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableReplay$DisposeConsumer
 *  io.reactivex.internal.operators.observable.ObserverResourceWrapper
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;

static final class ObservableReplay.MulticastReplay<R, U>
extends Observable<R> {
    private final Callable<? extends ConnectableObservable<U>> connectableFactory;
    private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

    ObservableReplay.MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        this.connectableFactory = callable;
        this.selector = function;
    }

    protected void subscribeActual(Observer<? super R> observerResourceWrapper) {
        ObservableSource observableSource;
        ConnectableObservable connectableObservable;
        try {
            connectableObservable = (ConnectableObservable)ObjectHelper.requireNonNull(this.connectableFactory.call(), (String)"The connectableFactory returned a null ConnectableObservable");
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.selector.apply((Object)connectableObservable), (String)"The selector returned a null ObservableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observerResourceWrapper);
            return;
        }
        observerResourceWrapper = new ObserverResourceWrapper(observerResourceWrapper);
        observableSource.subscribe((Observer)observerResourceWrapper);
        connectableObservable.connect((Consumer)new ObservableReplay.DisposeConsumer(observerResourceWrapper));
    }
}
