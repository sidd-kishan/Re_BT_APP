/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullMainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull.ParallelReduceFullMainSubscriber<T> parent;
    final BiFunction<T, T, T> reducer;
    T value;

    ParallelReduceFull.ParallelReduceFullInnerSubscriber(ParallelReduceFull.ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
        this.parent = parallelReduceFullMainSubscriber;
        this.reducer = biFunction;
    }

    void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.parent.innerComplete(this.value);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.innerError(throwable);
    }

    public void onNext(T object) {
        if (this.done) return;
        T t = this.value;
        if (t == null) {
            this.value = object;
        } else {
            try {
                object = ObjectHelper.requireNonNull((Object)this.reducer.apply(t, object), (String)"The reducer returned a null value");
                this.value = object;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                ((Subscription)this.get()).cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
