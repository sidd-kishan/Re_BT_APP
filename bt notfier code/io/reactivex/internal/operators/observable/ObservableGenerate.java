/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.ObservableGenerate$GeneratorDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S>
extends Observable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.stateSupplier = callable;
        this.generator = biFunction;
        this.disposeState = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Object object;
        try {
            object = this.stateSupplier.call();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, observer);
            return;
        }
        object = new GeneratorDisposable(observer, this.generator, this.disposeState, object);
        observer.onSubscribe(object);
        object.run();
    }
}
