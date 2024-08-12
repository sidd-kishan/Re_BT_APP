/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelCollect$ParallelCollectSubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class ParallelCollect<T, C>
extends ParallelFlowable<C> {
    final BiConsumer<? super C, ? super T> collector;
    final Callable<? extends C> initialCollection;
    final ParallelFlowable<? extends T> source;

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Callable<? extends C> callable, BiConsumer<? super C, ? super T> biConsumer) {
        this.source = parallelFlowable;
        this.initialCollection = callable;
        this.collector = biConsumer;
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

    public void subscribe(Subscriber<? super C>[] subscriberArray) {
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
                object = ObjectHelper.requireNonNull(this.initialCollection.call(), (String)"The initialSupplier returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.reportError(subscriberArray, throwable);
                return;
            }
            subscriberArray2[n2] = new ParallelCollectSubscriber(subscriberArray[n2], object, this.collector);
            ++n2;
        }
    }
}
