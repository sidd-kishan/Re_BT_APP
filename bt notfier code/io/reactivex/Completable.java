/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableConverter
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableOnSubscribe
 *  io.reactivex.CompletableOperator
 *  io.reactivex.CompletableSource
 *  io.reactivex.CompletableTransformer
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeSource
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
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.FuseToFlowable
 *  io.reactivex.internal.fuseable.FuseToMaybe
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.observers.BlockingMultiObserver
 *  io.reactivex.internal.observers.CallbackCompletableObserver
 *  io.reactivex.internal.observers.EmptyCompletableObserver
 *  io.reactivex.internal.operators.completable.CompletableAmb
 *  io.reactivex.internal.operators.completable.CompletableAndThenCompletable
 *  io.reactivex.internal.operators.completable.CompletableCache
 *  io.reactivex.internal.operators.completable.CompletableConcat
 *  io.reactivex.internal.operators.completable.CompletableConcatArray
 *  io.reactivex.internal.operators.completable.CompletableConcatIterable
 *  io.reactivex.internal.operators.completable.CompletableCreate
 *  io.reactivex.internal.operators.completable.CompletableDefer
 *  io.reactivex.internal.operators.completable.CompletableDelay
 *  io.reactivex.internal.operators.completable.CompletableDetach
 *  io.reactivex.internal.operators.completable.CompletableDisposeOn
 *  io.reactivex.internal.operators.completable.CompletableDoFinally
 *  io.reactivex.internal.operators.completable.CompletableDoOnEvent
 *  io.reactivex.internal.operators.completable.CompletableEmpty
 *  io.reactivex.internal.operators.completable.CompletableError
 *  io.reactivex.internal.operators.completable.CompletableErrorSupplier
 *  io.reactivex.internal.operators.completable.CompletableFromAction
 *  io.reactivex.internal.operators.completable.CompletableFromCallable
 *  io.reactivex.internal.operators.completable.CompletableFromObservable
 *  io.reactivex.internal.operators.completable.CompletableFromPublisher
 *  io.reactivex.internal.operators.completable.CompletableFromRunnable
 *  io.reactivex.internal.operators.completable.CompletableFromSingle
 *  io.reactivex.internal.operators.completable.CompletableFromUnsafeSource
 *  io.reactivex.internal.operators.completable.CompletableHide
 *  io.reactivex.internal.operators.completable.CompletableLift
 *  io.reactivex.internal.operators.completable.CompletableMaterialize
 *  io.reactivex.internal.operators.completable.CompletableMerge
 *  io.reactivex.internal.operators.completable.CompletableMergeArray
 *  io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray
 *  io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable
 *  io.reactivex.internal.operators.completable.CompletableMergeIterable
 *  io.reactivex.internal.operators.completable.CompletableNever
 *  io.reactivex.internal.operators.completable.CompletableObserveOn
 *  io.reactivex.internal.operators.completable.CompletableOnErrorComplete
 *  io.reactivex.internal.operators.completable.CompletablePeek
 *  io.reactivex.internal.operators.completable.CompletableResumeNext
 *  io.reactivex.internal.operators.completable.CompletableSubscribeOn
 *  io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable
 *  io.reactivex.internal.operators.completable.CompletableTimeout
 *  io.reactivex.internal.operators.completable.CompletableTimer
 *  io.reactivex.internal.operators.completable.CompletableToFlowable
 *  io.reactivex.internal.operators.completable.CompletableToObservable
 *  io.reactivex.internal.operators.completable.CompletableToSingle
 *  io.reactivex.internal.operators.completable.CompletableUsing
 *  io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable
 *  io.reactivex.internal.operators.maybe.MaybeFromCompletable
 *  io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable
 *  io.reactivex.internal.operators.mixed.CompletableAndThenObservable
 *  io.reactivex.internal.operators.mixed.CompletableAndThenPublisher
 *  io.reactivex.internal.operators.single.SingleDelayWithCompletable
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observers.TestObserver
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 *  org.reactivestreams.Publisher
 */
package io.reactivex;

import io.reactivex.CompletableConverter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
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
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMaterialize;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Completable
implements CompletableSource {
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable amb(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableAmb(null, iterable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable ambArray(CompletableSource ... completableSourceArray) {
        ObjectHelper.requireNonNull((Object)completableSourceArray, (String)"sources is null");
        if (completableSourceArray.length == 0) {
            return Completable.complete();
        }
        if (completableSourceArray.length != 1) return RxJavaPlugins.onAssembly((Completable)new CompletableAmb(completableSourceArray, null));
        return Completable.wrap(completableSourceArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable complete() {
        return RxJavaPlugins.onAssembly((Completable)CompletableEmpty.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable concat(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableConcatIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable concat(Publisher<? extends CompletableSource> publisher) {
        return Completable.concat(publisher, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable concat(Publisher<? extends CompletableSource> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Completable)new CompletableConcat(publisher, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable concatArray(CompletableSource ... completableSourceArray) {
        ObjectHelper.requireNonNull((Object)completableSourceArray, (String)"sources is null");
        if (completableSourceArray.length == 0) {
            return Completable.complete();
        }
        if (completableSourceArray.length != 1) return RxJavaPlugins.onAssembly((Completable)new CompletableConcatArray(completableSourceArray));
        return Completable.wrap(completableSourceArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.requireNonNull((Object)completableOnSubscribe, (String)"source is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableCreate(completableOnSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable defer(Callable<? extends CompletableSource> callable) {
        ObjectHelper.requireNonNull(callable, (String)"completableSupplier");
        return RxJavaPlugins.onAssembly((Completable)new CompletableDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.requireNonNull((Object)action2, (String)"onTerminate is null");
        ObjectHelper.requireNonNull((Object)action3, (String)"onAfterTerminate is null");
        ObjectHelper.requireNonNull((Object)action4, (String)"onDispose is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletablePeek((CompletableSource)this, consumer, consumer2, action, action2, action3, action4));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable error(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"error is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableError(throwable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, (String)"errorSupplier is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableErrorSupplier(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable fromAction(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"run is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromAction(action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable fromCallable(Callable<?> callable) {
        ObjectHelper.requireNonNull(callable, (String)"callable is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return Completable.fromAction(Functions.futureAction(future));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Completable fromMaybe(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"maybe is null");
        return RxJavaPlugins.onAssembly((Completable)new MaybeIgnoreElementCompletable(maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Completable fromObservable(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"observable is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromObservable(observableSource));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"publisher is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromPublisher(publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"run is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromRunnable(runnable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Completable fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"single is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromSingle(singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable merge(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableMergeIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable merge(Publisher<? extends CompletableSource> publisher) {
        return Completable.merge0(publisher, Integer.MAX_VALUE, false);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable merge(Publisher<? extends CompletableSource> publisher, int n) {
        return Completable.merge0(publisher, n, false);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    private static Completable merge0(Publisher<? extends CompletableSource> publisher, int n, boolean bl) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable)new CompletableMerge(publisher, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable mergeArray(CompletableSource ... completableSourceArray) {
        ObjectHelper.requireNonNull((Object)completableSourceArray, (String)"sources is null");
        if (completableSourceArray.length == 0) {
            return Completable.complete();
        }
        if (completableSourceArray.length != 1) return RxJavaPlugins.onAssembly((Completable)new CompletableMergeArray(completableSourceArray));
        return Completable.wrap(completableSourceArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable mergeArrayDelayError(CompletableSource ... completableSourceArray) {
        ObjectHelper.requireNonNull((Object)completableSourceArray, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableMergeDelayErrorArray(completableSourceArray));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableMergeDelayErrorIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        return Completable.merge0(publisher, Integer.MAX_VALUE, true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher, int n) {
        return Completable.merge0(publisher, n, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable never() {
        return RxJavaPlugins.onAssembly((Completable)CompletableNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    private Completable timeout0(long l, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableTimeout((CompletableSource)this, l, timeUnit, scheduler, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Completable timer(long l, TimeUnit timeUnit) {
        return Completable.timer(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Completable timer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableTimer(l, timeUnit, scheduler));
    }

    private static NullPointerException toNpe(Throwable throwable) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(throwable);
        return nullPointerException;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable unsafeCreate(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"source is null");
        if (completableSource instanceof Completable) throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        return RxJavaPlugins.onAssembly((Completable)new CompletableFromUnsafeSource(completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        return Completable.using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean bl) {
        ObjectHelper.requireNonNull(callable, (String)"resourceSupplier is null");
        ObjectHelper.requireNonNull(function, (String)"completableFunction is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposer is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableUsing(callable, function, consumer, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Completable wrap(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"source is null");
        if (!(completableSource instanceof Completable)) return RxJavaPlugins.onAssembly((Completable)new CompletableFromUnsafeSource(completableSource));
        return RxJavaPlugins.onAssembly((Completable)((Completable)completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable ambWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return Completable.ambArray(this, completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable andThen(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableAndThenCompletable((CompletableSource)this, completableSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Flowable<T> andThen(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"next is null");
        return RxJavaPlugins.onAssembly((Flowable)new CompletableAndThenPublisher((CompletableSource)this, publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Maybe<T> andThen(MaybeSource<T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Maybe)new MaybeDelayWithCompletable(maybeSource, (CompletableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Observable)new CompletableAndThenObservable((CompletableSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Single<T> andThen(SingleSource<T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Single)new SingleDelayWithCompletable(singleSource, (CompletableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R as(CompletableConverter<? extends R> completableConverter) {
        return (R)((CompletableConverter)ObjectHelper.requireNonNull(completableConverter, (String)"converter is null")).apply(this);
    }

    @SchedulerSupport(value="none")
    public final void blockingAwait() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((CompletableObserver)blockingMultiObserver);
        blockingMultiObserver.blockingGet();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final boolean blockingAwait(long l, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((CompletableObserver)blockingMultiObserver);
        return blockingMultiObserver.blockingAwait(l, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Throwable blockingGet() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((CompletableObserver)blockingMultiObserver);
        return blockingMultiObserver.blockingGetError();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Throwable blockingGet(long l, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        this.subscribe((CompletableObserver)blockingMultiObserver);
        return blockingMultiObserver.blockingGetError(l, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable cache() {
        return RxJavaPlugins.onAssembly((Completable)new CompletableCache((CompletableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable compose(CompletableTransformer completableTransformer) {
        return Completable.wrap(((CompletableTransformer)ObjectHelper.requireNonNull((Object)completableTransformer, (String)"transformer is null")).apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableAndThenCompletable((CompletableSource)this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Completable delay(long l, TimeUnit timeUnit) {
        return this.delay(l, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable delay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delay(l, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable delay(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableDelay((CompletableSource)this, l, timeUnit, scheduler, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Completable delaySubscription(long l, TimeUnit timeUnit) {
        return this.delaySubscription(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable delaySubscription(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return Completable.timer(l, timeUnit, scheduler).andThen(this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doAfterTerminate(Action action) {
        return this.doOnLifecycle((Consumer<? super Disposable>)Functions.emptyConsumer(), (Consumer<? super Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doFinally(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableDoFinally((CompletableSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnComplete(Action action) {
        return this.doOnLifecycle((Consumer<? super Disposable>)Functions.emptyConsumer(), (Consumer<? super Throwable>)Functions.emptyConsumer(), action, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnDispose(Action action) {
        return this.doOnLifecycle((Consumer<? super Disposable>)Functions.emptyConsumer(), (Consumer<? super Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, action);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnError(Consumer<? super Throwable> consumer) {
        return this.doOnLifecycle((Consumer<? super Disposable>)Functions.emptyConsumer(), consumer, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnEvent(Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onEvent is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableDoOnEvent((CompletableSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnSubscribe(Consumer<? super Disposable> consumer) {
        return this.doOnLifecycle(consumer, (Consumer<? super Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable doOnTerminate(Action action) {
        return this.doOnLifecycle((Consumer<? super Disposable>)Functions.emptyConsumer(), (Consumer<? super Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, action, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable hide() {
        return RxJavaPlugins.onAssembly((Completable)new CompletableHide((CompletableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable lift(CompletableOperator completableOperator) {
        ObjectHelper.requireNonNull((Object)completableOperator, (String)"onLift is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableLift((CompletableSource)this, completableOperator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Single<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Single)new CompletableMaterialize(this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable mergeWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return Completable.mergeArray(this, completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableObserveOn((CompletableSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable onErrorComplete() {
        return this.onErrorComplete((Predicate<? super Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableOnErrorComplete((CompletableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"errorMapper is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableResumeNext((CompletableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Completable)new CompletableDetach((CompletableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable repeat() {
        return Completable.fromPublisher(this.toFlowable().repeat());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable repeat(long l) {
        return Completable.fromPublisher(this.toFlowable().repeat(l));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable repeatUntil(BooleanSupplier booleanSupplier) {
        return Completable.fromPublisher(this.toFlowable().repeatUntil(booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return Completable.fromPublisher(this.toFlowable().repeatWhen(function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retry() {
        return Completable.fromPublisher(this.toFlowable().retry());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retry(long l) {
        return Completable.fromPublisher(this.toFlowable().retry(l));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retry(long l, Predicate<? super Throwable> predicate) {
        return Completable.fromPublisher(this.toFlowable().retry(l, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return Completable.fromPublisher(this.toFlowable().retry(biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retry(Predicate<? super Throwable> predicate) {
        return Completable.fromPublisher(this.toFlowable().retry(predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return Completable.fromPublisher(this.toFlowable().retryWhen(function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable startWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return Completable.concatArray(completableSource, this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Flowable<T> startWith(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return this.toFlowable().startWith(publisher);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Observable<T> startWith(Observable<T> observable) {
        ObjectHelper.requireNonNull(observable, (String)"other is null");
        return observable.concatWith(this.toObservable());
    }

    @SchedulerSupport(value="none")
    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        this.subscribe((CompletableObserver)emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        action = new CallbackCompletableObserver(action);
        this.subscribe((CompletableObserver)action);
        return action;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        action = new CallbackCompletableObserver(consumer, action);
        this.subscribe((CompletableObserver)action);
        return action;
    }

    @SchedulerSupport(value="none")
    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.requireNonNull((Object)completableObserver, (String)"observer is null");
        try {
            completableObserver = RxJavaPlugins.onSubscribe((Completable)this, (CompletableObserver)completableObserver);
            ObjectHelper.requireNonNull((Object)completableObserver, (String)"The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            this.subscribeActual(completableObserver);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
            throw Completable.toNpe(throwable);
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    protected abstract void subscribeActual(CompletableObserver var1);

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableSubscribeOn((CompletableSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E extends CompletableObserver> E subscribeWith(E e) {
        this.subscribe(e);
        return e;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable takeUntil(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableTakeUntilCompletable(this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<Void> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((CompletableObserver)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<Void> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.cancel();
        }
        this.subscribe((CompletableObserver)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Completable timeout(long l, TimeUnit timeUnit) {
        return this.timeout0(l, timeUnit, Schedulers.computation(), null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Completable timeout(long l, TimeUnit timeUnit, CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return this.timeout0(l, timeUnit, Schedulers.computation(), completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable timeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.timeout0(l, timeUnit, scheduler, null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable timeout(long l, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return this.timeout0(l, timeUnit, scheduler, completableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> U to(Function<? super Completable, U> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"converter is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (U)object;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Flowable<T> toFlowable() {
        if (!(this instanceof FuseToFlowable)) return RxJavaPlugins.onAssembly((Flowable)new CompletableToFlowable((CompletableSource)this));
        return ((FuseToFlowable)this).fuseToFlowable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Maybe<T> toMaybe() {
        if (!(this instanceof FuseToMaybe)) return RxJavaPlugins.onAssembly((Maybe)new MaybeFromCompletable((CompletableSource)this));
        return ((FuseToMaybe)this).fuseToMaybe();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Observable<T> toObservable() {
        if (!(this instanceof FuseToObservable)) return RxJavaPlugins.onAssembly((Observable)new CompletableToObservable((CompletableSource)this));
        return ((FuseToObservable)this).fuseToObservable();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Single<T> toSingle(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, (String)"completionValueSupplier is null");
        return RxJavaPlugins.onAssembly((Single)new CompletableToSingle((CompletableSource)this, callable, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T> Single<T> toSingleDefault(T t) {
        ObjectHelper.requireNonNull(t, (String)"completionValue is null");
        return RxJavaPlugins.onAssembly((Single)new CompletableToSingle((CompletableSource)this, null, t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Completable unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Completable)new CompletableDisposeOn((CompletableSource)this, scheduler));
    }
}
