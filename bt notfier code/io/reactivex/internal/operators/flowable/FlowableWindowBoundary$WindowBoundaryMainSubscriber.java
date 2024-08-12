/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryInnerSubscriber
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowBoundary.WindowBoundaryMainSubscriber<T, B>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final FlowableWindowBoundary.WindowBoundaryInnerSubscriber<T, B> boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final Subscriber<? super Flowable<T>> downstream;
    long emitted;
    final AtomicThrowable errors;
    final MpscLinkedQueue<Object> queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    final AtomicReference<Subscription> upstream;
    UnicastProcessor<T> window;
    final AtomicInteger windows;

    FlowableWindowBoundary.WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int n) {
        this.downstream = subscriber;
        this.capacityHint = n;
        this.boundarySubscriber = new FlowableWindowBoundary.WindowBoundaryInnerSubscriber(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        this.boundarySubscriber.dispose();
        if (this.windows.decrementAndGet() != 0) return;
        SubscriptionHelper.cancel(this.upstream);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super Flowable<T>> subscriber = this.downstream;
        MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
        Object object = this.errors;
        long l = this.emitted;
        int n = 1;
        while (true) {
            if (this.windows.get() == 0) {
                mpscLinkedQueue.clear();
                this.window = null;
                return;
            }
            UnicastProcessor unicastProcessor = this.window;
            boolean bl = this.done;
            if (bl && object.get() != null) {
                mpscLinkedQueue.clear();
                object = object.terminate();
                if (unicastProcessor != null) {
                    this.window = null;
                    unicastProcessor.onError((Throwable)object);
                }
                subscriber.onError((Throwable)object);
                return;
            }
            Object object2 = mpscLinkedQueue.poll();
            int n2 = object2 == null ? 1 : 0;
            if (bl && n2 != 0) {
                if ((object = object.terminate()) == null) {
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onComplete();
                    }
                    subscriber.onComplete();
                } else {
                    if (unicastProcessor != null) {
                        this.window = null;
                        unicastProcessor.onError((Throwable)object);
                    }
                    subscriber.onError((Throwable)object);
                }
                return;
            }
            if (n2 != 0) {
                this.emitted = l;
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            if (object2 != NEXT_WINDOW) {
                unicastProcessor.onNext(object2);
                continue;
            }
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            if (this.stopWindows.get()) continue;
            this.window = unicastProcessor = UnicastProcessor.create((int)this.capacityHint, (Runnable)this);
            this.windows.getAndIncrement();
            if (l != this.requested.get()) {
                ++l;
                subscriber.onNext((Object)unicastProcessor);
                continue;
            }
            SubscriptionHelper.cancel(this.upstream);
            this.boundarySubscriber.dispose();
            object.addThrowable((Throwable)new MissingBackpressureException("Could not deliver a window due to lack of requests"));
            this.done = true;
        }
    }

    void innerComplete() {
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        this.drain();
    }

    void innerError(Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        this.drain();
    }

    public void onComplete() {
        this.boundarySubscriber.dispose();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.boundarySubscriber.dispose();
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription, (long)Long.MAX_VALUE);
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }

    @Override
    public void run() {
        if (this.windows.decrementAndGet() != 0) return;
        SubscriptionHelper.cancel(this.upstream);
    }
}
