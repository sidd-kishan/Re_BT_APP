/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscribers.InnerQueuedSubscriber
 *  io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
InnerQueuedSubscriberSupport<R> {
    private static final long serialVersionUID = -4255299542215038287L;
    volatile boolean cancelled;
    volatile InnerQueuedSubscriber<R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final AtomicLong requested;
    final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
    Subscription upstream;

    FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int n, int n2, ErrorMode errorMode) {
        this.downstream = subscriber;
        this.mapper = function;
        this.maxConcurrency = n;
        this.prefetch = n2;
        this.errorMode = errorMode;
        this.subscribers = new SpscLinkedArrayQueue(Math.min(n2, n));
        this.errors = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        this.drainAndCancel();
    }

    void cancelAll() {
        InnerQueuedSubscriber innerQueuedSubscriber = this.current;
        this.current = null;
        if (innerQueuedSubscriber != null) {
            innerQueuedSubscriber.cancel();
        }
        while ((innerQueuedSubscriber = (InnerQueuedSubscriber)this.subscribers.poll()) != null) {
            innerQueuedSubscriber.cancel();
        }
    }

    public void drain() {
        boolean bl;
        if (this.getAndIncrement() != 0) {
            return;
        }
        Object object = this.current;
        Subscriber<? super R> subscriber = this.downstream;
        ErrorMode errorMode = this.errorMode;
        int n = 1;
        do {
            long l;
            SimpleQueue simpleQueue;
            Object object2;
            boolean bl2;
            long l2 = this.requested.get();
            if (object == null) {
                if (errorMode != ErrorMode.END && (Throwable)this.errors.get() != null) {
                    this.cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                }
                bl2 = this.done;
                object2 = (InnerQueuedSubscriber)this.subscribers.poll();
                if (bl2 && object2 == null) {
                    object = this.errors.terminate();
                    if (object != null) {
                        subscriber.onError((Throwable)object);
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
                object = object2;
                if (object2 != null) {
                    this.current = object2;
                    object = object2;
                }
            }
            if (object != null && (simpleQueue = object.queue()) != null) {
                boolean bl3;
                long l3;
                block21: {
                    for (l3 = 0L; l3 != l2; ++l3) {
                        block20: {
                            if (this.cancelled) {
                                this.cancelAll();
                                return;
                            }
                            if (errorMode == ErrorMode.IMMEDIATE && (Throwable)this.errors.get() != null) {
                                this.current = null;
                                object.cancel();
                                this.cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                            bl2 = object.isDone();
                            try {
                                object2 = simpleQueue.poll();
                                bl = object2 == null;
                                if (!bl2 || !bl) break block20;
                                this.current = null;
                            }
                            catch (Throwable throwable) {
                                Exceptions.throwIfFatal((Throwable)throwable);
                                this.current = null;
                                object.cancel();
                                this.cancelAll();
                                subscriber.onError(throwable);
                                return;
                            }
                            this.upstream.request(1L);
                            object2 = null;
                            bl3 = true;
                            break block21;
                        }
                        if (bl) break;
                        subscriber.onNext(object2);
                        object.requestOne();
                    }
                    bl3 = false;
                    object2 = object;
                }
                bl = bl3;
                object = object2;
                l = l3;
                if (l3 == l2) {
                    if (this.cancelled) {
                        this.cancelAll();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && (Throwable)this.errors.get() != null) {
                        this.current = null;
                        object2.cancel();
                        this.cancelAll();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    boolean bl4 = object2.isDone();
                    bl2 = simpleQueue.isEmpty();
                    bl = bl3;
                    object = object2;
                    l = l3;
                    if (bl4) {
                        bl = bl3;
                        object = object2;
                        l = l3;
                        if (bl2) {
                            this.current = null;
                            this.upstream.request(1L);
                            object = null;
                            bl = true;
                            l = l3;
                        }
                    }
                }
            } else {
                l = 0L;
                bl = false;
            }
            if (l == 0L || l2 == Long.MAX_VALUE) continue;
            this.requested.addAndGet(-l);
        } while (bl || (n = this.addAndGet(-n)) != 0);
    }

    void drainAndCancel() {
        if (this.getAndIncrement() != 0) return;
        do {
            this.cancelAll();
        } while (this.decrementAndGet() != 0);
    }

    public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        this.drain();
    }

    public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
        if (innerQueuedSubscriber.queue().offer(r)) {
            this.drain();
        } else {
            innerQueuedSubscriber.cancel();
            this.innerError(innerQueuedSubscriber, (Throwable)new MissingBackpressureException());
        }
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        try {
            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber((InnerQueuedSubscriberSupport)this, this.prefetch);
        if (this.cancelled) {
            return;
        }
        this.subscribers.offer((Object)innerQueuedSubscriber);
        object.subscribe((Subscriber)innerQueuedSubscriber);
        if (!this.cancelled) return;
        innerQueuedSubscriber.cancel();
        this.drainAndCancel();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        int n = this.maxConcurrency;
        long l = n == Integer.MAX_VALUE ? Long.MAX_VALUE : (long)n;
        subscription.request(l);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
