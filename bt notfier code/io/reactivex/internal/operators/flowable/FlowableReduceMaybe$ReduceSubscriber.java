/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

static final class FlowableReduceMaybe.ReduceSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    boolean done;
    final MaybeObserver<? super T> downstream;
    final BiFunction<T, T, T> reducer;
    Subscription upstream;
    T value;

    FlowableReduceMaybe.ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
        this.downstream = maybeObserver;
        this.reducer = biFunction;
    }

    public void dispose() {
        this.upstream.cancel();
        this.done = true;
    }

    public boolean isDisposed() {
        return this.done;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        T t = this.value;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        T t2 = this.value;
        if (t2 == null) {
            this.value = t;
        } else {
            try {
                this.value = ObjectHelper.requireNonNull((Object)this.reducer.apply(t2, t), (String)"The reducer returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
