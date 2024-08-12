/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle$ReduceSeedObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableReduceWithSingle<T, R>
extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final Publisher<T> source;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = publisher;
        this.seedSupplier = callable;
        this.reducer = biFunction;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.seedSupplier.call(), (String)"The seedSupplier returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptyDisposable.error((Throwable)throwable, singleObserver);
            return;
        }
        this.source.subscribe((Subscriber)new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.reducer, object));
    }
}
