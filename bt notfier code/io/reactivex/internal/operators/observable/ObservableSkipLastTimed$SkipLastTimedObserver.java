/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableSkipLastTimed.SkipLastTimedObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super T> downstream;
    Throwable error;
    final SpscLinkedArrayQueue<Object> queue;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    ObservableSkipLastTimed.SkipLastTimedObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        this.downstream = observer;
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.queue = new SpscLinkedArrayQueue(n);
        this.delayError = bl;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream;
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        Object object = this.unit;
        Scheduler scheduler = this.scheduler;
        long l = this.time;
        int n = 1;
        while (true) {
            if (this.cancelled) {
                this.queue.clear();
                return;
            }
            boolean bl2 = this.done;
            Serializable serializable = (Long)spscLinkedArrayQueue.peek();
            int n2 = serializable == null ? 1 : 0;
            long l2 = scheduler.now(object);
            int n3 = n2;
            if (n2 == 0) {
                n3 = n2;
                if (serializable > l2 - l) {
                    n3 = 1;
                }
            }
            if (bl2) {
                if (bl) {
                    if (n3 != 0) {
                        object = this.error;
                        if (object != null) {
                            observer.onError((Throwable)object);
                        } else {
                            observer.onComplete();
                        }
                        return;
                    }
                } else {
                    serializable = this.error;
                    if (serializable != null) {
                        this.queue.clear();
                        observer.onError((Throwable)serializable);
                        return;
                    }
                    if (n3 != 0) {
                        observer.onComplete();
                        return;
                    }
                }
            }
            if (n3 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            spscLinkedArrayQueue.poll();
            observer.onNext(spscLinkedArrayQueue.poll());
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
        this.queue.offer((Object)this.scheduler.now(this.unit), t);
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
