/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSwitchMap.SwitchMapSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>> active = new AtomicReference();
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final AtomicLong requested = new AtomicLong();
    volatile long unique;
    Subscription upstream;

    static {
        FlowableSwitchMap.SwitchMapInnerSubscriber switchMapInnerSubscriber;
        CANCELLED = switchMapInnerSubscriber = new FlowableSwitchMap.SwitchMapInnerSubscriber(null, -1L, 1);
        switchMapInnerSubscriber.cancel();
    }

    FlowableSwitchMap.SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        this.downstream = subscriber;
        this.mapper = function;
        this.bufferSize = n;
        this.delayErrors = bl;
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        this.disposeInner();
    }

    void disposeInner() {
        FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
        FlowableSwitchMap.SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
        if (switchMapInnerSubscriber2 == (switchMapInnerSubscriber = CANCELLED)) return;
        if ((switchMapInnerSubscriber = this.active.getAndSet(switchMapInnerSubscriber)) == CANCELLED) return;
        if (switchMapInnerSubscriber == null) return;
        switchMapInnerSubscriber.cancel();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super R> subscriber = this.downstream;
        int n = 1;
        while (true) {
            int n2;
            block29: {
                FlowableSwitchMap.SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
                SimpleQueue simpleQueue;
                if (this.cancelled) {
                    this.active.lazySet(null);
                    return;
                }
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            if ((Throwable)this.error.get() != null) {
                                subscriber.onError(this.error.terminate());
                            } else {
                                subscriber.onComplete();
                            }
                            return;
                        }
                    } else {
                        if ((Throwable)this.error.get() != null) {
                            this.disposeInner();
                            subscriber.onError(this.error.terminate());
                            return;
                        }
                        if (this.active.get() == null) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if ((simpleQueue = (switchMapInnerSubscriber = this.active.get()) != null ? switchMapInnerSubscriber.queue : null) == null) break block29;
                if (switchMapInnerSubscriber.done) {
                    if (!this.delayErrors) {
                        if ((Throwable)this.error.get() != null) {
                            this.disposeInner();
                            subscriber.onError(this.error.terminate());
                            return;
                        }
                        if (simpleQueue.isEmpty()) {
                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                            continue;
                        }
                    } else if (simpleQueue.isEmpty()) {
                        this.active.compareAndSet(switchMapInnerSubscriber, null);
                        continue;
                    }
                }
                long l = this.requested.get();
                long l2 = 0L;
                while (true) {
                    Object object;
                    int n3;
                    block31: {
                        block30: {
                            block32: {
                                n2 = n3 = 0;
                                if (l2 == l) break;
                                if (this.cancelled) {
                                    return;
                                }
                                boolean bl = switchMapInnerSubscriber.done;
                                try {
                                    object = simpleQueue.poll();
                                }
                                catch (Throwable throwable) {
                                    Exceptions.throwIfFatal((Throwable)throwable);
                                    switchMapInnerSubscriber.cancel();
                                    this.error.addThrowable(throwable);
                                    object = null;
                                    bl = true;
                                }
                                n2 = object == null ? 1 : 0;
                                if (switchMapInnerSubscriber != this.active.get()) break block30;
                                if (!bl) break block31;
                                if (this.delayErrors) break block32;
                                if ((Throwable)this.error.get() != null) {
                                    subscriber.onError(this.error.terminate());
                                    return;
                                }
                                if (n2 == 0) break block31;
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                                break block30;
                            }
                            if (n2 == 0) break block31;
                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                        }
                        n2 = 1;
                        break;
                    }
                    if (n2 != 0) {
                        n2 = n3;
                        break;
                    }
                    subscriber.onNext(object);
                    ++l2;
                }
                if (l2 != 0L && !this.cancelled) {
                    if (l != Long.MAX_VALUE) {
                        this.requested.addAndGet(-l2);
                    }
                    ((Subscription)switchMapInnerSubscriber.get()).request(l2);
                }
                if (n2 != 0) continue;
            }
            n = n2 = this.addAndGet(-n);
            if (n2 == 0) return;
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (!this.done && this.error.addThrowable(throwable)) {
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
        Publisher publisher;
        long l;
        if (this.done) {
            return;
        }
        this.unique = l = this.unique + 1L;
        FlowableSwitchMap.SwitchMapInnerSubscriber switchMapInnerSubscriber = this.active.get();
        if (switchMapInnerSubscriber != null) {
            switchMapInnerSubscriber.cancel();
        }
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The publisher returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        switchMapInnerSubscriber = new FlowableSwitchMap.SwitchMapInnerSubscriber(this, l, this.bufferSize);
        while ((object = this.active.get()) != CANCELLED) {
            if (!this.active.compareAndSet((FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>)object, (FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>)switchMapInnerSubscriber)) continue;
            publisher.subscribe((Subscriber)switchMapInnerSubscriber);
            break;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        if (this.unique == 0L) {
            this.upstream.request(Long.MAX_VALUE);
        } else {
            this.drain();
        }
    }
}
