/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.LongConsumer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelCollect
 *  io.reactivex.internal.operators.parallel.ParallelConcatMap
 *  io.reactivex.internal.operators.parallel.ParallelDoOnNextTry
 *  io.reactivex.internal.operators.parallel.ParallelFilter
 *  io.reactivex.internal.operators.parallel.ParallelFilterTry
 *  io.reactivex.internal.operators.parallel.ParallelFlatMap
 *  io.reactivex.internal.operators.parallel.ParallelFromArray
 *  io.reactivex.internal.operators.parallel.ParallelFromPublisher
 *  io.reactivex.internal.operators.parallel.ParallelJoin
 *  io.reactivex.internal.operators.parallel.ParallelMap
 *  io.reactivex.internal.operators.parallel.ParallelMapTry
 *  io.reactivex.internal.operators.parallel.ParallelPeek
 *  io.reactivex.internal.operators.parallel.ParallelReduce
 *  io.reactivex.internal.operators.parallel.ParallelReduceFull
 *  io.reactivex.internal.operators.parallel.ParallelRunOn
 *  io.reactivex.internal.operators.parallel.ParallelSortedJoin
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.ListAddBiConsumer
 *  io.reactivex.internal.util.MergerBiFunction
 *  io.reactivex.internal.util.SorterFunction
 *  io.reactivex.parallel.ParallelFailureHandling
 *  io.reactivex.parallel.ParallelFlowableConverter
 *  io.reactivex.parallel.ParallelTransformer
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.parallel;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowableConverter;
import io.reactivex.parallel.ParallelTransformer;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class ParallelFlowable<T> {
    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> publisher) {
        return ParallelFlowable.from(publisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> publisher, int n) {
        return ParallelFlowable.from(publisher, n, Flowable.bufferSize());
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(Publisher<? extends T> publisher, int n, int n2) {
        ObjectHelper.requireNonNull(publisher, (String)"source");
        ObjectHelper.verifyPositive((int)n, (String)"parallelism");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFromPublisher(publisher, n, n2));
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> fromArray(Publisher<T> ... publisherArray) {
        if (publisherArray.length == 0) throw new IllegalArgumentException("Zero publishers not supported");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFromArray(publisherArray));
    }

    @CheckReturnValue
    public final <R> R as(ParallelFlowableConverter<T, R> parallelFlowableConverter) {
        return (R)((ParallelFlowableConverter)ObjectHelper.requireNonNull(parallelFlowableConverter, (String)"converter is null")).apply(this);
    }

    @CheckReturnValue
    public final <C> ParallelFlowable<C> collect(Callable<? extends C> callable, BiConsumer<? super C, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, (String)"collectionSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, (String)"collector is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelCollect(this, callable, biConsumer));
    }

    @CheckReturnValue
    public final <U> ParallelFlowable<U> compose(ParallelTransformer<T, U> parallelTransformer) {
        return RxJavaPlugins.onAssembly((ParallelFlowable)((ParallelTransformer)ObjectHelper.requireNonNull(parallelTransformer, (String)"composer is null")).apply(this));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.concatMap(function, 2);
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelConcatMap(this, function, n, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelConcatMap(this, function, n, errorMode));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl) {
        return this.concatMapDelayError(function, 2, bl);
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onAfterNext is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doAfterTerminated(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onAfterTerminate is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnCancel(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onCancel is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnComplete(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnError(Consumer<Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), consumer, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, consumer, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(biFunction, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelDoOnNextTry(this, consumer, biFunction));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnNext(Consumer<? super T> consumer, ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull((Object)parallelFailureHandling, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelDoOnNextTry(this, consumer, (BiFunction)parallelFailureHandling));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnRequest(LongConsumer longConsumer) {
        ObjectHelper.requireNonNull((Object)longConsumer, (String)"onRequest is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilter(this, predicate));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate");
        ObjectHelper.requireNonNull(biFunction, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilterTry(this, predicate, biFunction));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(Predicate<? super T> predicate, ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate");
        ObjectHelper.requireNonNull((Object)parallelFailureHandling, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFilterTry(this, predicate, (BiFunction)parallelFailureHandling));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.flatMap(function, false, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl) {
        return this.flatMap(function, bl, Integer.MAX_VALUE, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl, int n) {
        return this.flatMap(function, bl, n, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelFlatMap(this, function, bl, n, n2));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMap(this, function));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        ObjectHelper.requireNonNull(function, (String)"mapper");
        ObjectHelper.requireNonNull(biFunction, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMapTry(this, function, biFunction));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> map(Function<? super T, ? extends R> function, ParallelFailureHandling parallelFailureHandling) {
        ObjectHelper.requireNonNull(function, (String)"mapper");
        ObjectHelper.requireNonNull((Object)parallelFailureHandling, (String)"errorHandler is null");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelMapTry(this, function, (BiFunction)parallelFailureHandling));
    }

    public abstract int parallelism();

    @CheckReturnValue
    public final Flowable<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"reducer");
        return RxJavaPlugins.onAssembly((Flowable)new ParallelReduceFull(this, biFunction));
    }

    @CheckReturnValue
    public final <R> ParallelFlowable<R> reduce(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, (String)"initialSupplier");
        ObjectHelper.requireNonNull(biFunction, (String)"reducer");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelReduce(this, callable, biFunction));
    }

    @CheckReturnValue
    public final ParallelFlowable<T> runOn(Scheduler scheduler) {
        return this.runOn(scheduler, Flowable.bufferSize());
    }

    @CheckReturnValue
    public final ParallelFlowable<T> runOn(Scheduler scheduler, int n) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((ParallelFlowable)new ParallelRunOn(this, scheduler, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sequential() {
        return this.sequential(Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sequential(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new ParallelJoin(this, n, false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sequentialDelayError() {
        return this.sequentialDelayError(Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sequentialDelayError(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new ParallelJoin(this, n, true));
    }

    @CheckReturnValue
    public final Flowable<T> sorted(Comparator<? super T> comparator) {
        return this.sorted(comparator, 16);
    }

    @CheckReturnValue
    public final Flowable<T> sorted(Comparator<? super T> comparator, int n) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        ObjectHelper.verifyPositive((int)n, (String)"capacityHint");
        return RxJavaPlugins.onAssembly((Flowable)new ParallelSortedJoin(this.reduce(Functions.createArrayList((int)(n / this.parallelism() + 1)), ListAddBiConsumer.instance()).map((Function)new SorterFunction(comparator)), comparator));
    }

    public abstract void subscribe(Subscriber<? super T>[] var1);

    @CheckReturnValue
    public final <U> U to(Function<? super ParallelFlowable<T>, U> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"converter is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (U)object;
    }

    @CheckReturnValue
    public final Flowable<List<T>> toSortedList(Comparator<? super T> comparator) {
        return this.toSortedList(comparator, 16);
    }

    @CheckReturnValue
    public final Flowable<List<T>> toSortedList(Comparator<? super T> comparator, int n) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        ObjectHelper.verifyPositive((int)n, (String)"capacityHint");
        return RxJavaPlugins.onAssembly(this.reduce(Functions.createArrayList((int)(n / this.parallelism() + 1)), ListAddBiConsumer.instance()).map((Function)new SorterFunction(comparator)).reduce((BiFunction)new MergerBiFunction(comparator)));
    }

    protected final boolean validate(Subscriber<?>[] subscriberArray) {
        int n = this.parallelism();
        if (subscriberArray.length == n) return true;
        Serializable serializable = new StringBuilder();
        serializable.append("parallelism = ");
        serializable.append(n);
        serializable.append(", subscribers = ");
        serializable.append(subscriberArray.length);
        serializable = new IllegalArgumentException(serializable.toString());
        int n2 = subscriberArray.length;
        n = 0;
        while (n < n2) {
            EmptySubscription.error((Throwable)serializable, subscriberArray[n]);
            ++n;
        }
        return false;
    }
}
