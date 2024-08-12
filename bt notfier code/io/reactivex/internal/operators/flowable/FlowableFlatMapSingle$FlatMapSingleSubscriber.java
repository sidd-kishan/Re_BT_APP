/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapSingle$FlatMapSingleSubscriber$InnerObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableFlatMapSingle.FlatMapSingleSubscriber<T, R>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Subscriber<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;
    final AtomicReference<SpscLinkedArrayQueue<R>> queue;
    final AtomicLong requested;
    final CompositeDisposable set;
    Subscription upstream;

    FlowableFlatMapSingle.FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl, int n) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
        this.requested = new AtomicLong();
        this.set = new CompositeDisposable();
        this.errors = new AtomicThrowable();
        this.active = new AtomicInteger(1);
        this.queue = new AtomicReference();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    void clear() {
        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
        if (spscLinkedArrayQueue == null) return;
        spscLinkedArrayQueue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        int n;
        Subscriber<? super R> subscriber = this.downstream;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.queue;
        int n2 = 1;
        do {
            long l;
            block17: {
                boolean bl;
                Object object;
                block19: {
                    block18: {
                        boolean bl2;
                        long l2 = this.requested.get();
                        l = 0L;
                        while (true) {
                            bl2 = false;
                            if (l == l2) break;
                            if (this.cancelled) {
                                this.clear();
                                return;
                            }
                            if (!this.delayErrors && (Throwable)this.errors.get() != null) {
                                object = this.errors.terminate();
                                this.clear();
                                subscriber.onError(object);
                                return;
                            }
                            n = atomicInteger.get() == 0 ? 1 : 0;
                            object = atomicReference.get();
                            object = object != null ? object.poll() : null;
                            bl = object == null;
                            if (n != 0 && bl) {
                                object = this.errors.terminate();
                                if (object != null) {
                                    subscriber.onError(object);
                                } else {
                                    subscriber.onComplete();
                                }
                                return;
                            }
                            if (bl) break;
                            subscriber.onNext(object);
                            ++l;
                        }
                        if (l != l2) break block17;
                        if (this.cancelled) {
                            this.clear();
                            return;
                        }
                        if (!this.delayErrors && (Throwable)this.errors.get() != null) {
                            object = this.errors.terminate();
                            this.clear();
                            subscriber.onError(object);
                            return;
                        }
                        n = atomicInteger.get() == 0 ? 1 : 0;
                        object = atomicReference.get();
                        if (object == null) break block18;
                        bl = bl2;
                        if (!object.isEmpty()) break block19;
                    }
                    bl = true;
                }
                if (n != 0 && bl) {
                    object = this.errors.terminate();
                    if (object != null) {
                        subscriber.onError(object);
                    } else {
                        subscriber.onComplete();
                    }
                    return;
                }
            }
            if (l != 0L) {
                BackpressureHelper.produced((AtomicLong)this.requested, (long)l);
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(l);
                }
            }
            n2 = n = this.addAndGet(-n2);
        } while (n != 0);
    }

    SpscLinkedArrayQueue<R> getOrCreateQueue() {
        SpscLinkedArrayQueue spscLinkedArrayQueue;
        do {
            if ((spscLinkedArrayQueue = this.queue.get()) == null) continue;
            return spscLinkedArrayQueue;
        } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue = new SpscLinkedArrayQueue(Flowable.bufferSize())));
        return spscLinkedArrayQueue;
    }

    void innerError(InnerObserver innerObserver, Throwable throwable) {
        this.set.delete((Disposable)innerObserver);
        if (this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            this.active.decrementAndGet();
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void innerSuccess(InnerObserver var1_1, R var2_2) {
        this.set.delete((Disposable)var1_1 /* !! */ );
        if (this.get() != 0) ** GOTO lbl-1000
        var3_3 = true;
        if (this.compareAndSet(0, 1)) {
            if (this.active.decrementAndGet() != 0) {
                var3_3 = false;
            }
            if (this.requested.get() != 0L) {
                this.downstream.onNext(var2_2);
                var1_1 /* !! */  = this.queue.get();
                if (var3_3 && (var1_1 /* !! */  == null || var1_1 /* !! */ .isEmpty())) {
                    var1_1 /* !! */  = this.errors.terminate();
                    if (var1_1 /* !! */  != null) {
                        this.downstream.onError(var1_1 /* !! */ );
                        return;
                    }
                    this.downstream.onComplete();
                    return;
                }
                BackpressureHelper.produced((AtomicLong)this.requested, (long)1L);
                if (this.maxConcurrency != 0x7FFFFFFF) {
                    this.upstream.request(1L);
                }
            } else {
                var1_1 /* !! */  = this.getOrCreateQueue();
                synchronized (var1_1 /* !! */ ) {
                    var1_1 /* !! */ .offer(var2_2);
                }
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            var1_1 /* !! */  = this.getOrCreateQueue();
            synchronized (var1_1 /* !! */ ) {
                var1_1 /* !! */ .offer(var2_2);
            }
            this.active.decrementAndGet();
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onComplete() {
        this.active.decrementAndGet();
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(throwable)) {
            if (!this.delayErrors) {
                this.set.dispose();
            }
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        SingleSource singleSource;
        try {
            singleSource = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null SingleSource");
            this.active.getAndIncrement();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = new InnerObserver(this);
        if (this.cancelled) return;
        if (!this.set.add(object)) return;
        singleSource.subscribe(object);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        int n = this.maxConcurrency;
        if (n == Integer.MAX_VALUE) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.request((long)n);
        }
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
