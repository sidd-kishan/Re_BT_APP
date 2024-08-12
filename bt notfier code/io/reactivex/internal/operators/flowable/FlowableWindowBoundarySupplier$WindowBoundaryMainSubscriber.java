/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryInnerSubscriber
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindowBoundarySupplier.WindowBoundaryMainSubscriber<T, B>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    static final FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<Object, Object> BOUNDARY_DISPOSED = new FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber(null);
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<T, B>> boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final Subscriber<? super Flowable<T>> downstream;
    long emitted;
    final AtomicThrowable errors;
    final Callable<? extends Publisher<B>> other;
    final MpscLinkedQueue<Object> queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    Subscription upstream;
    UnicastProcessor<T> window;
    final AtomicInteger windows;

    FlowableWindowBoundarySupplier.WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int n, Callable<? extends Publisher<B>> callable) {
        this.downstream = subscriber;
        this.capacityHint = n;
        this.boundarySubscriber = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.other = callable;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        this.disposeBoundary();
        if (this.windows.decrementAndGet() != 0) return;
        this.upstream.cancel();
    }

    void disposeBoundary() {
        Disposable disposable = (Disposable)this.boundarySubscriber.getAndSet(BOUNDARY_DISPOSED);
        if (disposable == null) return;
        if (disposable == BOUNDARY_DISPOSED) return;
        disposable.dispose();
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
            if (l != this.requested.get()) {
                this.window = unicastProcessor = UnicastProcessor.create((int)this.capacityHint, (Runnable)this);
                this.windows.getAndIncrement();
                try {
                    object2 = (Publisher)ObjectHelper.requireNonNull(this.other.call(), (String)"The other Callable returned a null Publisher");
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    object.addThrowable(throwable);
                    this.done = true;
                    continue;
                }
                FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber(this);
                if (!this.boundarySubscriber.compareAndSet(null, windowBoundaryInnerSubscriber)) continue;
                object2.subscribe((Subscriber)windowBoundaryInnerSubscriber);
                ++l;
                subscriber.onNext((Object)unicastProcessor);
                continue;
            }
            this.upstream.cancel();
            this.disposeBoundary();
            object.addThrowable((Throwable)new MissingBackpressureException("Could not deliver a window due to lack of requests"));
            this.done = true;
        }
    }

    void innerComplete() {
        this.upstream.cancel();
        this.done = true;
        this.drain();
    }

    void innerError(Throwable throwable) {
        this.upstream.cancel();
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerNext(FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber) {
        this.boundarySubscriber.compareAndSet(windowBoundaryInnerSubscriber, null);
        this.queue.offer(NEXT_WINDOW);
        this.drain();
    }

    public void onComplete() {
        this.disposeBoundary();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.disposeBoundary();
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
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        this.queue.offer(NEXT_WINDOW);
        this.drain();
        subscription.request(Long.MAX_VALUE);
    }

    public void request(long l) {
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
    }

    @Override
    public void run() {
        if (this.windows.decrementAndGet() != 0) return;
        this.upstream.cancel();
    }
}
