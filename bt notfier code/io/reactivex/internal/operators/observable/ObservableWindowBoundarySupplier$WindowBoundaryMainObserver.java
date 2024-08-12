/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryInnerObserver
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWindowBoundarySupplier.WindowBoundaryMainObserver<T, B>
extends AtomicInteger
implements Observer<T>,
Disposable,
Runnable {
    static final ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<Object, Object> BOUNDARY_DISPOSED = new ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver(null);
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B>> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final Observer<? super Observable<T>> downstream;
    final AtomicThrowable errors;
    final Callable<? extends ObservableSource<B>> other;
    final MpscLinkedQueue<Object> queue;
    final AtomicBoolean stopWindows;
    Disposable upstream;
    UnicastSubject<T> window;
    final AtomicInteger windows;

    ObservableWindowBoundarySupplier.WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int n, Callable<? extends ObservableSource<B>> callable) {
        this.downstream = observer;
        this.capacityHint = n;
        this.boundaryObserver = new AtomicReference();
        this.windows = new AtomicInteger(1);
        this.queue = new MpscLinkedQueue();
        this.errors = new AtomicThrowable();
        this.stopWindows = new AtomicBoolean();
        this.other = callable;
    }

    public void dispose() {
        if (!this.stopWindows.compareAndSet(false, true)) return;
        this.disposeBoundary();
        if (this.windows.decrementAndGet() != 0) return;
        this.upstream.dispose();
    }

    void disposeBoundary() {
        Disposable disposable = (Disposable)this.boundaryObserver.getAndSet(BOUNDARY_DISPOSED);
        if (disposable == null) return;
        if (disposable == BOUNDARY_DISPOSED) return;
        disposable.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        Observer<? super Observable<T>> observer = this.downstream;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int n = 1;
        while (true) {
            ObservableSource observableSource;
            if (this.windows.get() == 0) {
                object.clear();
                this.window = null;
                return;
            }
            ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver windowBoundaryInnerObserver = this.window;
            boolean bl = this.done;
            if (bl && atomicThrowable.get() != null) {
                object.clear();
                object = atomicThrowable.terminate();
                if (windowBoundaryInnerObserver != null) {
                    this.window = null;
                    windowBoundaryInnerObserver.onError(object);
                }
                observer.onError(object);
                return;
            }
            Object object2 = object.poll();
            int n2 = object2 == null ? 1 : 0;
            if (bl && n2 != 0) {
                object = atomicThrowable.terminate();
                if (object == null) {
                    if (windowBoundaryInnerObserver != null) {
                        this.window = null;
                        windowBoundaryInnerObserver.onComplete();
                    }
                    observer.onComplete();
                } else {
                    if (windowBoundaryInnerObserver != null) {
                        this.window = null;
                        windowBoundaryInnerObserver.onError(object);
                    }
                    observer.onError(object);
                }
                return;
            }
            if (n2 != 0) {
                n = n2 = this.addAndGet(-n);
                if (n2 != 0) continue;
                return;
            }
            if (object2 != NEXT_WINDOW) {
                windowBoundaryInnerObserver.onNext(object2);
                continue;
            }
            if (windowBoundaryInnerObserver != null) {
                this.window = null;
                windowBoundaryInnerObserver.onComplete();
            }
            if (this.stopWindows.get()) continue;
            object2 = UnicastSubject.create((int)this.capacityHint, (Runnable)this);
            this.window = object2;
            this.windows.getAndIncrement();
            try {
                observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.other.call(), (String)"The other Callable returned a null ObservableSource");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                atomicThrowable.addThrowable(throwable);
                this.done = true;
                continue;
            }
            windowBoundaryInnerObserver = new ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver(this);
            if (!this.boundaryObserver.compareAndSet(null, windowBoundaryInnerObserver)) continue;
            observableSource.subscribe((Observer)windowBoundaryInnerObserver);
            observer.onNext(object2);
        }
    }

    void innerComplete() {
        this.upstream.dispose();
        this.done = true;
        this.drain();
    }

    void innerError(Throwable throwable) {
        this.upstream.dispose();
        if (this.errors.addThrowable(throwable)) {
            this.done = true;
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void innerNext(ObservableWindowBoundarySupplier.WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
        this.boundaryObserver.compareAndSet(windowBoundaryInnerObserver, null);
        this.queue.offer(NEXT_WINDOW);
        this.drain();
    }

    public boolean isDisposed() {
        return this.stopWindows.get();
    }

    public void onComplete() {
        this.disposeBoundary();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.disposeBoundary();
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
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
        this.queue.offer(NEXT_WINDOW);
        this.drain();
    }

    @Override
    public void run() {
        if (this.windows.decrementAndGet() != 0) return;
        this.upstream.dispose();
    }
}
