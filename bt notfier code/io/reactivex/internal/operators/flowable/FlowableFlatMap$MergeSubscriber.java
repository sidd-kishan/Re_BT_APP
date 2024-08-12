/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.ExceptionHelper
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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableFlatMap.MergeSubscriber<T, U>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] CANCELLED;
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] EMPTY;
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super U> downstream;
    final AtomicThrowable errs = new AtomicThrowable();
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;
    volatile SimplePlainQueue<U> queue;
    final AtomicLong requested;
    int scalarEmitted;
    final int scalarLimit;
    final AtomicReference<FlowableFlatMap.InnerSubscriber<?, ?>[]> subscribers = new AtomicReference();
    long uniqueId;
    Subscription upstream;

    static {
        EMPTY = new FlowableFlatMap.InnerSubscriber[0];
        CANCELLED = new FlowableFlatMap.InnerSubscriber[0];
    }

    FlowableFlatMap.MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean bl, int n, int n2) {
        this.requested = new AtomicLong();
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
        this.bufferSize = n2;
        this.scalarLimit = Math.max(1, n >> 1);
        this.subscribers.lazySet(EMPTY);
    }

    boolean addInner(FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
        FlowableFlatMap.InnerSubscriber[] innerSubscriberArray;
        FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArray2;
        do {
            if ((innerSubscriberArray2 = this.subscribers.get()) == CANCELLED) {
                innerSubscriber.dispose();
                return false;
            }
            int n = innerSubscriberArray2.length;
            innerSubscriberArray = new FlowableFlatMap.InnerSubscriber[n + 1];
            System.arraycopy(innerSubscriberArray2, 0, innerSubscriberArray, 0, n);
            innerSubscriberArray[n] = innerSubscriber;
        } while (!this.subscribers.compareAndSet(innerSubscriberArray2, innerSubscriberArray));
        return true;
    }

    public void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.cancel();
        this.disposeAll();
        if (this.getAndIncrement() != 0) return;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (simplePlainQueue == null) return;
        simplePlainQueue.clear();
    }

    boolean checkTerminate() {
        if (this.cancelled) {
            this.clearScalarQueue();
            return true;
        }
        if (this.delayErrors) return false;
        if (this.errs.get() == null) return false;
        this.clearScalarQueue();
        Throwable throwable = this.errs.terminate();
        if (throwable == ExceptionHelper.TERMINATED) return true;
        this.downstream.onError(throwable);
        return true;
    }

    void clearScalarQueue() {
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (simplePlainQueue == null) return;
        simplePlainQueue.clear();
    }

    void disposeAll() {
        Object object;
        FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArray = this.subscribers.get();
        if (innerSubscriberArray == (object = CANCELLED)) return;
        if ((object = this.subscribers.getAndSet((FlowableFlatMap.InnerSubscriber<?, ?>[])object)) == CANCELLED) return;
        int n = ((FlowableFlatMap.InnerSubscriber<?, ?>[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = this.errs.terminate();
                if (object == null) return;
                if (object == ExceptionHelper.TERMINATED) return;
                RxJavaPlugins.onError(object);
                return;
            }
            object[n2].dispose();
            ++n2;
        }
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void drainLoop() {
        var22_1 = this.downstream;
        var3_2 = 1;
        do lbl-1000:
        // 3 sources

        {
            block42: {
                block39: {
                    block38: {
                        block41: {
                            block40: {
                                block35: {
                                    if (this.checkTerminate()) {
                                        return;
                                    }
                                    var21_18 /* !! */  = this.queue;
                                    var12_13 = this.requested.get();
                                    var7_8 = var12_13 == 0x7FFFFFFFFFFFFFFFL;
                                    var16_15 = 0L;
                                    var18_16 = var12_13;
                                    var14_14 = var16_15;
                                    if (var21_18 /* !! */  != null) {
                                        do {
                                            var14_14 = 0L;
                                            var20_17 /* !! */  = null;
                                            while (var12_13 != 0L) {
                                                var20_17 /* !! */  = var21_18 /* !! */ .poll();
                                                if (this.checkTerminate()) {
                                                    return;
                                                }
                                                if (var20_17 /* !! */  == null) break;
                                                var22_1.onNext(var20_17 /* !! */ );
                                                ++var16_15;
                                                ++var14_14;
                                                --var12_13;
                                            }
                                            if (var14_14 != 0L) {
                                                var12_13 = var7_8 != false ? 0x7FFFFFFFFFFFFFFFL : this.requested.addAndGet(-var14_14);
                                            }
                                            var18_16 = var12_13;
                                            var14_14 = var16_15;
                                            if (var12_13 == 0L) break block35;
                                        } while (var20_17 /* !! */  != null);
                                        var18_16 = var12_13;
                                        var14_14 = var16_15;
                                    }
                                }
                                var11_12 = this.done;
                                var21_18 /* !! */  = this.queue;
                                var20_17 /* !! */  = this.subscribers.get();
                                var4_5 = var20_17 /* !! */ .length;
                                if (var11_12 && (var21_18 /* !! */  == null || var21_18 /* !! */ .isEmpty()) && var4_5 == 0) {
                                    var20_17 /* !! */  = this.errs.terminate();
                                    if (var20_17 /* !! */  == ExceptionHelper.TERMINATED) return;
                                    if (var20_17 /* !! */  == null) {
                                        var22_1.onComplete();
                                    } else {
                                        var22_1.onError(var20_17 /* !! */ );
                                    }
                                    return;
                                }
                                if (var4_5 == 0) break block39;
                                var12_13 = this.lastId;
                                var2_4 = this.lastIndex;
                                if (var4_5 <= var2_4) break block40;
                                var1_3 = var2_4;
                                if (var20_17 /* !! */ [var2_4].id == var12_13) break block41;
                            }
                            var1_3 = var2_4;
                            if (var4_5 <= var2_4) {
                                var1_3 = 0;
                            }
                            for (var2_4 = 0; var2_4 < var4_5 && var20_17 /* !! */ [var1_3].id != var12_13; ++var2_4) {
                                var1_3 = var5_6 = var1_3 + 1;
                                if (var5_6 != var4_5) continue;
                                var1_3 = 0;
                            }
                            this.lastIndex = var1_3;
                            this.lastId = var20_17 /* !! */ [var1_3].id;
                        }
                        var5_6 = var1_3;
                        var2_4 = 0;
                        var6_7 = 0;
                        var12_13 = var14_14;
                        var1_3 = var4_5;
                        var14_14 = var18_16;
                        var4_5 = var6_7;
                        while (var4_5 < var1_3) {
                            block37: {
                                block36: {
                                    if (this.checkTerminate()) {
                                        return;
                                    }
                                    var23_20 = var20_17 /* !! */ [var5_6];
                                    var21_18 /* !! */  = null;
                                    do {
                                        if (this.checkTerminate()) {
                                            return;
                                        }
                                        var24_21 = var23_20.queue;
                                        if (var24_21 == null) {
                                            var16_15 = var14_14;
                                            break block36;
                                        }
                                        var16_15 = 0L;
                                        while (var14_14 != 0L) {
                                            try {
                                                var21_18 /* !! */  = var24_21.poll();
                                                if (var21_18 /* !! */  == null) {
                                                    break;
                                                }
                                            }
                                            catch (Throwable var21_19) {
                                                Exceptions.throwIfFatal((Throwable)var21_19);
                                                var23_20.dispose();
                                                this.errs.addThrowable(var21_19);
                                                if (!this.delayErrors) {
                                                    this.upstream.cancel();
                                                }
                                                if (this.checkTerminate()) {
                                                    return;
                                                }
                                                this.removeInner(var23_20);
                                                var8_9 = var4_5 + 1;
                                                var2_4 = var1_3;
                                                var6_7 = 1;
                                                var18_16 = var12_13;
                                                break block37;
                                            }
                                            var22_1.onNext(var21_18 /* !! */ );
                                            if (this.checkTerminate()) {
                                                return;
                                            }
                                            --var14_14;
                                            ++var16_15;
                                        }
                                        if (var16_15 != 0L) {
                                            var14_14 = var7_8 == false ? this.requested.addAndGet(-var16_15) : 0x7FFFFFFFFFFFFFFFL;
                                            var23_20.requestMore(var16_15);
                                        }
                                        var16_15 = var14_14;
                                        if (var14_14 == 0L) break block36;
                                    } while (var21_18 /* !! */  != null);
                                    var16_15 = var14_14;
                                }
                                var21_18 /* !! */  = var20_17 /* !! */ ;
                                var11_12 = var23_20.done;
                                var24_21 = var23_20.queue;
                                if (var11_12 && (var24_21 == null || var24_21.isEmpty())) {
                                    this.removeInner(var23_20);
                                    if (this.checkTerminate()) {
                                        return;
                                    }
                                    ++var12_13;
                                    var2_4 = 1;
                                }
                                if (var16_15 == 0L) {
                                    var1_3 = var2_4;
                                    var20_17 /* !! */  = var21_18 /* !! */ ;
                                    break block38;
                                }
                                var9_10 = var5_6 + 1;
                                var10_11 = var1_3;
                                var6_7 = var2_4;
                                var5_6 = var9_10;
                                var8_9 = var4_5;
                                var14_14 = var16_15;
                                var18_16 = var12_13;
                                if (var9_10 == var10_11) {
                                    var5_6 = 0;
                                    var18_16 = var12_13;
                                    var14_14 = var16_15;
                                    var8_9 = var4_5;
                                    var6_7 = var2_4;
                                }
                            }
                            var4_5 = var8_9 + 1;
                            var2_4 = var6_7;
                            var12_13 = var18_16;
                        }
                        var1_3 = var2_4;
                    }
                    this.lastIndex = var5_6;
                    this.lastId = var20_17 /* !! */ [var5_6].id;
                    break block42;
                }
                var1_3 = 0;
                var12_13 = var14_14;
            }
            if (var12_13 != 0L && !this.cancelled) {
                this.upstream.request(var12_13);
            }
            if (var1_3 != 0) ** GOTO lbl-1000
            var3_2 = var1_3 = this.addAndGet(-var3_2);
        } while (var1_3 != 0);
    }

    SimpleQueue<U> getInnerQueue(FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
        SimpleQueue simpleQueue;
        SimpleQueue simpleQueue2 = simpleQueue = innerSubscriber.queue;
        if (simpleQueue != null) return simpleQueue2;
        innerSubscriber.queue = simpleQueue2 = new SpscArrayQueue(this.bufferSize);
        return simpleQueue2;
    }

    SimpleQueue<U> getMainQueue() {
        SpscLinkedArrayQueue spscLinkedArrayQueue;
        Object object = spscLinkedArrayQueue = this.queue;
        if (spscLinkedArrayQueue != null) return object;
        object = this.maxConcurrency == Integer.MAX_VALUE ? new SpscLinkedArrayQueue(this.bufferSize) : new SpscArrayQueue(this.maxConcurrency);
        this.queue = object;
        return object;
    }

    void innerError(FlowableFlatMap.InnerSubscriber<T, U> innerSubscriberArray, Throwable throwable) {
        if (this.errs.addThrowable(throwable)) {
            innerSubscriberArray.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                innerSubscriberArray = this.subscribers.getAndSet(CANCELLED);
                int n = innerSubscriberArray.length;
                for (int i = 0; i < n; ++i) {
                    innerSubscriberArray[i].dispose();
                }
            }
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
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
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        if (this.errs.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block8: {
            Publisher publisher;
            if (this.done) {
                return;
            }
            try {
                publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null Publisher");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
            if (publisher instanceof Callable) {
                int n;
                try {
                    int n2;
                    object = ((Callable)publisher).call();
                    if (object != null) {
                        this.tryEmitScalar(object);
                        break block8;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE) return;
                    if (this.cancelled) return;
                    this.scalarEmitted = n2 = this.scalarEmitted + 1;
                    n = this.scalarLimit;
                    if (n2 != n) return;
                    this.scalarEmitted = 0;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.errs.addThrowable(throwable);
                    this.drain();
                    return;
                }
                this.upstream.request((long)n);
            } else {
                long l = this.uniqueId;
                this.uniqueId = 1L + l;
                object = new FlowableFlatMap.InnerSubscriber(this, l);
                if (!this.addInner((FlowableFlatMap.InnerSubscriber<T, U>)object)) return;
                publisher.subscribe(object);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        if (this.cancelled) return;
        int n = this.maxConcurrency;
        if (n == Integer.MAX_VALUE) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.request((long)n);
        }
    }

    void removeInner(FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
        FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArray;
        FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArray2;
        do {
            int n;
            int n2;
            if ((n2 = (innerSubscriberArray2 = this.subscribers.get()).length) == 0) {
                return;
            }
            int n3 = -1;
            int n4 = 0;
            while (true) {
                n = n3;
                if (n4 >= n2) break;
                if (innerSubscriberArray2[n4] == innerSubscriber) {
                    n = n4;
                    break;
                }
                ++n4;
            }
            if (n < 0) {
                return;
            }
            if (n2 == 1) {
                innerSubscriberArray = EMPTY;
                continue;
            }
            innerSubscriberArray = new FlowableFlatMap.InnerSubscriber[n2 - 1];
            System.arraycopy(innerSubscriberArray2, 0, innerSubscriberArray, 0, n);
            System.arraycopy(innerSubscriberArray2, n + 1, innerSubscriberArray, n, n2 - n - 1);
        } while (!this.subscribers.compareAndSet(innerSubscriberArray2, innerSubscriberArray));
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }

    void tryEmit(U u, FlowableFlatMap.InnerSubscriber<T, U> innerSubscriber) {
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            long l = this.requested.get();
            SimpleQueue<U> simpleQueue = innerSubscriber.queue;
            if (l != 0L && (simpleQueue == null || simpleQueue.isEmpty())) {
                this.downstream.onNext(u);
                if (l != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                innerSubscriber.requestMore(1L);
            } else {
                SimpleQueue<U> simpleQueue2 = simpleQueue;
                if (simpleQueue == null) {
                    simpleQueue2 = this.getInnerQueue(innerSubscriber);
                }
                if (!simpleQueue2.offer(u)) {
                    this.onError((Throwable)new MissingBackpressureException("Inner queue full?!"));
                    return;
                }
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            SimpleQueue simpleQueue;
            SimpleQueue simpleQueue3 = simpleQueue = innerSubscriber.queue;
            if (simpleQueue == null) {
                innerSubscriber.queue = simpleQueue3 = new SpscArrayQueue(this.bufferSize);
            }
            if (!simpleQueue3.offer(u)) {
                this.onError((Throwable)new MissingBackpressureException("Inner queue full?!"));
                return;
            }
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    void tryEmitScalar(U u) {
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            long l = this.requested.get();
            SimplePlainQueue<U> simplePlainQueue = this.queue;
            if (l != 0L && (simplePlainQueue == null || simplePlainQueue.isEmpty())) {
                this.downstream.onNext(u);
                if (l != Long.MAX_VALUE) {
                    this.requested.decrementAndGet();
                }
                if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                    int n;
                    this.scalarEmitted = n = this.scalarEmitted + 1;
                    int n2 = this.scalarLimit;
                    if (n == n2) {
                        this.scalarEmitted = 0;
                        this.upstream.request((long)n2);
                    }
                }
            } else {
                SimplePlainQueue<U> simplePlainQueue2 = simplePlainQueue;
                if (simplePlainQueue == null) {
                    simplePlainQueue2 = this.getMainQueue();
                }
                if (!simplePlainQueue2.offer(u)) {
                    this.onError(new IllegalStateException("Scalar queue full?!"));
                    return;
                }
            }
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!this.getMainQueue().offer(u)) {
                this.onError(new IllegalStateException("Scalar queue full?!"));
                return;
            }
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}
