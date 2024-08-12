/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R>
extends AtomicReference<U>
implements ConditionalSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -312246233408980075L;
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Subscriber<? super R> downstream;
    final AtomicReference<Subscription> other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream = new AtomicReference();

    FlowableWithLatestFrom.WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = subscriber;
        this.combiner = biFunction;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.tryOnNext(t)) return;
        this.upstream.get().request(1L);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void otherError(Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(throwable);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }

    public boolean setOther(Subscription subscription) {
        return SubscriptionHelper.setOnce(this.other, (Subscription)subscription);
    }

    public boolean tryOnNext(T object) {
        block2: {
            Object v = this.get();
            if (v == null) return false;
            try {
                object = ObjectHelper.requireNonNull((Object)this.combiner.apply(object, v), (String)"The combiner returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.cancel();
                this.downstream.onError(throwable);
                break block2;
            }
            this.downstream.onNext(object);
            return true;
        }
        return false;
    }
}
