/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Observable
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleInternalHelper$NoSuchElementCallable
 *  io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowable
 *  io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowableIterable
 *  io.reactivex.internal.operators.single.SingleInternalHelper$ToObservable
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper {
    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> emptyThrower() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new ToFlowableIterable(iterable);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return ToFlowable.INSTANCE;
    }

    public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> toObservable() {
        return ToObservable.INSTANCE;
    }
}
