/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWithLatestFromMany.WithLatestFromSubscriber<T, R>
extends AtomicInteger
implements ConditionalSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final AtomicLong requested;
    final FlowableWithLatestFromMany.WithLatestInnerSubscriber[] subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicReferenceArray<Object> values;

    FlowableWithLatestFromMany.WithLatestFromSubscriber(Subscriber<? super R> withLatestInnerSubscriberArray, Function<? super Object[], R> function, int n) {
        this.downstream = withLatestInnerSubscriberArray;
        this.combiner = function;
        withLatestInnerSubscriberArray = new FlowableWithLatestFromMany.WithLatestInnerSubscriber[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.subscribers = withLatestInnerSubscriberArray;
                this.values = new AtomicReferenceArray(n);
                this.upstream = new AtomicReference();
                this.requested = new AtomicLong();
                this.error = new AtomicThrowable();
                return;
            }
            withLatestInnerSubscriberArray[n2] = new FlowableWithLatestFromMany.WithLatestInnerSubscriber(this, n2);
            ++n2;
        }
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArray = this.subscribers;
        int n = withLatestInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            withLatestInnerSubscriberArray[n2].dispose();
            ++n2;
        }
    }

    void cancelAllBut(int n) {
        FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArray = this.subscribers;
        int n2 = 0;
        while (n2 < withLatestInnerSubscriberArray.length) {
            if (n2 != n) {
                withLatestInnerSubscriberArray[n2].dispose();
            }
            ++n2;
        }
    }

    void innerComplete(int n, boolean bl) {
        if (bl) return;
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        this.cancelAllBut(n);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerError(int n, Throwable throwable) {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        this.cancelAllBut(n);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void innerNext(int n, Object object) {
        this.values.set(n, object);
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.cancelAllBut(-1);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.cancelAllBut(-1);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        if (this.tryOnNext(t)) return;
        if (this.done) return;
        this.upstream.get().request(1L);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.requested, (long)l);
    }

    void subscribe(Publisher<?>[] publisherArray, int n) {
        FlowableWithLatestFromMany.WithLatestInnerSubscriber[] withLatestInnerSubscriberArray = this.subscribers;
        AtomicReference<Subscription> atomicReference = this.upstream;
        int n2 = 0;
        while (n2 < n) {
            if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
                return;
            }
            publisherArray[n2].subscribe((Subscriber)withLatestInnerSubscriberArray[n2]);
            ++n2;
        }
    }

    public boolean tryOnNext(T object) {
        if (this.done) {
            return false;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int n = atomicReferenceArray.length();
        Object[] objectArray = new Object[n + 1];
        objectArray[0] = object;
        int n2 = 0;
        while (n2 < n) {
            object = atomicReferenceArray.get(n2);
            if (object == null) {
                return false;
            }
            objectArray[++n2] = object;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.combiner.apply((Object)objectArray), (String)"The combiner returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.cancel();
            this.onError(throwable);
            return false;
        }
        HalfSerializer.onNext(this.downstream, object, (AtomicInteger)this, (AtomicThrowable)this.error);
        return true;
    }
}
