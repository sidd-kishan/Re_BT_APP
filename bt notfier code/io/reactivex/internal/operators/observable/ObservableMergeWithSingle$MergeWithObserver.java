/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.observable.ObservableMergeWithSingle$MergeWithObserver$OtherObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableMergeWithSingle.MergeWithObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    volatile SimplePlainQueue<T> queue;
    T singleItem;

    ObservableMergeWithSingle.MergeWithObserver(Observer<? super T> observer) {
        this.downstream = observer;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
        if (this.getAndIncrement() != 0) return;
        this.queue = null;
        this.singleItem = null;
    }

    void drain() {
        if (this.getAndIncrement() != 0) return;
        this.drainLoop();
    }

    void drainLoop() {
        Observer<? super T> observer = this.downstream;
        int n = 1;
        while (true) {
            Object object;
            int n2;
            if (this.disposed) {
                this.singleItem = null;
                this.queue = null;
                return;
            }
            if (this.error.get() != null) {
                this.singleItem = null;
                this.queue = null;
                observer.onError(this.error.terminate());
                return;
            }
            int n3 = n2 = this.otherState;
            if (n2 == 1) {
                object = this.singleItem;
                this.singleItem = null;
                this.otherState = 2;
                observer.onNext(object);
                n3 = 2;
            }
            boolean bl = this.mainDone;
            object = this.queue;
            object = object != null ? object.poll() : null;
            n2 = object == null ? 1 : 0;
            if (bl && n2 != 0 && n3 == 2) {
                this.queue = null;
                observer.onComplete();
                return;
            }
            if (n2 != 0) {
                n = n3 = this.addAndGet(-n);
                if (n3 != 0) continue;
                return;
            }
            observer.onNext(object);
        }
    }

    SimplePlainQueue<T> getOrCreateQueue() {
        SpscLinkedArrayQueue spscLinkedArrayQueue;
        SpscLinkedArrayQueue spscLinkedArrayQueue2 = spscLinkedArrayQueue = this.queue;
        if (spscLinkedArrayQueue != null) return spscLinkedArrayQueue2;
        this.queue = spscLinkedArrayQueue2 = new SpscLinkedArrayQueue(Observable.bufferSize());
        return spscLinkedArrayQueue2;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            DisposableHelper.dispose(this.mainDisposable);
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.compareAndSet(0, 1)) {
            this.downstream.onNext(t);
            if (this.decrementAndGet() == 0) {
                return;
            }
        } else {
            this.getOrCreateQueue().offer(t);
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.mainDisposable, (Disposable)disposable);
    }

    void otherError(Throwable throwable) {
        if (this.error.addThrowable(throwable)) {
            DisposableHelper.dispose(this.mainDisposable);
            this.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void otherSuccess(T t) {
        if (this.compareAndSet(0, 1)) {
            this.downstream.onNext(t);
            this.otherState = 2;
        } else {
            this.singleItem = t;
            this.otherState = 1;
            if (this.getAndIncrement() != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}
