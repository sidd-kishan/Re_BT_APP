/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSwitchMapSingle.SwitchMapSingleSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapSingleObserver<R>> inner;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final AtomicLong requested;
    Subscription upstream;

    FlowableSwitchMapSingle.SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.inner = new AtomicReference();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.disposeInner();
    }

    void disposeInner() {
        SwitchMapSingleObserver<Object> switchMapSingleObserver = this.inner.getAndSet(INNER_DISPOSED);
        if (switchMapSingleObserver == null) return;
        if (switchMapSingleObserver == INNER_DISPOSED) return;
        switchMapSingleObserver.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        AtomicThrowable atomicThrowable = this.errors;
        AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
        Serializable serializable = this.requested;
        long l = this.emitted;
        int n = 1;
        while (!this.cancelled) {
            if (atomicThrowable.get() != null && !this.delayErrors) {
                subscriber.onError(atomicThrowable.terminate());
                return;
            }
            boolean bl = this.done;
            SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
            int n2 = switchMapSingleObserver == null ? 1 : 0;
            if (bl && n2 != 0) {
                serializable = atomicThrowable.terminate();
                if (serializable != null) {
                    subscriber.onError((Throwable)serializable);
                } else {
                    subscriber.onComplete();
                }
                return;
            }
            if (n2 == 0 && switchMapSingleObserver.item != null && l != ((AtomicLong)serializable).get()) {
                atomicReference.compareAndSet(switchMapSingleObserver, null);
                subscriber.onNext(switchMapSingleObserver.item);
                ++l;
                continue;
            }
            this.emitted = l;
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
        return;
    }

    void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable throwable) {
        if (this.inner.compareAndSet(switchMapSingleObserver, null) && this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.disposeInner();
            }
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.disposeInner();
            }
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        SwitchMapSingleObserver<R> switchMapSingleObserver = this.inner.get();
        if (switchMapSingleObserver != null) {
            switchMapSingleObserver.dispose();
        }
        try {
            object = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null SingleSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.inner.getAndSet(INNER_DISPOSED);
            this.onError(throwable);
            return;
        }
        SwitchMapSingleObserver switchMapSingleObserver2 = new SwitchMapSingleObserver(this);
        while ((switchMapSingleObserver = this.inner.get()) != INNER_DISPOSED) {
            if (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver2)) continue;
            object.subscribe((SingleObserver)switchMapSingleObserver2);
            break;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
