/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.exceptions.OnErrorNotImplementedException
 *  io.reactivex.exceptions.UndeliverableException
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.schedulers.ComputationScheduler
 *  io.reactivex.internal.schedulers.IoScheduler
 *  io.reactivex.internal.schedulers.NewThreadScheduler
 *  io.reactivex.internal.schedulers.SingleScheduler
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observables.ConnectableObservable
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile boolean failNonBlockingScheduler;
    static volatile boolean lockdown;
    static volatile BooleanSupplier onBeforeBlocking;
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    static <T, U, R> R apply(BiFunction<T, U, R> object, T t, U u) {
        try {
            object = object.apply(t, u);
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    static <T, R> R apply(Function<T, R> object, T t) {
        try {
            object = object.apply(t);
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    static Scheduler applyRequireNonNull(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler)ObjectHelper.requireNonNull((Object)RxJavaPlugins.apply(function, callable), (String)"Scheduler Callable result can't be null");
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> scheduler) {
        try {
            scheduler = (Scheduler)ObjectHelper.requireNonNull((Object)scheduler.call(), (String)"Scheduler Callable result can't be null");
            return scheduler;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }

    public static Scheduler createComputationScheduler(ThreadFactory threadFactory) {
        return new ComputationScheduler((ThreadFactory)ObjectHelper.requireNonNull((Object)threadFactory, (String)"threadFactory is null"));
    }

    public static Scheduler createIoScheduler(ThreadFactory threadFactory) {
        return new IoScheduler((ThreadFactory)ObjectHelper.requireNonNull((Object)threadFactory, (String)"threadFactory is null"));
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory threadFactory) {
        return new NewThreadScheduler((ThreadFactory)ObjectHelper.requireNonNull((Object)threadFactory, (String)"threadFactory is null"));
    }

    public static Scheduler createSingleScheduler(ThreadFactory threadFactory) {
        return new SingleScheduler((ThreadFactory)ObjectHelper.requireNonNull((Object)threadFactory, (String)"threadFactory is null"));
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return errorHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return onIoHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return onObservableAssembly;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return onParallelAssembly;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return onSingleAssembly;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return onScheduleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    public static Scheduler initComputationScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, (String)"Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitComputationHandler;
        if (function != null) return RxJavaPlugins.applyRequireNonNull(function, callable);
        return RxJavaPlugins.callRequireNonNull(callable);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, (String)"Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitIoHandler;
        if (function != null) return RxJavaPlugins.applyRequireNonNull(function, callable);
        return RxJavaPlugins.callRequireNonNull(callable);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, (String)"Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitNewThreadHandler;
        if (function != null) return RxJavaPlugins.applyRequireNonNull(function, callable);
        return RxJavaPlugins.callRequireNonNull(callable);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, (String)"Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitSingleHandler;
        if (function != null) return RxJavaPlugins.applyRequireNonNull(function, callable);
        return RxJavaPlugins.callRequireNonNull(callable);
    }

    static boolean isBug(Throwable throwable) {
        if (throwable instanceof OnErrorNotImplementedException) {
            return true;
        }
        if (throwable instanceof MissingBackpressureException) {
            return true;
        }
        if (throwable instanceof IllegalStateException) {
            return true;
        }
        if (throwable instanceof NullPointerException) {
            return true;
        }
        if (throwable instanceof IllegalArgumentException) {
            return true;
        }
        if (!(throwable instanceof CompositeException)) return false;
        return true;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return failNonBlockingScheduler;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static void lockdown() {
        lockdown = true;
    }

    public static Completable onAssembly(Completable completable) {
        Function<? super Completable, ? extends Completable> function = onCompletableAssembly;
        Completable completable2 = completable;
        if (function == null) return completable2;
        completable2 = RxJavaPlugins.apply(function, completable);
        return completable2;
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = onFlowableAssembly;
        Flowable flowable2 = flowable;
        if (function == null) return flowable2;
        flowable2 = RxJavaPlugins.apply(function, flowable);
        return flowable2;
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = onMaybeAssembly;
        Maybe maybe2 = maybe;
        if (function == null) return maybe2;
        maybe2 = RxJavaPlugins.apply(function, maybe);
        return maybe2;
    }

    public static <T> Observable<T> onAssembly(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = onObservableAssembly;
        Observable observable2 = observable;
        if (function == null) return observable2;
        observable2 = RxJavaPlugins.apply(function, observable);
        return observable2;
    }

    public static <T> Single<T> onAssembly(Single<T> single) {
        Function<? super Single, ? extends Single> function = onSingleAssembly;
        Single single2 = single;
        if (function == null) return single2;
        single2 = RxJavaPlugins.apply(function, single);
        return single2;
    }

    public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = onConnectableFlowableAssembly;
        ConnectableFlowable connectableFlowable2 = connectableFlowable;
        if (function == null) return connectableFlowable2;
        connectableFlowable2 = RxJavaPlugins.apply(function, connectableFlowable);
        return connectableFlowable2;
    }

    public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = onConnectableObservableAssembly;
        ConnectableObservable connectableObservable2 = connectableObservable;
        if (function == null) return connectableObservable2;
        connectableObservable2 = RxJavaPlugins.apply(function, connectableObservable);
        return connectableObservable2;
    }

    public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> parallelFlowable) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = onParallelAssembly;
        ParallelFlowable parallelFlowable2 = parallelFlowable;
        if (function == null) return parallelFlowable2;
        parallelFlowable2 = RxJavaPlugins.apply(function, parallelFlowable);
        return parallelFlowable2;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = onBeforeBlocking;
        if (booleanSupplier == null) return false;
        try {
            boolean bl = booleanSupplier.getAsBoolean();
            return bl;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onComputationHandler;
        if (function != null) return RxJavaPlugins.apply(function, scheduler);
        return scheduler;
    }

    public static void onError(Throwable throwable) {
        Throwable throwable2;
        Consumer<? super Throwable> consumer = errorHandler;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            throwable2 = throwable;
            if (!RxJavaPlugins.isBug(throwable)) {
                throwable2 = new UndeliverableException(throwable);
            }
        }
        if (consumer != null) {
            try {
                consumer.accept((Object)throwable2);
                return;
            }
            catch (Throwable throwable3) {
                throwable3.printStackTrace();
                RxJavaPlugins.uncaught(throwable3);
            }
        }
        throwable2.printStackTrace();
        RxJavaPlugins.uncaught(throwable2);
    }

    public static Scheduler onIoScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onIoHandler;
        if (function != null) return RxJavaPlugins.apply(function, scheduler);
        return scheduler;
    }

    public static Scheduler onNewThreadScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onNewThreadHandler;
        if (function != null) return RxJavaPlugins.apply(function, scheduler);
        return scheduler;
    }

    public static Runnable onSchedule(Runnable runnable) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"run is null");
        Function<? super Runnable, ? extends Runnable> function = onScheduleHandler;
        if (function != null) return RxJavaPlugins.apply(function, runnable);
        return runnable;
    }

    public static Scheduler onSingleScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onSingleHandler;
        if (function != null) return RxJavaPlugins.apply(function, scheduler);
        return scheduler;
    }

    public static CompletableObserver onSubscribe(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = onCompletableSubscribe;
        if (biFunction == null) return completableObserver;
        return RxJavaPlugins.apply(biFunction, completable, completableObserver);
    }

    public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = onMaybeSubscribe;
        if (biFunction == null) return maybeObserver;
        return RxJavaPlugins.apply(biFunction, maybe, maybeObserver);
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = onObservableSubscribe;
        if (biFunction == null) return observer;
        return RxJavaPlugins.apply(biFunction, observable, observer);
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = onSingleSubscribe;
        if (biFunction == null) return singleObserver;
        return RxJavaPlugins.apply(biFunction, single, singleObserver);
    }

    public static <T> Subscriber<? super T> onSubscribe(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = onFlowableSubscribe;
        if (biFunction == null) return subscriber;
        return RxJavaPlugins.apply(biFunction, flowable, subscriber);
    }

    public static void reset() {
        RxJavaPlugins.setErrorHandler(null);
        RxJavaPlugins.setScheduleHandler(null);
        RxJavaPlugins.setComputationSchedulerHandler(null);
        RxJavaPlugins.setInitComputationSchedulerHandler(null);
        RxJavaPlugins.setIoSchedulerHandler(null);
        RxJavaPlugins.setInitIoSchedulerHandler(null);
        RxJavaPlugins.setSingleSchedulerHandler(null);
        RxJavaPlugins.setInitSingleSchedulerHandler(null);
        RxJavaPlugins.setNewThreadSchedulerHandler(null);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(null);
        RxJavaPlugins.setOnFlowableAssembly(null);
        RxJavaPlugins.setOnFlowableSubscribe(null);
        RxJavaPlugins.setOnObservableAssembly(null);
        RxJavaPlugins.setOnObservableSubscribe(null);
        RxJavaPlugins.setOnSingleAssembly(null);
        RxJavaPlugins.setOnSingleSubscribe(null);
        RxJavaPlugins.setOnCompletableAssembly(null);
        RxJavaPlugins.setOnCompletableSubscribe(null);
        RxJavaPlugins.setOnConnectableFlowableAssembly(null);
        RxJavaPlugins.setOnConnectableObservableAssembly(null);
        RxJavaPlugins.setOnMaybeAssembly(null);
        RxJavaPlugins.setOnMaybeSubscribe(null);
        RxJavaPlugins.setOnParallelAssembly(null);
        RxJavaPlugins.setFailOnNonBlockingScheduler(false);
        RxJavaPlugins.setOnBeforeBlocking(null);
    }

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onComputationHandler = function;
    }

    public static void setErrorHandler(Consumer<? super Throwable> consumer) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        errorHandler = consumer;
    }

    public static void setFailOnNonBlockingScheduler(boolean bl) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        failNonBlockingScheduler = bl;
    }

    public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onInitComputationHandler = function;
    }

    public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onInitIoHandler = function;
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onInitNewThreadHandler = function;
    }

    public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onInitSingleHandler = function;
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onIoHandler = function;
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onNewThreadHandler = function;
    }

    public static void setOnBeforeBlocking(BooleanSupplier booleanSupplier) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onBeforeBlocking = booleanSupplier;
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onCompletableAssembly = function;
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onCompletableSubscribe = biFunction;
    }

    public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onConnectableFlowableAssembly = function;
    }

    public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onConnectableObservableAssembly = function;
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onFlowableAssembly = function;
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onFlowableSubscribe = biFunction;
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onMaybeAssembly = function;
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onMaybeSubscribe = biFunction;
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onObservableAssembly = function;
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onObservableSubscribe = biFunction;
    }

    public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onParallelAssembly = function;
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onSingleAssembly = function;
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onSingleSubscribe = biFunction;
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onScheduleHandler = function;
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (lockdown) throw new IllegalStateException("Plugins can't be changed anymore");
        onSingleHandler = function;
    }

    static void uncaught(Throwable throwable) {
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
    }

    static void unlock() {
        lockdown = false;
    }
}
