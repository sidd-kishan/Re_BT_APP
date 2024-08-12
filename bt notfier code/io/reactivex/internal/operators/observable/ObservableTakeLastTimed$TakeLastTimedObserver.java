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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableTakeLastTimed.TakeLastTimedObserver<T>
extends AtomicBoolean
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -5677354903406201275L;
    volatile boolean cancelled;
    final long count;
    final boolean delayError;
    final Observer<? super T> downstream;
    Throwable error;
    final SpscLinkedArrayQueue<Object> queue;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;
    Disposable upstream;

    ObservableTakeLastTimed.TakeLastTimedObserver(Observer<? super T> observer, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        this.downstream = observer;
        this.count = l;
        this.time = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.queue = new SpscLinkedArrayQueue(n);
        this.delayError = bl;
    }

    public void dispose() {
        if (this.cancelled) return;
        this.cancelled = true;
        this.upstream.dispose();
        if (!this.compareAndSet(false, true)) return;
        this.queue.clear();
    }

    void drain() {
        if (!this.compareAndSet(false, true)) {
            return;
        }
        Observer<? super T> observer = this.downstream;
        Object object = this.queue;
        boolean bl = this.delayError;
        while (true) {
            Object object2;
            if (this.cancelled) {
                object.clear();
                return;
            }
            if (!bl && (object2 = this.error) != null) {
                object.clear();
                observer.onError((Throwable)object2);
                return;
            }
            Object object3 = object.poll();
            boolean bl2 = object3 == null;
            if (bl2) {
                object = this.error;
                if (object != null) {
                    observer.onError(object);
                } else {
                    observer.onComplete();
                }
                return;
            }
            object2 = object.poll();
            if ((Long)object3 < this.scheduler.now(this.unit) - this.time) continue;
            observer.onNext(object2);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.drain();
    }

    public void onNext(T t) {
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        long l = this.scheduler.now(this.unit);
        long l2 = this.time;
        long l3 = this.count;
        boolean bl = l3 == Long.MAX_VALUE;
        spscLinkedArrayQueue.offer((Object)l, t);
        while (!spscLinkedArrayQueue.isEmpty()) {
            if ((Long)spscLinkedArrayQueue.peek() > l - l2) {
                if (bl) return;
                if ((long)(spscLinkedArrayQueue.size() >> 1) <= l3) return;
            }
            spscLinkedArrayQueue.poll();
            spscLinkedArrayQueue.poll();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
