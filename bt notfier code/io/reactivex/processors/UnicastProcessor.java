/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.UnicastProcessor$UnicastQueueSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T>
extends FlowableProcessor<T> {
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final AtomicReference<Subscriber<? super T>> downstream;
    boolean enableOperatorFusion;
    Throwable error;
    final AtomicReference<Runnable> onTerminate;
    final AtomicBoolean once;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested;
    final BasicIntQueueSubscription<T> wip;

    UnicastProcessor(int n) {
        this(n, null, true);
    }

    UnicastProcessor(int n, Runnable runnable) {
        this(n, runnable, true);
    }

    UnicastProcessor(int n, Runnable runnable, boolean bl) {
        this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive((int)n, (String)"capacityHint"));
        this.onTerminate = new AtomicReference<Runnable>(runnable);
        this.delayError = bl;
        this.downstream = new AtomicReference();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription(this);
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<T>(UnicastProcessor.bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int n) {
        return new UnicastProcessor<T>(n);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int n, Runnable runnable) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"onTerminate");
        return new UnicastProcessor<T>(n, runnable);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int n, Runnable runnable, boolean bl) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"onTerminate");
        return new UnicastProcessor<T>(n, runnable, bl);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean bl) {
        return new UnicastProcessor<T>(UnicastProcessor.bufferSize(), null, bl);
    }

    boolean checkTerminated(boolean bl, boolean bl2, boolean bl3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> object) {
        if (this.cancelled) {
            object.clear();
            this.downstream.lazySet(null);
            return true;
        }
        if (!bl2) return false;
        if (bl && this.error != null) {
            object.clear();
            this.downstream.lazySet(null);
            subscriber.onError(this.error);
            return true;
        }
        if (!bl3) return false;
        object = this.error;
        this.downstream.lazySet(null);
        if (object != null) {
            subscriber.onError(object);
        } else {
            subscriber.onComplete();
        }
        return true;
    }

    void doTerminate() {
        Runnable runnable = this.onTerminate.getAndSet(null);
        if (runnable == null) return;
        runnable.run();
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int n = 1;
        Subscriber<? super T> subscriber = this.downstream.get();
        while (true) {
            if (subscriber != null) {
                if (this.enableOperatorFusion) {
                    this.drainFused(subscriber);
                    break;
                }
                this.drainRegular(subscriber);
                break;
            }
            if ((n = this.wip.addAndGet(-n)) == 0) {
                return;
            }
            subscriber = this.downstream.get();
        }
    }

    void drainFused(Subscriber<? super T> subscriber) {
        int n;
        Object object = this.queue;
        boolean bl = this.delayError;
        int n2 = 1;
        do {
            if (this.cancelled) {
                object.clear();
                this.downstream.lazySet(null);
                return;
            }
            boolean bl2 = this.done;
            if (bl ^ true && bl2 && this.error != null) {
                object.clear();
                this.downstream.lazySet(null);
                subscriber.onError(this.error);
                return;
            }
            subscriber.onNext(null);
            if (bl2) {
                this.downstream.lazySet(null);
                object = this.error;
                if (object != null) {
                    subscriber.onError(object);
                } else {
                    subscriber.onComplete();
                }
                return;
            }
            n2 = n = this.wip.addAndGet(-n2);
        } while (n != 0);
    }

    void drainRegular(Subscriber<? super T> subscriber) {
        int n;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError ^ true;
        int n2 = 1;
        do {
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l2 != l; l = 1L + l) {
                boolean bl2 = this.done;
                Object object = spscLinkedArrayQueue.poll();
                boolean bl3 = object == null;
                if (this.checkTerminated(bl, bl2, bl3, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (bl3) break;
                subscriber.onNext(object);
            }
            if (l2 == l && this.checkTerminated(bl, this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n2 = n = this.wip.addAndGet(-n2);
        } while (n != 0);
    }

    public Throwable getThrowable() {
        if (!this.done) return null;
        return this.error;
    }

    public boolean hasComplete() {
        boolean bl = this.done && this.error == null;
        return bl;
    }

    public boolean hasSubscribers() {
        boolean bl = this.downstream.get() != null;
        return bl;
    }

    public boolean hasThrowable() {
        boolean bl = this.done && this.error != null;
        return bl;
    }

    public void onComplete() {
        if (this.done) return;
        if (this.cancelled) return;
        this.done = true;
        this.doTerminate();
        this.drain();
    }

    public void onError(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.error = throwable;
            this.done = true;
            this.doTerminate();
            this.drain();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, (String)"onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) return;
        if (this.cancelled) return;
        this.queue.offer(t);
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!this.done && !this.cancelled) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.wip);
            this.downstream.set(subscriber);
            if (this.cancelled) {
                this.downstream.lazySet(null);
            } else {
                this.drain();
            }
        } else {
            EmptySubscription.error((Throwable)new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
        }
    }
}
