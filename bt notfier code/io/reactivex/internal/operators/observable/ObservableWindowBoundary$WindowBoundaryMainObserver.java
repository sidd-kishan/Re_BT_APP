/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundary$WindowBoundaryInnerObserver
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWindowBoundary.WindowBoundaryMainObserver<T, B>
extends AtomicInteger
implements Observer<T>,
Disposable,
Runnable {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final ObservableWindowBoundary.WindowBoundaryInnerObserver<T, B> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final Observer<? super Observable<T>> downstream;
    final AtomicThrowable errors;
    final MpscLinkedQueue<Object> queue;
    final AtomicBoolean stopWindows;
    final AtomicReference<Disposable> upstream;
    UnicastSubject<T> window;
    final AtomicInteger windows;

    ObservableWindowBoundary.WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int n) {
        this.downstream = observer;
        this.capacityHint = n;
        this.boundaryObserver = new ObservableWindowBoundary.WindowBoundaryInnerObserver(this);
        this.upstream = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
    }

    public void dispose() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        this.boundaryObserver.dispose();
        if (this.windows.decrementAndGet() != 0) return;
        DisposableHelper.dispose(this.upstream);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super Observable<T>> observer = this.downstream;
        MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
        Object object = this.errors;
        int n = 1;
        while (true) {
            if (this.windows.get() == 0) {
                mpscLinkedQueue.clear();
                this.window = null;
                return;
            }
            UnicastSubject unicastSubject = this.window;
            boolean bl = this.done;
            if (bl && object.get() != null) {
                mpscLinkedQueue.clear();
                object = object.terminate();
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onError((Throwable)object);
                }
                observer.onError((Throwable)object);
                return;
            }
            Object object2 = mpscLinkedQueue.poll();
            int n2 = object2 == null ? 1 : 0;
            if (bl && n2 != 0) {
                if ((object = object.terminate()) == null) {
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    observer.onComplete();
                } else {
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError((Throwable)object);
                    }
                    observer.onError((Throwable)object);
                }
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            if (object2 != NEXT_WINDOW) {
                unicastSubject.onNext(object2);
                continue;
            }
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            if (this.stopWindows.get()) continue;
            this.window = unicastSubject = UnicastSubject.create((int)this.capacityHint, (Runnable)this);
            this.windows.getAndIncrement();
            observer.onNext((Object)unicastSubject);
        }
    }

    void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        this.done = true;
        this.drain();
    }

    void innerError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerNext() {
        this.queue.offer(NEXT_WINDOW);
        this.drain();
    }

    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    public void onComplete() {
        this.boundaryObserver.dispose();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.boundaryObserver.dispose();
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.queue.offer(t);
        this.drain();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce(this.upstream, (Disposable)disposable)) return;
        this.innerNext();
    }

    @Override
    public void run() {
        if (this.windows.decrementAndGet() != 0) return;
        DisposableHelper.dispose(this.upstream);
    }
}
