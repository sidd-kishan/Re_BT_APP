/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

static final class FlowableCreate.BufferAsyncEmitter<T>
extends FlowableCreate.BaseEmitter<T> {
    private static final long serialVersionUID = 2427151001689639875L;
    volatile boolean done;
    Throwable error;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicInteger wip;

    FlowableCreate.BufferAsyncEmitter(Subscriber<? super T> subscriber, int n) {
        super(subscriber);
        this.queue = new SpscLinkedArrayQueue(n);
        this.wip = new AtomicInteger();
    }

    void drain() {
        int n;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.downstream;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        int n2 = 1;
        do {
            Object object;
            boolean bl;
            long l;
            long l2 = this.get();
            for (l = 0L; l != l2; ++l) {
                if (this.isCancelled()) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                bl = this.done;
                object = spscLinkedArrayQueue.poll();
                n = object == null ? 1 : 0;
                if (bl && n != 0) {
                    object = this.error;
                    if (object != null) {
                        this.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
                if (n != 0) break;
                subscriber.onNext(object);
            }
            if (l == l2) {
                if (this.isCancelled()) {
                    spscLinkedArrayQueue.clear();
                    return;
                }
                bl = this.done;
                boolean bl2 = spscLinkedArrayQueue.isEmpty();
                if (bl && bl2) {
                    object = this.error;
                    if (object != null) {
                        this.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
            }
            if (l != 0L) {
                BackpressureHelper.produced((AtomicLong)((Object)this), (long)l);
            }
            n2 = n = this.wip.addAndGet(-n2);
        } while (n != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onNext(T t) {
        if (this.done) return;
        if (this.isCancelled()) return;
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.queue.offer(t);
        this.drain();
    }

    void onRequested() {
        this.drain();
    }

    void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    public boolean tryOnError(Throwable throwable) {
        if (this.done) return false;
        if (this.isCancelled()) {
            return false;
        }
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.error = throwable2;
        this.done = true;
        this.drain();
        return true;
    }
}
