/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelReduce$ParallelReduceSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class ParallelReduce<T, R>
extends ParallelFlowable<R> {
    final Callable<R> initialSupplier;
    final BiFunction<R, ? super T, R> reducer;
    final ParallelFlowable<? extends T> source;

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = parallelFlowable;
        this.initialSupplier = callable;
        this.reducer = biFunction;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    void reportError(Subscriber<?>[] subscriberArray, Throwable throwable) {
        int n = subscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            EmptySubscription.error((Throwable)throwable, subscriberArray[n2]);
            ++n2;
        }
    }

    public void subscribe(Subscriber<? super R>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        int n = subscriberArray.length;
        Subscriber[] subscriberArray2 = new Subscriber[n];
        int n2 = 0;
        while (true) {
            Object object;
            if (n2 >= n) {
                this.source.subscribe(subscriberArray2);
                return;
            }
            try {
                object = ObjectHelper.requireNonNull(this.initialSupplier.call(), (String)"The initialSupplier returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.reportError(subscriberArray, throwable);
                return;
            }
            subscriberArray2[n2] = new ParallelReduceSubscriber(subscriberArray[n2], object, this.reducer);
            ++n2;
        }
    }
}
