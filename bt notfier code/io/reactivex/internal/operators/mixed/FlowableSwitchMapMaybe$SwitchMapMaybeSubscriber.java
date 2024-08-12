/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final AtomicThrowable errors;
    final AtomicReference<SwitchMapMaybeObserver<R>> inner;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final AtomicLong requested;
    Subscription upstream;

    FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
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
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver = this.inner.getAndSet(INNER_DISPOSED);
        if (switchMapMaybeObserver == null) return;
        if (switchMapMaybeObserver == INNER_DISPOSED) return;
        switchMapMaybeObserver.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        Object object = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
        AtomicLong atomicLong = this.requested;
        long l = this.emitted;
        int n = 1;
        while (!this.cancelled) {
            if (object.get() != null && !this.delayErrors) {
                subscriber.onError(object.terminate());
                return;
            }
            boolean bl = this.done;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
            int n2 = switchMapMaybeObserver == null ? 1 : 0;
            if (bl && n2 != 0) {
                if ((object = object.terminate()) != null) {
                    subscriber.onError((Throwable)object);
                } else {
                    subscriber.onComplete();
                }
                return;
            }
            if (n2 == 0 && switchMapMaybeObserver.item != null && l != atomicLong.get()) {
                atomicReference.compareAndSet(switchMapMaybeObserver, null);
                subscriber.onNext(switchMapMaybeObserver.item);
                ++l;
                continue;
            }
            this.emitted = l;
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
        return;
    }

    void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
        if (!this.inner.compareAndSet(switchMapMaybeObserver, null)) return;
        this.drain();
    }

    void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable throwable) {
        if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(throwable)) {
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
        MaybeSource maybeSource;
        SwitchMapMaybeObserver<R> switchMapMaybeObserver = this.inner.get();
        if (switchMapMaybeObserver != null) {
            switchMapMaybeObserver.dispose();
        }
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null MaybeSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.inner.getAndSet(INNER_DISPOSED);
            this.onError(throwable);
            return;
        }
        object = new SwitchMapMaybeObserver(this);
        while ((switchMapMaybeObserver = this.inner.get()) != INNER_DISPOSED) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, (SwitchMapMaybeObserver<R>)object)) continue;
            maybeSource.subscribe(object);
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
