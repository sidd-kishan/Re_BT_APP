/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeSource
 *  io.reactivex.Notification
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.SingleConverter
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleOnSubscribe
 *  io.reactivex.SingleOperator
 *  io.reactivex.SingleSource
 *  io.reactivex.SingleTransformer
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function3
 *  io.reactivex.functions.Function4
 *  io.reactivex.functions.Function5
 *  io.reactivex.functions.Function6
 *  io.reactivex.functions.Function7
 *  io.reactivex.functions.Function8
 *  io.reactivex.functions.Function9
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.fuseable.FuseToMaybe
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.observers.BiConsumerSingleObserver
 *  io.reactivex.internal.observers.BlockingMultiObserver
 *  io.reactivex.internal.observers.ConsumerSingleObserver
 *  io.reactivex.internal.observers.FutureSingleObserver
 *  io.reactivex.internal.operators.completable.CompletableFromSingle
 *  io.reactivex.internal.operators.completable.CompletableToFlowable
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap
 *  io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher
 *  io.reactivex.internal.operators.flowable.FlowableSingleSingle
 *  io.reactivex.internal.operators.maybe.MaybeFilterSingle
 *  io.reactivex.internal.operators.maybe.MaybeFromSingle
 *  io.reactivex.internal.operators.mixed.SingleFlatMapObservable
 *  io.reactivex.internal.operators.observable.ObservableConcatMap
 *  io.reactivex.internal.operators.observable.ObservableSingleSingle
 *  io.reactivex.internal.operators.single.SingleAmb
 *  io.reactivex.internal.operators.single.SingleCache
 *  io.reactivex.internal.operators.single.SingleContains
 *  io.reactivex.internal.operators.single.SingleCreate
 *  io.reactivex.internal.operators.single.SingleDefer
 *  io.reactivex.internal.operators.single.SingleDelay
 *  io.reactivex.internal.operators.single.SingleDelayWithCompletable
 *  io.reactivex.internal.operators.single.SingleDelayWithObservable
 *  io.reactivex.internal.operators.single.SingleDelayWithPublisher
 *  io.reactivex.internal.operators.single.SingleDelayWithSingle
 *  io.reactivex.internal.operators.single.SingleDematerialize
 *  io.reactivex.internal.operators.single.SingleDetach
 *  io.reactivex.internal.operators.single.SingleDoAfterSuccess
 *  io.reactivex.internal.operators.single.SingleDoAfterTerminate
 *  io.reactivex.internal.operators.single.SingleDoFinally
 *  io.reactivex.internal.operators.single.SingleDoOnDispose
 *  io.reactivex.internal.operators.single.SingleDoOnError
 *  io.reactivex.internal.operators.single.SingleDoOnEvent
 *  io.reactivex.internal.operators.single.SingleDoOnSubscribe
 *  io.reactivex.internal.operators.single.SingleDoOnSuccess
 *  io.reactivex.internal.operators.single.SingleDoOnTerminate
 *  io.reactivex.internal.operators.single.SingleEquals
 *  io.reactivex.internal.operators.single.SingleError
 *  io.reactivex.internal.operators.single.SingleFlatMap
 *  io.reactivex.internal.operators.single.SingleFlatMapCompletable
 *  io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable
 *  io.reactivex.internal.operators.single.SingleFlatMapIterableObservable
 *  io.reactivex.internal.operators.single.SingleFlatMapMaybe
 *  io.reactivex.internal.operators.single.SingleFlatMapPublisher
 *  io.reactivex.internal.operators.single.SingleFromCallable
 *  io.reactivex.internal.operators.single.SingleFromPublisher
 *  io.reactivex.internal.operators.single.SingleFromUnsafeSource
 *  io.reactivex.internal.operators.single.SingleHide
 *  io.reactivex.internal.operators.single.SingleInternalHelper
 *  io.reactivex.internal.operators.single.SingleJust
 *  io.reactivex.internal.operators.single.SingleLift
 *  io.reactivex.internal.operators.single.SingleMap
 *  io.reactivex.internal.operators.single.SingleMaterialize
 *  io.reactivex.internal.operators.single.SingleNever
 *  io.reactivex.internal.operators.single.SingleObserveOn
 *  io.reactivex.internal.operators.single.SingleOnErrorReturn
 *  io.reactivex.internal.operators.single.SingleResumeNext
 *  io.reactivex.internal.operators.single.SingleSubscribeOn
 *  io.reactivex.internal.operators.single.SingleTakeUntil
 *  io.reactivex.internal.operators.single.SingleTimeout
 *  io.reactivex.internal.operators.single.SingleTimer
 *  io.reactivex.internal.operators.single.SingleToFlowable
 *  io.reactivex.internal.operators.single.SingleToObservable
 *  io.reactivex.internal.operators.single.SingleUnsubscribeOn
 *  io.reactivex.internal.operators.single.SingleUsing
 *  io.reactivex.internal.operators.single.SingleZipArray
 *  io.reactivex.internal.operators.single.SingleZipIterable
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observers.TestObserver
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 *  org.reactivestreams.Publisher
 */
package io.reactivex;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.SingleConverter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDematerialize;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleDoOnTerminate;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleMaterialize;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Single<T>
implements SingleSource<T> {
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Single)new SingleAmb(null, iterable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> ambArray(SingleSource<? extends T> ... singleSourceArray) {
        if (singleSourceArray.length == 0) {
            return Single.error(SingleInternalHelper.emptyThrower());
        }
        if (singleSourceArray.length != 1) return RxJavaPlugins.onAssembly((Single)new SingleAmb(singleSourceArray, null));
        return Single.wrap(singleSourceArray[0]);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        return Single.concat(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        return Single.concat(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        return Single.concat(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3, singleSource4}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        return Single.concat(Flowable.fromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        return Single.concat(publisher, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapPublisher(publisher, SingleInternalHelper.toFlowable(), n, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap(observableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArray(SingleSource<? extends T> ... singleSourceArray) {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMap(Flowable.fromArray((Object[])singleSourceArray), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEager(SingleSource<? extends T> ... singleSourceArray) {
        return Flowable.fromArray((Object[])singleSourceArray).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Publisher<? extends SingleSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapEager(SingleInternalHelper.toFlowable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.requireNonNull(singleOnSubscribe, (String)"source is null");
        return RxJavaPlugins.onAssembly((Single)new SingleCreate(singleOnSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, (String)"singleSupplier is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, (String)"first is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"second is null");
        return RxJavaPlugins.onAssembly((Single)new SingleEquals(singleSource, singleSource2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> error(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"exception is null");
        return Single.error(Functions.justCallable((Object)throwable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, (String)"errorSupplier is null");
        return RxJavaPlugins.onAssembly((Single)new SingleError(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, (String)"callable is null");
        return RxJavaPlugins.onAssembly((Single)new SingleFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> fromFuture(Future<? extends T> future) {
        return Single.toSingle(Flowable.fromFuture(future));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        return Single.toSingle(Flowable.fromFuture(future, (long)l, (TimeUnit)timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Single<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return Single.toSingle(Flowable.fromFuture(future, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Single<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        return Single.toSingle(Flowable.fromFuture(future, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> fromObservable(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"observableSource is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableSingleSingle(observableSource, null));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"publisher is null");
        return RxJavaPlugins.onAssembly((Single)new SingleFromPublisher(publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> just(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return RxJavaPlugins.onAssembly((Single)new SingleJust(t));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        return Single.merge(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        return Single.merge(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        return Single.merge(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3, singleSource4}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        return Single.merge(Flowable.fromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"source is null");
        return RxJavaPlugins.onAssembly((Single)new SingleFlatMap(singleSource, Functions.identity()));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        return Single.mergeDelayError(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        return Single.mergeDelayError(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        return Single.mergeDelayError(Flowable.fromArray((Object[])new SingleSource[]{singleSource, singleSource2, singleSource3, singleSource4}));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> iterable) {
        return Single.mergeDelayError(Flowable.fromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> never() {
        return RxJavaPlugins.onAssembly((Single)SingleNever.INSTANCE);
    }

    private Single<T> timeout0(long l, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleTimeout((SingleSource)this, l, timeUnit, scheduler, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Single<Long> timer(long l, TimeUnit timeUnit) {
        return Single.timer(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Single<Long> timer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleTimer(l, timeUnit, scheduler));
    }

    private static <T> Single<T> toSingle(Flowable<T> flowable) {
        return RxJavaPlugins.onAssembly((Single)new FlowableSingleSingle(flowable, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> unsafeCreate(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"onSubscribe is null");
        if (singleSource instanceof Single) throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        return RxJavaPlugins.onAssembly((Single)new SingleFromUnsafeSource(singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        return Single.using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean bl) {
        ObjectHelper.requireNonNull(callable, (String)"resourceSupplier is null");
        ObjectHelper.requireNonNull(function, (String)"singleFunction is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposer is null");
        return RxJavaPlugins.onAssembly((Single)new SingleUsing(callable, function, consumer, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<T> wrap(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"source is null");
        if (!(singleSource instanceof Single)) return RxJavaPlugins.onAssembly((Single)new SingleFromUnsafeSource(singleSource));
        return RxJavaPlugins.onAssembly((Single)((Single)singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(singleSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(singleSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(singleSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(singleSource8, (String)"source8 is null");
        ObjectHelper.requireNonNull(singleSource9, (String)"source9 is null");
        return Single.zipArray(Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(singleSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(singleSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(singleSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(singleSource8, (String)"source8 is null");
        return Single.zipArray(Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(singleSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(singleSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(singleSource7, (String)"source7 is null");
        return Single.zipArray(Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(singleSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(singleSource6, (String)"source6 is null");
        return Single.zipArray(Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(singleSource5, (String)"source5 is null");
        return Single.zipArray(Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(singleSource4, (String)"source4 is null");
        return Single.zipArray(Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(singleSource3, (String)"source3 is null");
        return Single.zipArray(Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(singleSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(singleSource2, (String)"source2 is null");
        return Single.zipArray(Functions.toFunction(biFunction), singleSource, singleSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Single)new SingleZipIterable(iterable, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T> ... singleSourceArray) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(singleSourceArray, (String)"sources is null");
        if (singleSourceArray.length != 0) return RxJavaPlugins.onAssembly((Single)new SingleZipArray(singleSourceArray, function));
        return Single.error(new NoSuchElementException());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> ambWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return Single.ambArray(this, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R as(SingleConverter<T, ? extends R> singleConverter) {
        return (R)((SingleConverter)ObjectHelper.requireNonNull(singleConverter, (String)"converter is null")).apply(this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((SingleObserver<? super T>)blockingMultiObserver);
        return (T)blockingMultiObserver.blockingGet();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> cache() {
        return RxJavaPlugins.onAssembly((Single)new SingleCache((SingleSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<U> cast(Class<? extends U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.map(Functions.castFunction(clazz));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return Single.wrap(((SingleTransformer)ObjectHelper.requireNonNull(singleTransformer, (String)"transformer is null")).apply(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        return Single.concat(this, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> contains(Object object) {
        return this.contains(object, (BiPredicate<Object, Object>)ObjectHelper.equalsPredicate());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> contains(Object object, BiPredicate<Object, Object> biPredicate) {
        ObjectHelper.requireNonNull((Object)object, (String)"value is null");
        ObjectHelper.requireNonNull(biPredicate, (String)"comparer is null");
        return RxJavaPlugins.onAssembly((Single)new SingleContains((SingleSource)this, object, biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Single<T> delay(long l, TimeUnit timeUnit) {
        return this.delay(l, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delay(l, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelay((SingleSource)this, l, timeUnit, scheduler, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Single<T> delay(long l, TimeUnit timeUnit, boolean bl) {
        return this.delay(l, timeUnit, Schedulers.computation(), bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Single<T> delaySubscription(long l, TimeUnit timeUnit) {
        return this.delaySubscription(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> delaySubscription(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delaySubscription((ObservableSource)Observable.timer((long)l, (TimeUnit)timeUnit, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> delaySubscription(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelayWithCompletable((SingleSource)this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelayWithObservable((SingleSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<T> delaySubscription(SingleSource<U> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelayWithSingle((SingleSource)this, singleSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelayWithPublisher((SingleSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return RxJavaPlugins.onAssembly((Maybe)new SingleDematerialize(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onAfterSuccess is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoAfterSuccess((SingleSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onAfterTerminate is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoAfterTerminate((SingleSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doFinally(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoFinally((SingleSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnDispose(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onDispose is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnDispose((SingleSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnError((SingleSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"onEvent is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnEvent((SingleSource)this, biConsumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnSubscribe((SingleSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onSuccess is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnSuccess((SingleSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onTerminate is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDoOnTerminate((SingleSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFilterSingle((SingleSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Single)new SingleFlatMap((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new SingleFlatMapCompletable((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Maybe)new SingleFlatMapMaybe((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new SingleFlatMapObservable((SingleSource)this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new SingleFlatMapPublisher((SingleSource)this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new SingleFlatMapIterableFlowable((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new SingleFlatMapIterableObservable((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> hide() {
        return RxJavaPlugins.onAssembly((Single)new SingleHide((SingleSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromSingle((SingleSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        ObjectHelper.requireNonNull(singleOperator, (String)"lift is null");
        return RxJavaPlugins.onAssembly((Single)new SingleLift((SingleSource)this, singleOperator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Single)new SingleMap((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Single)new SingleMaterialize(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        return Single.merge(this, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleObserveOn((SingleSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> onErrorResumeNext(Single<? extends T> single) {
        ObjectHelper.requireNonNull(single, (String)"resumeSingleInCaseOfError is null");
        return this.onErrorResumeNext(Functions.justFunction(single));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, (String)"resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.onAssembly((Single)new SingleResumeNext((SingleSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, (String)"resumeFunction is null");
        return RxJavaPlugins.onAssembly((Single)new SingleOnErrorReturn((SingleSource)this, function, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, (String)"value is null");
        return RxJavaPlugins.onAssembly((Single)new SingleOnErrorReturn((SingleSource)this, null, t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Single)new SingleDetach((SingleSource)this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeat() {
        return this.toFlowable().repeat();
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeat(long l) {
        return this.toFlowable().repeat(l);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return this.toFlowable().repeatUntil(booleanSupplier);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return this.toFlowable().repeatWhen(function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retry() {
        return Single.toSingle(this.toFlowable().retry());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retry(long l) {
        return Single.toSingle(this.toFlowable().retry(l));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retry(long l, Predicate<? super Throwable> predicate) {
        return Single.toSingle(this.toFlowable().retry(l, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return Single.toSingle(this.toFlowable().retry(biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retry(Predicate<? super Throwable> predicate) {
        return Single.toSingle(this.toFlowable().retry(predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return Single.toSingle(this.toFlowable().retryWhen(function));
    }

    @SchedulerSupport(value="none")
    public final Disposable subscribe() {
        return this.subscribe(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.ON_ERROR_MISSING);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumerSingleObserver) {
        ObjectHelper.requireNonNull(biConsumerSingleObserver, (String)"onCallback is null");
        biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumerSingleObserver);
        this.subscribe((SingleObserver<? super T>)biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return this.subscribe(consumer, (Consumer<Throwable>)Functions.ON_ERROR_MISSING);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumerSingleObserver, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumerSingleObserver, (String)"onSuccess is null");
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        consumerSingleObserver = new ConsumerSingleObserver(consumerSingleObserver, consumer);
        this.subscribe((SingleObserver<? super T>)consumerSingleObserver);
        return consumerSingleObserver;
    }

    @SchedulerSupport(value="none")
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.requireNonNull(singleObserver, (String)"observer is null");
        singleObserver = RxJavaPlugins.onSubscribe((Single)this, singleObserver);
        ObjectHelper.requireNonNull((Object)singleObserver, (String)"The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            this.subscribeActual(singleObserver);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    protected abstract void subscribeActual(SingleObserver<? super T> var1);

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleSubscribeOn((SingleSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        this.subscribe(e);
        return e;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> takeUntil(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return this.takeUntil((Publisher)new CompletableToFlowable(completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E> Single<T> takeUntil(SingleSource<? extends E> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return this.takeUntil((Publisher<E>)new SingleToFlowable(singleSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E> Single<T> takeUntil(Publisher<E> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new SingleTakeUntil((SingleSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((SingleObserver<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.cancel();
        }
        this.subscribe((SingleObserver<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Single<T> timeout(long l, TimeUnit timeUnit) {
        return this.timeout0(l, timeUnit, Schedulers.computation(), null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.timeout0(l, timeUnit, scheduler, null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return this.timeout0(l, timeUnit, scheduler, singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Single<T> timeout(long l, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return this.timeout0(l, timeUnit, Schedulers.computation(), singleSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R to(Function<? super Single<T>, R> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"convert is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    @Deprecated
    public final Completable toCompletable() {
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromSingle((SingleSource)this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> toFlowable() {
        if (!(this instanceof FuseToFlowable)) return RxJavaPlugins.onAssembly((Flowable)new SingleToFlowable((SingleSource)this));
        return ((FuseToFlowable)this).fuseToFlowable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Future<T> toFuture() {
        return (Future)this.subscribeWith(new FutureSingleObserver());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> toMaybe() {
        if (!(this instanceof FuseToMaybe)) return RxJavaPlugins.onAssembly((Maybe)new MaybeFromSingle((SingleSource)this));
        return ((FuseToMaybe)this).fuseToMaybe();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> toObservable() {
        if (!(this instanceof FuseToObservable)) return RxJavaPlugins.onAssembly((Observable)new SingleToObservable((SingleSource)this));
        return ((FuseToObservable)this).fuseToObservable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Single<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Single)new SingleUnsubscribeOn((SingleSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Single<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return Single.zip(this, singleSource, biFunction);
    }
}
