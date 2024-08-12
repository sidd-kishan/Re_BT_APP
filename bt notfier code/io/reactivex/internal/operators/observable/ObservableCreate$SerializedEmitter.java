/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableEmitter
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableCreate.SerializedEmitter<T>
extends AtomicInteger
implements ObservableEmitter<T> {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final ObservableEmitter<T> emitter;
    final AtomicThrowable error;
    final SpscLinkedArrayQueue<T> queue;

    ObservableCreate.SerializedEmitter(ObservableEmitter<T> observableEmitter) {
        this.emitter = observableEmitter;
        this.error = new AtomicThrowable();
        this.queue = new SpscLinkedArrayQueue(16);
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        ObservableEmitter<T> observableEmitter = this.emitter;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int n = 1;
        while (true) {
            if (observableEmitter.isDisposed()) {
                spscLinkedArrayQueue.clear();
                return;
            }
            if (atomicThrowable.get() != null) {
                spscLinkedArrayQueue.clear();
                observableEmitter.onError(atomicThrowable.terminate());
                return;
            }
            boolean bl = this.done;
            Object object = spscLinkedArrayQueue.poll();
            int n2 = object == null ? 1 : 0;
            if (bl && n2 != 0) {
                observableEmitter.onComplete();
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            observableEmitter.onNext(object);
        }
    }

    public boolean isDisposed() {
        return this.emitter.isDisposed();
    }

    public void onComplete() {
        if (this.emitter.isDisposed()) return;
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
        if (this.emitter.isDisposed()) return;
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
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            // MONITORENTER : spscLinkedArrayQueue
            spscLinkedArrayQueue.offer(t);
            // MONITOREXIT : spscLinkedArrayQueue
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public ObservableEmitter<T> serialize() {
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
        if (this.emitter.isDisposed()) return false;
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
