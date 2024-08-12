/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeSource
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapMaybeObserver<R> inner;
    R item;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final SimplePlainQueue<T> queue;
    final AtomicLong requested;
    volatile int state;
    Subscription upstream;

    FlowableConcatMapMaybe.ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int n, ErrorMode errorMode) {
        this.downstream = subscriber;
        this.mapper = function;
        this.prefetch = n;
        this.errorMode = errorMode;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapMaybeObserver(this);
        this.queue = new SpscArrayQueue(n);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
        this.item = null;
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        ErrorMode errorMode = this.errorMode;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        AtomicLong atomicLong = this.requested;
        int n = this.prefetch;
        int n2 = n - (n >> 1);
        n = 1;
        while (true) {
            int n3;
            if (this.cancelled) {
                object.clear();
                this.item = null;
            } else {
                long l;
                Object object2;
                n3 = this.state;
                if (atomicThrowable.get() != null && (errorMode == ErrorMode.IMMEDIATE || errorMode == ErrorMode.BOUNDARY && n3 == 0)) {
                    object.clear();
                    this.item = null;
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
                if (n3 == 0) {
                    boolean bl = this.done;
                    object2 = object.poll();
                    n3 = object2 == null ? 1 : 0;
                    if (bl && n3 != 0) {
                        object = atomicThrowable.terminate();
                        if (object == null) {
                            subscriber.onComplete();
                        } else {
                            subscriber.onError(object);
                        }
                        return;
                    }
                    if (n3 == 0) {
                        n3 = this.consumed + 1;
                        if (n3 == n2) {
                            this.consumed = 0;
                            this.upstream.request((long)n2);
                        } else {
                            this.consumed = n3;
                        }
                        try {
                            object2 = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object2), (String)"The mapper returned a null MaybeSource");
                            this.state = 1;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            this.upstream.cancel();
                            object.clear();
                            atomicThrowable.addThrowable(throwable);
                            subscriber.onError(atomicThrowable.terminate());
                            return;
                        }
                        object2.subscribe(this.inner);
                    }
                } else if (n3 == 2 && (l = this.emitted) != atomicLong.get()) {
                    object2 = this.item;
                    this.item = null;
                    subscriber.onNext(object2);
                    this.emitted = l + 1L;
                    this.state = 0;
                    continue;
                }
            }
            n = n3 = this.addAndGet(-n);
            if (n3 == 0) return;
        }
    }

    void innerComplete() {
        this.state = 0;
        this.drain();
    }

    void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            this.state = 0;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerSuccess(R r) {
        this.item = r;
        this.state = 2;
        this.drain();
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
            }
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.upstream.cancel();
            this.onError((Throwable)new MissingBackpressureException("queue full?!"));
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        subscription.request((long)this.prefetch);
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
