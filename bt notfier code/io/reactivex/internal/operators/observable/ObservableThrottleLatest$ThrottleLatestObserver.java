/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableThrottleLatest.ThrottleLatestObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super T> downstream;
    final boolean emitLast;
    Throwable error;
    final AtomicReference<T> latest;
    final long timeout;
    volatile boolean timerFired;
    boolean timerRunning;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker worker;

    ObservableThrottleLatest.ThrottleLatestObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker, boolean bl) {
        this.downstream = observer;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.emitLast = bl;
        this.latest = new AtomicReference();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (this.getAndIncrement() != 0) return;
        this.latest.lazySet(null);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<T> atomicReference = this.latest;
        Observer<? super T> observer = this.downstream;
        int n = 1;
        while (true) {
            block13: {
                int n2;
                block12: {
                    block11: {
                        if (this.cancelled) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean bl = this.done;
                        if (bl && this.error != null) {
                            atomicReference.lazySet(null);
                            observer.onError(this.error);
                            this.worker.dispose();
                            return;
                        }
                        n2 = atomicReference.get() == null ? 1 : 0;
                        if (bl) {
                            atomicReference = atomicReference.getAndSet(null);
                            if (n2 == 0 && this.emitLast) {
                                observer.onNext(atomicReference);
                            }
                            observer.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (n2 == 0) break block11;
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                        break block12;
                    }
                    if (!this.timerRunning || this.timerFired) break block13;
                }
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            observer.onNext(atomicReference.getAndSet(null));
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.schedule((Runnable)this, this.timeout, this.unit);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(T t) {
        this.latest.set(t);
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        this.timerFired = true;
        this.drain();
    }
}
