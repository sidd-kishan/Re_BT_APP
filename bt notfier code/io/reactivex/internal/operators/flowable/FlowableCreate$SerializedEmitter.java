/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableEmitter
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class FlowableCreate.SerializedEmitter<T>
extends AtomicInteger
implements FlowableEmitter<T> {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final FlowableCreate.BaseEmitter<T> emitter;
    final AtomicThrowable error;
    final SimplePlainQueue<T> queue;

    FlowableCreate.SerializedEmitter(FlowableCreate.BaseEmitter<T> baseEmitter) {
        this.emitter = baseEmitter;
        this.error = new AtomicThrowable();
        this.queue = new SpscLinkedArrayQueue(16);
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        FlowableCreate.BaseEmitter<T> baseEmitter = this.emitter;
        SimplePlainQueue<T> simplePlainQueue = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int n = 1;
        while (true) {
            if (baseEmitter.isCancelled()) {
                simplePlainQueue.clear();
                return;
            }
            if (atomicThrowable.get() != null) {
                simplePlainQueue.clear();
                baseEmitter.onError(atomicThrowable.terminate());
                return;
            }
            boolean bl = this.done;
            Object object = simplePlainQueue.poll();
            int n2 = object == null ? 1 : 0;
            if (bl && n2 != 0) {
                baseEmitter.onComplete();
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            baseEmitter.onNext(object);
        }
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    public void onComplete() {
        if (this.emitter.isCancelled()) return;
        if (this.done) return;
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.tryOnError(throwable)) return;
        RxJavaPlugins.onError((Throwable)throwable);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onNext(T t) {
        if (this.emitter.isCancelled()) return;
        if (this.done) {
            return;
        }
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.get() == 0 && this.compareAndSet(0, 1)) {
            this.emitter.onNext(t);
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            // MONITORENTER : simplePlainQueue
            simplePlainQueue.offer(t);
            // MONITOREXIT : simplePlainQueue
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public long requested() {
        return this.emitter.requested();
    }

    public FlowableEmitter<T> serialize() {
        return this;
    }

    public void setCancellable(Cancellable cancellable) {
        this.emitter.setCancellable(cancellable);
    }

    public void setDisposable(Disposable disposable) {
        this.emitter.setDisposable(disposable);
    }

    @Override
    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable throwable) {
        if (this.emitter.isCancelled()) return false;
        if (this.done) {
            return false;
        }
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.error.addThrowable(throwable2)) return false;
        this.done = true;
        this.drain();
        return true;
    }
}
