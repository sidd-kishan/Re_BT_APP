/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.Scheduler
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
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
 *  io.reactivex.functions.LongConsumer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions$ActionConsumer
 *  io.reactivex.internal.functions.Functions$Array2Func
 *  io.reactivex.internal.functions.Functions$Array3Func
 *  io.reactivex.internal.functions.Functions$Array4Func
 *  io.reactivex.internal.functions.Functions$Array5Func
 *  io.reactivex.internal.functions.Functions$Array6Func
 *  io.reactivex.internal.functions.Functions$Array7Func
 *  io.reactivex.internal.functions.Functions$Array8Func
 *  io.reactivex.internal.functions.Functions$Array9Func
 *  io.reactivex.internal.functions.Functions$ArrayListCapacityCallable
 *  io.reactivex.internal.functions.Functions$BooleanSupplierPredicateReverse
 *  io.reactivex.internal.functions.Functions$BoundedConsumer
 *  io.reactivex.internal.functions.Functions$CastToClass
 *  io.reactivex.internal.functions.Functions$ClassFilter
 *  io.reactivex.internal.functions.Functions$EmptyAction
 *  io.reactivex.internal.functions.Functions$EmptyConsumer
 *  io.reactivex.internal.functions.Functions$EmptyLongConsumer
 *  io.reactivex.internal.functions.Functions$EmptyRunnable
 *  io.reactivex.internal.functions.Functions$EqualsPredicate
 *  io.reactivex.internal.functions.Functions$ErrorConsumer
 *  io.reactivex.internal.functions.Functions$FalsePredicate
 *  io.reactivex.internal.functions.Functions$FutureAction
 *  io.reactivex.internal.functions.Functions$HashSetCallable
 *  io.reactivex.internal.functions.Functions$Identity
 *  io.reactivex.internal.functions.Functions$JustValue
 *  io.reactivex.internal.functions.Functions$ListSorter
 *  io.reactivex.internal.functions.Functions$MaxRequestSubscription
 *  io.reactivex.internal.functions.Functions$NaturalComparator
 *  io.reactivex.internal.functions.Functions$NaturalObjectComparator
 *  io.reactivex.internal.functions.Functions$NotificationOnComplete
 *  io.reactivex.internal.functions.Functions$NotificationOnError
 *  io.reactivex.internal.functions.Functions$NotificationOnNext
 *  io.reactivex.internal.functions.Functions$NullCallable
 *  io.reactivex.internal.functions.Functions$OnErrorMissingConsumer
 *  io.reactivex.internal.functions.Functions$TimestampFunction
 *  io.reactivex.internal.functions.Functions$ToMapKeySelector
 *  io.reactivex.internal.functions.Functions$ToMapKeyValueSelector
 *  io.reactivex.internal.functions.Functions$ToMultimapKeyValueSelector
 *  io.reactivex.internal.functions.Functions$TruePredicate
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.schedulers.Timed
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

public final class Functions {
    static final Predicate<Object> ALWAYS_FALSE;
    static final Predicate<Object> ALWAYS_TRUE;
    public static final Action EMPTY_ACTION;
    static final Consumer<Object> EMPTY_CONSUMER;
    public static final LongConsumer EMPTY_LONG_CONSUMER;
    public static final Runnable EMPTY_RUNNABLE;
    public static final Consumer<Throwable> ERROR_CONSUMER;
    static final Function<Object, Object> IDENTITY;
    static final Comparator<Object> NATURAL_COMPARATOR;
    static final Callable<Object> NULL_SUPPLIER;
    public static final Consumer<Throwable> ON_ERROR_MISSING;
    public static final Consumer<Subscription> REQUEST_MAX;

    static {
        IDENTITY = new Identity();
        EMPTY_RUNNABLE = new EmptyRunnable();
        EMPTY_ACTION = new EmptyAction();
        EMPTY_CONSUMER = new EmptyConsumer();
        ERROR_CONSUMER = new ErrorConsumer();
        ON_ERROR_MISSING = new OnErrorMissingConsumer();
        EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
        ALWAYS_TRUE = new TruePredicate();
        ALWAYS_FALSE = new FalsePredicate();
        NULL_SUPPLIER = new NullCallable();
        NATURAL_COMPARATOR = new NaturalObjectComparator();
        REQUEST_MAX = new MaxRequestSubscription();
    }

    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new ActionConsumer(action);
    }

    public static <T> Predicate<T> alwaysFalse() {
        return ALWAYS_FALSE;
    }

    public static <T> Predicate<T> alwaysTrue() {
        return ALWAYS_TRUE;
    }

    public static <T> Consumer<T> boundedConsumer(int n) {
        return new BoundedConsumer(n);
    }

    public static <T, U> Function<T, U> castFunction(Class<U> clazz) {
        return new CastToClass(clazz);
    }

    public static <T> Callable<List<T>> createArrayList(int n) {
        return new ArrayListCapacityCallable(n);
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return EMPTY_CONSUMER;
    }

    public static <T> Predicate<T> equalsWith(T t) {
        return new EqualsPredicate(t);
    }

    public static Action futureAction(Future<?> future) {
        return new FutureAction(future);
    }

    public static <T> Function<T, T> identity() {
        return IDENTITY;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> clazz) {
        return new ClassFilter(clazz);
    }

    public static <T> Callable<T> justCallable(T t) {
        return new JustValue(t);
    }

    public static <T, U> Function<T, U> justFunction(U u) {
        return new JustValue(u);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> naturalOrder() {
        return NATURAL_COMPARATOR;
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnComplete(consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnError(consumer);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new NotificationOnNext(consumer);
    }

    public static <T> Callable<T> nullSupplier() {
        return NULL_SUPPLIER;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new BooleanSupplierPredicateReverse(booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new TimestampFunction(timeUnit, scheduler);
    }

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, (String)"f is null");
        return new Array3Func(function3);
    }

    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(Function4<T1, T2, T3, T4, R> function4) {
        ObjectHelper.requireNonNull(function4, (String)"f is null");
        return new Array4Func(function4);
    }

    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(Function5<T1, T2, T3, T4, T5, R> function5) {
        ObjectHelper.requireNonNull(function5, (String)"f is null");
        return new Array5Func(function5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        ObjectHelper.requireNonNull(function6, (String)"f is null");
        return new Array6Func(function6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        ObjectHelper.requireNonNull(function7, (String)"f is null");
        return new Array7Func(function7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        ObjectHelper.requireNonNull(function8, (String)"f is null");
        return new Array8Func(function8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        ObjectHelper.requireNonNull(function9, (String)"f is null");
        return new Array9Func(function9);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new ToMapKeySelector(function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new ToMapKeyValueSelector(function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new ToMultimapKeyValueSelector(function3, function2, function);
    }
}
