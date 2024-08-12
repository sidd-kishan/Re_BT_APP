/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$BufferedReplayCallable
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$BufferedTimedReplay
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$FlatMapIntoIterable
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$FlatMapWithCombinerOuter
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$ItemDelayFunction
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$ReplayCallable
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$ReplayFunction
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$SimpleBiGenerator
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$SimpleGenerator
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$SubscriberOnComplete
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$SubscriberOnError
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$SubscriberOnNext
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$TimedReplay
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$ZipIterableFunction
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableInternalHelper {
    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable) {
        return new ReplayCallable(flowable);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int n) {
        return new BufferedReplayCallable(flowable, n);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(flowable, n, l, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(flowable, l, timeUnit, scheduler);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }
}
