/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWindowTimed.WindowExactUnboundedObserver<T>
extends QueueDrainObserver<T, Object, Observable<T>>
implements Observer<T>,
Disposable,
Runnable {
    static final Object NEXT = new Object();
    final int bufferSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    UnicastSubject<T> window;

    ObservableWindowTimed.WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
    }

    public void dispose() {
        this.cancelled = true;
    }

    void disposeTimer() {
        DisposableHelper.dispose(this.timer);
    }

    void drainLoop() {
        MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue)this.queue;
        Object object = this.downstream;
        UnicastSubject unicastSubject = this.window;
        int n = 1;
        while (true) {
            boolean bl = this.terminated;
            boolean bl2 = this.done;
            Object object2 = mpscLinkedQueue.poll();
            if (bl2 && (object2 == null || object2 == NEXT)) {
                this.window = null;
                mpscLinkedQueue.clear();
                this.disposeTimer();
                object = this.error;
                if (object != null) {
                    unicastSubject.onError((Throwable)object);
                    break;
                }
                unicastSubject.onComplete();
                break;
            }
            if (object2 == null) {
                int n2;
                n = n2 = this.leave(-n);
                if (n2 != 0) continue;
                return;
            }
            if (object2 == NEXT) {
                unicastSubject.onComplete();
                if (!bl) {
                    this.window = unicastSubject = UnicastSubject.create((int)this.bufferSize);
                    object.onNext((Object)unicastSubject);
                    continue;
                }
                this.upstream.dispose();
                continue;
            }
            unicastSubject.onNext(NotificationLite.getValue((Object)object2));
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.disposeTimer();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.disposeTimer();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.terminated) {
            return;
        }
        if (this.fastEnter()) {
            this.window.onNext(t);
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(t));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.window = UnicastSubject.create((int)this.bufferSize);
        disposable = this.downstream;
        disposable.onSubscribe((Disposable)this);
        disposable.onNext(this.window);
        if (this.cancelled) return;
        disposable = this.scheduler;
        long l = this.timespan;
        disposable = disposable.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit);
        DisposableHelper.replace(this.timer, (Disposable)disposable);
    }

    @Override
    public void run() {
        if (this.cancelled) {
            this.terminated = true;
            this.disposeTimer();
        }
        this.queue.offer(NEXT);
        if (!this.enter()) return;
        this.drainLoop();
    }
}
