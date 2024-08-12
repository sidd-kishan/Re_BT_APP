/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$BufferedReplayCallable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$BufferedTimedReplayCallable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$FlatMapIntoIterable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$FlatMapWithCombinerOuter
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ItemDelayFunction
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ObserverOnComplete
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ObserverOnError
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ObserverOnNext
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ReplayCallable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ReplayFunction
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$SimpleBiGenerator
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$SimpleGenerator
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$TimedReplayCallable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$ZipIterableFunction
 *  io.reactivex.observables.ConnectableObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {
    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int n) {
        return new BufferedReplayCallable(observable, n);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, n, l, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, l, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }
}
