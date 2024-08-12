/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

static final class FlowableCreate.LatestAsyncEmitter<T>
extends FlowableCreate.BaseEmitter<T> {
    private static final long serialVersionUID = 4023437720691792495L;
    volatile boolean done;
    Throwable error;
    final AtomicReference<T> queue = new AtomicReference();
    final AtomicInteger wip = new AtomicInteger();

    FlowableCreate.LatestAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    void drain() {
        int n;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = this.downstream;
        AtomicReference<T> atomicReference = this.queue;
        int n2 = 1;
        do {
            Throwable throwable;
            boolean bl;
            int n3;
            long l = this.get();
            long l2 = 0L;
            while (true) {
                n3 = 0;
                if (l2 == l) break;
                if (this.isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                }
                bl = this.done;
                throwable = atomicReference.getAndSet(null);
                n = throwable == null ? 1 : 0;
                if (bl && n != 0) {
                    throwable = this.error;
                    if (throwable != null) {
                        this.error(throwable);
                    } else {
                        this.complete();
                    }
                    return;
                }
                if (n != 0) break;
                subscriber.onNext((Object)throwable);
                ++l2;
            }
            if (l2 == l) {
                if (this.isCancelled()) {
                    atomicReference.lazySet(null);
                    return;
                }
                bl = this.done;
                n = n3;
                if (atomicReference.get() == null) {
                    n = 1;
                }
                if (bl && n != 0) {
                    throwable = this.error;
                    if (throwable != null) {
                        this.error(throwable);
                    } else {
                        this.complete();
                    }
                    return;
                }
            }
            if (l2 != 0L) {
                BackpressureHelper.produced((AtomicLong)((Object)this), (long)l2);
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
        this.queue.set(t);
        this.drain();
    }

    void onRequested() {
        this.drain();
    }

    void onUnsubscribed() {
        if (this.wip.getAndIncrement() != 0) return;
        this.queue.lazySet(null);
    }

    public boolean tryOnError(Throwable throwable) {
        if (this.done) return false;
        if (this.isCancelled()) {
            return false;
        }
        if (throwable == null) {
            this.onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
        this.error = throwable;
        this.done = true;
        this.drain();
        return true;
    }
}
