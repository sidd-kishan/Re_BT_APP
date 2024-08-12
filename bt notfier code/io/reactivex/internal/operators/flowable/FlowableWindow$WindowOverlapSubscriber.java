/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.UnicastProcessor
 *  org.reactivestreams.Processor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableWindow.WindowOverlapSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription,
Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super Flowable<T>> downstream;
    Throwable error;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    long produced;
    final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
    final AtomicLong requested;
    final long size;
    final long skip;
    Subscription upstream;
    final ArrayDeque<UnicastProcessor<T>> windows;
    final AtomicInteger wip;

    FlowableWindow.WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long l, long l2, int n) {
        super(1);
        this.downstream = subscriber;
        this.size = l;
        this.skip = l2;
        this.queue = new SpscLinkedArrayQueue(n);
        this.windows = new ArrayDeque();
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.bufferSize = n;
    }

    public void cancel() {
        this.cancelled = true;
        if (!this.once.compareAndSet(false, true)) return;
        this.run();
    }

    boolean checkTerminated(boolean bl, boolean bl2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
        if (this.cancelled) {
            spscLinkedArrayQueue.clear();
            return true;
        }
        if (!bl) return false;
        Throwable throwable = this.error;
        if (throwable != null) {
            spscLinkedArrayQueue.clear();
            subscriber.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        subscriber.onComplete();
        return true;
    }

    void drain() {
        int n;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Subscriber<? super Flowable<T>> subscriber = this.downstream;
        SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.queue;
        int n2 = 1;
        do {
            long l;
            long l2 = this.requested.get();
            for (l = 0L; l != l2; ++l) {
                boolean bl = this.done;
                UnicastProcessor unicastProcessor = (UnicastProcessor)spscLinkedArrayQueue.poll();
                boolean bl2 = unicastProcessor == null;
                if (this.checkTerminated(bl, bl2, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (bl2) break;
                subscriber.onNext((Object)unicastProcessor);
            }
            if (l == l2 && this.checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (l != 0L && l2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-l);
            }
            n2 = n = this.wip.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<UnicastProcessor<T>> iterator = this.windows.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.windows.clear();
                this.done = true;
                this.drain();
                return;
            }
            ((Processor)iterator.next()).onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        Iterator<UnicastProcessor<T>> iterator = this.windows.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.windows.clear();
                this.error = throwable;
                this.done = true;
                this.drain();
                return;
            }
            ((Processor)iterator.next()).onError(throwable);
        }
    }

    public void onNext(T object) {
        UnicastProcessor unicastProcessor;
        if (this.done) {
            return;
        }
        long l = this.index;
        if (l == 0L && !this.cancelled) {
            this.getAndIncrement();
            unicastProcessor = UnicastProcessor.create((int)this.bufferSize, (Runnable)this);
            this.windows.offer(unicastProcessor);
            this.queue.offer((Object)unicastProcessor);
            this.drain();
        }
        ++l;
        unicastProcessor = this.windows.iterator();
        while (unicastProcessor.hasNext()) {
            ((Processor)unicastProcessor.next()).onNext(object);
        }
        long l2 = this.produced + 1L;
        if (l2 == this.size) {
            this.produced = l2 - this.skip;
            object = (Processor)this.windows.poll();
            if (object != null) {
                object.onComplete();
            }
        } else {
            this.produced = l2;
        }
        this.index = l == this.skip ? 0L : l;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
            l = BackpressureHelper.multiplyCap((long)this.skip, (long)(l - 1L));
            l = BackpressureHelper.addCap((long)this.size, (long)l);
            this.upstream.request(l);
        } else {
            l = BackpressureHelper.multiplyCap((long)this.skip, (long)l);
            this.upstream.request(l);
        }
        this.drain();
    }

    @Override
    public void run() {
        if (this.decrementAndGet() != 0) return;
        this.upstream.cancel();
    }
}
