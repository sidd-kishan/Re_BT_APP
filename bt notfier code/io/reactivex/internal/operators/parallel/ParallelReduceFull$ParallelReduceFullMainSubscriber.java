/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullInnerSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

static final class ParallelReduceFull.ParallelReduceFullMainSubscriber<T>
extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull.SlotPair<T>> current = new AtomicReference();
    final AtomicReference<Throwable> error;
    final BiFunction<T, T, T> reducer;
    final AtomicInteger remaining = new AtomicInteger();
    final ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>[] subscribers;

    ParallelReduceFull.ParallelReduceFullMainSubscriber(Subscriber<? super T> parallelReduceFullInnerSubscriberArray, int n, BiFunction<T, T, T> biFunction) {
        super(parallelReduceFullInnerSubscriberArray);
        this.error = new AtomicReference();
        parallelReduceFullInnerSubscriberArray = new ParallelReduceFull.ParallelReduceFullInnerSubscriber[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.subscribers = parallelReduceFullInnerSubscriberArray;
                this.reducer = biFunction;
                this.remaining.lazySet(n);
                return;
            }
            parallelReduceFullInnerSubscriberArray[n2] = new ParallelReduceFull.ParallelReduceFullInnerSubscriber(this, biFunction);
            ++n2;
        }
    }

    ParallelReduceFull.SlotPair<T> addValue(T t) {
        int n;
        ParallelReduceFull.SlotPair slotPair;
        while (true) {
            ParallelReduceFull.SlotPair slotPair2;
            slotPair = slotPair2 = this.current.get();
            if (slotPair2 == null) {
                slotPair = slotPair2 = new ParallelReduceFull.SlotPair();
                if (!this.current.compareAndSet(null, slotPair2)) continue;
            }
            if ((n = slotPair.tryAcquireSlot()) >= 0) break;
            this.current.compareAndSet(slotPair, null);
        }
        if (n == 0) {
            slotPair.first = t;
        } else {
            slotPair.second = t;
        }
        if (!slotPair.releaseSlot()) return null;
        this.current.compareAndSet(slotPair, null);
        return slotPair;
    }

    public void cancel() {
        ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArray = this.subscribers;
        int n = parallelReduceFullInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            parallelReduceFullInnerSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    void innerComplete(T object) {
        if (object != null) {
            while ((object = this.addValue(object)) != null) {
                try {
                    object = ObjectHelper.requireNonNull((Object)this.reducer.apply(((ParallelReduceFull.SlotPair)object).first, ((ParallelReduceFull.SlotPair)object).second), (String)"The reducer returned a null value");
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.innerError(throwable);
                    return;
                }
            }
        }
        if (this.remaining.decrementAndGet() != 0) return;
        object = this.current.get();
        this.current.lazySet(null);
        if (object != null) {
            this.complete(((ParallelReduceFull.SlotPair)object).first);
        } else {
            this.downstream.onComplete();
        }
    }

    void innerError(Throwable throwable) {
        if (this.error.compareAndSet(null, throwable)) {
            this.cancel();
            this.downstream.onError(throwable);
        } else {
            if (throwable == this.error.get()) return;
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
