/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.MaybeConverter
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeOnSubscribe
 *  io.reactivex.MaybeOperator
 *  io.reactivex.MaybeSource
 *  io.reactivex.MaybeTransformer
 *  io.reactivex.Notification
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleSource
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
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.observers.BlockingMultiObserver
 *  io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher
 *  io.reactivex.internal.operators.maybe.MaybeAmb
 *  io.reactivex.internal.operators.maybe.MaybeCache
 *  io.reactivex.internal.operators.maybe.MaybeCallbackObserver
 *  io.reactivex.internal.operators.maybe.MaybeConcatArray
 *  io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError
 *  io.reactivex.internal.operators.maybe.MaybeConcatIterable
 *  io.reactivex.internal.operators.maybe.MaybeContains
 *  io.reactivex.internal.operators.maybe.MaybeCount
 *  io.reactivex.internal.operators.maybe.MaybeCreate
 *  io.reactivex.internal.operators.maybe.MaybeDefer
 *  io.reactivex.internal.operators.maybe.MaybeDelay
 *  io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher
 *  io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher
 *  io.reactivex.internal.operators.maybe.MaybeDetach
 *  io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess
 *  io.reactivex.internal.operators.maybe.MaybeDoFinally
 *  io.reactivex.internal.operators.maybe.MaybeDoOnEvent
 *  io.reactivex.internal.operators.maybe.MaybeDoOnTerminate
 *  io.reactivex.internal.operators.maybe.MaybeEmpty
 *  io.reactivex.internal.operators.maybe.MaybeEqualSingle
 *  io.reactivex.internal.operators.maybe.MaybeError
 *  io.reactivex.internal.operators.maybe.MaybeErrorCallable
 *  io.reactivex.internal.operators.maybe.MaybeFilter
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapNotification
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapSingle
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement
 *  io.reactivex.internal.operators.maybe.MaybeFlatten
 *  io.reactivex.internal.operators.maybe.MaybeFromAction
 *  io.reactivex.internal.operators.maybe.MaybeFromCallable
 *  io.reactivex.internal.operators.maybe.MaybeFromCompletable
 *  io.reactivex.internal.operators.maybe.MaybeFromFuture
 *  io.reactivex.internal.operators.maybe.MaybeFromRunnable
 *  io.reactivex.internal.operators.maybe.MaybeFromSingle
 *  io.reactivex.internal.operators.maybe.MaybeHide
 *  io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable
 *  io.reactivex.internal.operators.maybe.MaybeIsEmptySingle
 *  io.reactivex.internal.operators.maybe.MaybeJust
 *  io.reactivex.internal.operators.maybe.MaybeLift
 *  io.reactivex.internal.operators.maybe.MaybeMap
 *  io.reactivex.internal.operators.maybe.MaybeMaterialize
 *  io.reactivex.internal.operators.maybe.MaybeMergeArray
 *  io.reactivex.internal.operators.maybe.MaybeNever
 *  io.reactivex.internal.operators.maybe.MaybeObserveOn
 *  io.reactivex.internal.operators.maybe.MaybeOnErrorComplete
 *  io.reactivex.internal.operators.maybe.MaybeOnErrorNext
 *  io.reactivex.internal.operators.maybe.MaybeOnErrorReturn
 *  io.reactivex.internal.operators.maybe.MaybePeek
 *  io.reactivex.internal.operators.maybe.MaybeSubscribeOn
 *  io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty
 *  io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher
 *  io.reactivex.internal.operators.maybe.MaybeTimer
 *  io.reactivex.internal.operators.maybe.MaybeToFlowable
 *  io.reactivex.internal.operators.maybe.MaybeToObservable
 *  io.reactivex.internal.operators.maybe.MaybeToPublisher
 *  io.reactivex.internal.operators.maybe.MaybeToSingle
 *  io.reactivex.internal.operators.maybe.MaybeUnsafeCreate
 *  io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn
 *  io.reactivex.internal.operators.maybe.MaybeUsing
 *  io.reactivex.internal.operators.maybe.MaybeZipArray
 *  io.reactivex.internal.operators.maybe.MaybeZipIterable
 *  io.reactivex.internal.operators.mixed.MaybeFlatMapObservable
 *  io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher
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
import io.reactivex.MaybeConverter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
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
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeContains;
import io.reactivex.internal.operators.maybe.MaybeCount;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDefer;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDetach;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.internal.operators.maybe.MaybeDoOnTerminate;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeError;
import io.reactivex.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromAction;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.maybe.MaybeHide;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeLift;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeMaterialize;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeNever;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Maybe<T>
implements MaybeSource<T> {
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> amb(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeAmb(null, iterable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> ambArray(MaybeSource<? extends T> ... maybeSourceArray) {
        if (maybeSourceArray.length == 0) {
            return Maybe.empty();
        }
        if (maybeSourceArray.length != 1) return RxJavaPlugins.onAssembly((Maybe)new MaybeAmb(maybeSourceArray, null));
        return Maybe.wrap(maybeSourceArray[0]);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        return Maybe.concatArray(maybeSource, maybeSource2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        return Maybe.concatArray(maybeSource, maybeSource2, maybeSource3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        return Maybe.concatArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Flowable)new MaybeConcatIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Maybe.concat(publisher, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapPublisher(publisher, MaybeToPublisher.instance(), n, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArray(MaybeSource<? extends T> ... maybeSourceArray) {
        ObjectHelper.requireNonNull(maybeSourceArray, (String)"sources is null");
        if (maybeSourceArray.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new MaybeConcatArray(maybeSourceArray));
        return RxJavaPlugins.onAssembly((Flowable)new MaybeToFlowable(maybeSourceArray[0]));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayDelayError(MaybeSource<? extends T> ... maybeSourceArray) {
        if (maybeSourceArray.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new MaybeConcatArrayDelayError(maybeSourceArray));
        return RxJavaPlugins.onAssembly((Flowable)new MaybeToFlowable(maybeSourceArray[0]));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEager(MaybeSource<? extends T> ... maybeSourceArray) {
        return Flowable.fromArray((Object[])maybeSourceArray).concatMapEager(MaybeToPublisher.instance());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return Flowable.fromIterable(iterable).concatMapDelayError(MaybeToPublisher.instance());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapDelayError(MaybeToPublisher.instance());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).concatMapEager(MaybeToPublisher.instance());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapEager(MaybeToPublisher.instance());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        ObjectHelper.requireNonNull(maybeOnSubscribe, (String)"onSubscribe is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeCreate(maybeOnSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> defer(Callable<? extends MaybeSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, (String)"maybeSupplier is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> empty() {
        return RxJavaPlugins.onAssembly((Maybe)MaybeEmpty.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> error(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"exception is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeError(throwable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, (String)"errorSupplier is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeErrorCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromAction(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"run is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromAction(action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, (String)"callable is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromCompletable(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"completableSource is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromCompletable(completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromFuture(future, 0L, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromFuture(future, l, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"run is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromRunnable(runnable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"singleSource is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFromSingle(singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> just(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeJust(t));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        return Maybe.mergeArray(maybeSource, maybeSource2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        return Maybe.mergeArray(maybeSource, maybeSource2, maybeSource3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        return Maybe.mergeArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Maybe.merge(Flowable.fromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Maybe.merge(publisher, Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"source is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapPublisher(publisher, MaybeToPublisher.instance(), false, n, 1));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> merge(MaybeSource<? extends MaybeSource<? extends T>> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatten(maybeSource, Functions.identity()));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArray(MaybeSource<? extends T> ... maybeSourceArray) {
        ObjectHelper.requireNonNull(maybeSourceArray, (String)"sources is null");
        if (maybeSourceArray.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new MaybeMergeArray(maybeSourceArray));
        return RxJavaPlugins.onAssembly((Flowable)new MaybeToFlowable(maybeSourceArray[0]));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArrayDelayError(MaybeSource<? extends T> ... maybeSourceArray) {
        if (maybeSourceArray.length != 0) return Flowable.fromArray((Object[])maybeSourceArray).flatMap(MaybeToPublisher.instance(), true, maybeSourceArray.length);
        return Flowable.empty();
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        return Maybe.mergeArrayDelayError(maybeSource, maybeSource2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        return Maybe.mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        return Maybe.mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).flatMap(MaybeToPublisher.instance(), true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Maybe.mergeDelayError(publisher, Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"source is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapPublisher(publisher, MaybeToPublisher.instance(), true, n, 1));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> never() {
        return RxJavaPlugins.onAssembly((Maybe)MaybeNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        return Maybe.sequenceEqual(maybeSource, maybeSource2, ObjectHelper.equalsPredicate());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(biPredicate, (String)"isEqual is null");
        return RxJavaPlugins.onAssembly((Single)new MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Maybe<Long> timer(long l, TimeUnit timeUnit) {
        return Maybe.timer(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Maybe<Long> timer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTimer(Math.max(0L, l), timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> unsafeCreate(MaybeSource<T> maybeSource) {
        if (maybeSource instanceof Maybe) throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        ObjectHelper.requireNonNull(maybeSource, (String)"onSubscribe is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeUnsafeCreate(maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Maybe<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer) {
        return Maybe.using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Maybe<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        ObjectHelper.requireNonNull(callable, (String)"resourceSupplier is null");
        ObjectHelper.requireNonNull(function, (String)"sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposer is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeUsing(callable, function, consumer, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Maybe<T> wrap(MaybeSource<T> maybeSource) {
        if (maybeSource instanceof Maybe) {
            return RxJavaPlugins.onAssembly((Maybe)((Maybe)maybeSource));
        }
        ObjectHelper.requireNonNull(maybeSource, (String)"onSubscribe is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeUnsafeCreate(maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, MaybeSource<? extends T9> maybeSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(maybeSource8, (String)"source8 is null");
        ObjectHelper.requireNonNull(maybeSource9, (String)"source9 is null");
        return Maybe.zipArray(Functions.toFunction(function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(maybeSource8, (String)"source8 is null");
        return Maybe.zipArray(Functions.toFunction(function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(maybeSource7, (String)"source7 is null");
        return Maybe.zipArray(Functions.toFunction(function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(maybeSource6, (String)"source6 is null");
        return Maybe.zipArray(Functions.toFunction(function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(maybeSource5, (String)"source5 is null");
        return Maybe.zipArray(Functions.toFunction(function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(maybeSource4, (String)"source4 is null");
        return Maybe.zipArray(Functions.toFunction(function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(maybeSource3, (String)"source3 is null");
        return Maybe.zipArray(Functions.toFunction(function3), maybeSource, maybeSource2, maybeSource3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(maybeSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"source2 is null");
        return Maybe.zipArray(Functions.toFunction(biFunction), maybeSource, maybeSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Maybe<R> zip(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeZipIterable(iterable, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Maybe<R> zipArray(Function<? super Object[], ? extends R> function, MaybeSource<? extends T> ... maybeSourceArray) {
        ObjectHelper.requireNonNull(maybeSourceArray, (String)"sources is null");
        if (maybeSourceArray.length == 0) {
            return Maybe.empty();
        }
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeZipArray(maybeSourceArray, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> ambWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return Maybe.ambArray(this, maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R as(MaybeConverter<T, ? extends R> maybeConverter) {
        return (R)((MaybeConverter)ObjectHelper.requireNonNull(maybeConverter, (String)"converter is null")).apply(this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((MaybeObserver<? super T>)blockingMultiObserver);
        return (T)blockingMultiObserver.blockingGet();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingGet(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultValue is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((MaybeObserver<? super T>)blockingMultiObserver);
        return (T)blockingMultiObserver.blockingGet(t);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> cache() {
        return RxJavaPlugins.onAssembly((Maybe)new MaybeCache((MaybeSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<U> cast(Class<? extends U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.map(Functions.castFunction(clazz));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> compose(MaybeTransformer<? super T, ? extends R> maybeTransformer) {
        return Maybe.wrap(((MaybeTransformer)ObjectHelper.requireNonNull(maybeTransformer, (String)"transformer is null")).apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> concatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatten((MaybeSource)this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return Maybe.concat(this, maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> contains(Object object) {
        ObjectHelper.requireNonNull((Object)object, (String)"item is null");
        return RxJavaPlugins.onAssembly((Single)new MaybeContains((MaybeSource)this, object));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly((Single)new MaybeCount((MaybeSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return this.switchIfEmpty(Maybe.just(t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Maybe<T> delay(long l, TimeUnit timeUnit) {
        return this.delay(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDelay((MaybeSource)this, Math.max(0L, l), timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Maybe<T> delay(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"delayIndicator is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDelayOtherPublisher((MaybeSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Maybe<T> delaySubscription(long l, TimeUnit timeUnit) {
        return this.delaySubscription(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> delaySubscription(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delaySubscription((Publisher)Flowable.timer((long)l, (TimeUnit)timeUnit, (Scheduler)scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDelaySubscriptionOtherPublisher((MaybeSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onAfterSuccess is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDoAfterSuccess((MaybeSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doAfterTerminate(Action action) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, (Action)ObjectHelper.requireNonNull((Object)action, (String)"onAfterTerminate is null"), Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doFinally(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDoFinally((MaybeSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnComplete(Action action) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), (Action)ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null"), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnDispose(Action action) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, (Action)ObjectHelper.requireNonNull((Object)action, (String)"onDispose is null")));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnError(Consumer<? super Throwable> consumer) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, Functions.emptyConsumer(), Functions.emptyConsumer(), (Consumer)ObjectHelper.requireNonNull(consumer, (String)"onError is null"), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"onEvent is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDoOnEvent((MaybeSource)this, biConsumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, (Consumer)ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null"), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnSuccess(Consumer<? super T> consumer) {
        return RxJavaPlugins.onAssembly((Maybe)new MaybePeek((MaybeSource)this, Functions.emptyConsumer(), (Consumer)ObjectHelper.requireNonNull(consumer, (String)"onSuccess is null"), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onTerminate is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDoOnTerminate((MaybeSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFilter((MaybeSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatten((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatMapBiSelector((MaybeSource)this, function, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, (String)"onSuccessMapper is null");
        ObjectHelper.requireNonNull(function2, (String)"onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, (String)"onCompleteSupplier is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatMapNotification((MaybeSource)this, function, function2, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new MaybeFlatMapCompletable((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new MaybeFlatMapObservable((MaybeSource)this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new MaybeFlatMapPublisher((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Single)new MaybeFlatMapSingle((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> flatMapSingleElement(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeFlatMapSingleElement((MaybeSource)this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new MaybeFlatMapIterableFlowable((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new MaybeFlatMapIterableObservable((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> hide() {
        return RxJavaPlugins.onAssembly((Maybe)new MaybeHide((MaybeSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable ignoreElement() {
        return RxJavaPlugins.onAssembly((Completable)new MaybeIgnoreElementCompletable((MaybeSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> isEmpty() {
        return RxJavaPlugins.onAssembly((Single)new MaybeIsEmptySingle((MaybeSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> lift(MaybeOperator<? extends R, ? super T> maybeOperator) {
        ObjectHelper.requireNonNull(maybeOperator, (String)"lift is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeLift((MaybeSource)this, maybeOperator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Maybe<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeMap((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Single)new MaybeMaterialize(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return Maybe.merge(this, maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeObserveOn((MaybeSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<U> ofType(Class<U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.filter(Functions.isInstanceOf(clazz)).cast(clazz);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorComplete() {
        return this.onErrorComplete((Predicate<Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeOnErrorComplete((MaybeSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"next is null");
        return this.onErrorResumeNext(Functions.justFunction(maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, (String)"resumeFunction is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeOnErrorNext((MaybeSource)this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, (String)"valueSupplier is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeOnErrorReturn((MaybeSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return this.onErrorReturn(Functions.justFunction(t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onExceptionResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeOnErrorNext((MaybeSource)this, Functions.justFunction(maybeSource), false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDetach((MaybeSource)this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeat() {
        return this.repeat(Long.MAX_VALUE);
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
    public final Maybe<T> retry() {
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retry(long l) {
        return this.retry(l, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retry(long l, Predicate<? super Throwable> predicate) {
        return this.toFlowable().retry(l, predicate).singleElement();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return this.toFlowable().retry(biPredicate).singleElement();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retry(Predicate<? super Throwable> predicate) {
        return this.retry(Long.MAX_VALUE, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull((Object)booleanSupplier, (String)"stop is null");
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.predicateReverseFor((BooleanSupplier)booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return this.toFlowable().retryWhen(function).singleElement();
    }

    @SchedulerSupport(value="none")
    public final Disposable subscribe() {
        return this.subscribe(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return this.subscribe(consumer, (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return this.subscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.requireNonNull(consumer, (String)"onSuccess is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        return (Disposable)this.subscribeWith(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    @SchedulerSupport(value="none")
    public final void subscribe(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.requireNonNull(maybeObserver, (String)"observer is null");
        maybeObserver = RxJavaPlugins.onSubscribe((Maybe)this, maybeObserver);
        ObjectHelper.requireNonNull((Object)maybeObserver, (String)"The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            this.subscribeActual(maybeObserver);
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

    protected abstract void subscribeActual(MaybeObserver<? super T> var1);

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeSubscribeOn((MaybeSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E extends MaybeObserver<? super T>> E subscribeWith(E e) {
        this.subscribe(e);
        return e;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> switchIfEmpty(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeSwitchIfEmpty((MaybeSource)this, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> switchIfEmpty(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Single)new MaybeSwitchIfEmptySingle((MaybeSource)this, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> takeUntil(MaybeSource<U> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTakeUntilMaybe((MaybeSource)this, maybeSource));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTakeUntilPublisher((MaybeSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((MaybeObserver<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.cancel();
        }
        this.subscribe((MaybeObserver<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Maybe<T> timeout(long l, TimeUnit timeUnit) {
        return this.timeout(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Maybe<T> timeout(long l, TimeUnit timeUnit, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"fallback is null");
        return this.timeout(l, timeUnit, Schedulers.computation(), maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.timeout(Maybe.timer(l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"fallback is null");
        return this.timeout(Maybe.timer(l, timeUnit, scheduler), maybeSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> timeout(MaybeSource<U> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"timeoutIndicator is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTimeoutMaybe((MaybeSource)this, maybeSource, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> timeout(MaybeSource<U> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.requireNonNull(maybeSource, (String)"timeoutIndicator is null");
        ObjectHelper.requireNonNull(maybeSource2, (String)"fallback is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTimeoutMaybe((MaybeSource)this, maybeSource, maybeSource2));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> timeout(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"timeoutIndicator is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTimeoutPublisher((MaybeSource)this, publisher, null));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Maybe<T> timeout(Publisher<U> publisher, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(publisher, (String)"timeoutIndicator is null");
        ObjectHelper.requireNonNull(maybeSource, (String)"fallback is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeTimeoutPublisher((MaybeSource)this, publisher, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R to(Function<? super Maybe<T>, R> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"convert is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> toFlowable() {
        if (!(this instanceof FuseToFlowable)) return RxJavaPlugins.onAssembly((Flowable)new MaybeToFlowable((MaybeSource)this));
        return ((FuseToFlowable)this).fuseToFlowable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> toObservable() {
        if (!(this instanceof FuseToObservable)) return RxJavaPlugins.onAssembly((Observable)new MaybeToObservable((MaybeSource)this));
        return ((FuseToObservable)this).fuseToObservable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> toSingle() {
        return RxJavaPlugins.onAssembly((Single)new MaybeToSingle((MaybeSource)this, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> toSingle(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultValue is null");
        return RxJavaPlugins.onAssembly((Single)new MaybeToSingle((MaybeSource)this, t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Maybe<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeUnsubscribeOn((MaybeSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Maybe<R> zipWith(MaybeSource<? extends U> maybeSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return Maybe.zip(this, maybeSource, biFunction);
    }
}
