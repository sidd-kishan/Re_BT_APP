/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowExactBoundedObserver$ConsumerIndexHolder
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
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWindowTimed.WindowExactBoundedObserver<T>
extends QueueDrainObserver<T, Object, Observable<T>>
implements Disposable {
    final int bufferSize;
    long count;
    final long maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    UnicastSubject<T> window;
    final Scheduler.Worker worker;

    ObservableWindowTimed.WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long l, TimeUnit timeUnit, Scheduler scheduler, int n, long l2, boolean bl) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.maxSize = l2;
        this.restartTimerOnMaxSize = bl;
        this.worker = bl ? scheduler.createWorker() : null;
    }

    static /* synthetic */ boolean access$000(ObservableWindowTimed.WindowExactBoundedObserver windowExactBoundedObserver) {
        return windowExactBoundedObserver.cancelled;
    }

    static /* synthetic */ SimplePlainQueue access$100(ObservableWindowTimed.WindowExactBoundedObserver windowExactBoundedObserver) {
        return windowExactBoundedObserver.queue;
    }

    public void dispose() {
        this.cancelled = true;
    }

    void disposeTimer() {
        DisposableHelper.dispose(this.timer);
        Scheduler.Worker worker = this.worker;
        if (worker == null) return;
        worker.dispose();
    }

    void drainLoop() {
        MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue)this.queue;
        Observer observer = this.downstream;
        Object object = this.window;
        int n = 1;
        while (true) {
            if (this.terminated) {
                this.upstream.dispose();
                mpscLinkedQueue.clear();
                this.disposeTimer();
                return;
            }
            boolean bl = this.done;
            Object object2 = mpscLinkedQueue.poll();
            int n2 = object2 == null ? 1 : 0;
            boolean bl2 = object2 instanceof ConsumerIndexHolder;
            if (bl && (n2 != 0 || bl2)) {
                this.window = null;
                mpscLinkedQueue.clear();
                this.disposeTimer();
                object2 = this.error;
                if (object2 != null) {
                    object.onError((Throwable)object2);
                } else {
                    object.onComplete();
                }
                return;
            }
            if (n2 != 0) {
                n = n2 = this.leave(-n);
                if (n2 != 0) continue;
                return;
            }
            if (bl2) {
                object2 = (ConsumerIndexHolder)object2;
                if (!this.restartTimerOnMaxSize && this.producerIndex != ((ConsumerIndexHolder)object2).index) continue;
                object.onComplete();
                this.count = 0L;
                this.window = object = UnicastSubject.create((int)this.bufferSize);
                observer.onNext(object);
                continue;
            }
            object.onNext(NotificationLite.getValue((Object)object2));
            long l = this.count + 1L;
            if (l >= this.maxSize) {
                ++this.producerIndex;
                this.count = 0L;
                object.onComplete();
                object2 = UnicastSubject.create((int)this.bufferSize);
                this.window = object2;
                this.downstream.onNext(object2);
                object = object2;
                if (!this.restartTimerOnMaxSize) continue;
                Disposable disposable = this.timer.get();
                disposable.dispose();
                Scheduler.Worker worker = this.worker;
                object = new ConsumerIndexHolder(this.producerIndex, this);
                l = this.timespan;
                worker = worker.schedulePeriodically((Runnable)object, l, l, this.unit);
                object = object2;
                if (this.timer.compareAndSet(disposable, (Disposable)worker)) continue;
                worker.dispose();
                object = object2;
                continue;
            }
            this.count = l;
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
        this.downstream.onComplete();
        this.disposeTimer();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.downstream.onError(throwable);
        this.disposeTimer();
    }

    public void onNext(T object) {
        if (this.terminated) {
            return;
        }
        if (this.fastEnter()) {
            ConsumerIndexHolder consumerIndexHolder = this.window;
            consumerIndexHolder.onNext(object);
            long l = this.count + 1L;
            if (l >= this.maxSize) {
                ++this.producerIndex;
                this.count = 0L;
                consumerIndexHolder.onComplete();
                object = UnicastSubject.create((int)this.bufferSize);
                this.window = object;
                this.downstream.onNext(object);
                if (this.restartTimerOnMaxSize) {
                    this.timer.get().dispose();
                    object = this.worker;
                    consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                    l = this.timespan;
                    object = object.schedulePeriodically((Runnable)consumerIndexHolder, l, l, this.unit);
                    DisposableHelper.replace(this.timer, object);
                }
            } else {
                this.count = l;
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(NotificationLite.next(object));
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Disposable disposable) {
        UnicastSubject unicastSubject;
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        disposable = this.downstream;
        disposable.onSubscribe((Disposable)this);
        if (this.cancelled) {
            return;
        }
        this.window = unicastSubject = UnicastSubject.create((int)this.bufferSize);
        disposable.onNext((Object)unicastSubject);
        disposable = new ConsumerIndexHolder(this.producerIndex, this);
        if (this.restartTimerOnMaxSize) {
            unicastSubject = this.worker;
            long l = this.timespan;
            disposable = unicastSubject.schedulePeriodically((Runnable)disposable, l, l, this.unit);
        } else {
            unicastSubject = this.scheduler;
            long l = this.timespan;
            disposable = unicastSubject.schedulePeriodicallyDirect((Runnable)disposable, l, l, this.unit);
        }
        DisposableHelper.replace(this.timer, (Disposable)disposable);
    }
}
