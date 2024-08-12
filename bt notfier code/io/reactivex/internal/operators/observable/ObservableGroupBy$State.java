/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableGroupBy.State<T, K>
extends AtomicInteger
implements Disposable,
ObservableSource<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Observer<? super T>> actual;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once = new AtomicBoolean();
    final ObservableGroupBy.GroupByObserver<?, K, T> parent;
    final SpscLinkedArrayQueue<T> queue;

    ObservableGroupBy.State(int n, ObservableGroupBy.GroupByObserver<?, K, T> groupByObserver, K k, boolean bl) {
        this.actual = new AtomicReference();
        this.queue = new SpscLinkedArrayQueue(n);
        this.parent = groupByObserver;
        this.key = k;
        this.delayError = bl;
    }

    boolean checkTerminated(boolean bl, boolean bl2, Observer<? super T> observer, boolean bl3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        }
        if (!bl) return false;
        if (bl3) {
            if (!bl2) return false;
            Throwable throwable = this.error;
            this.actual.lazySet(null);
            if (throwable != null) {
                observer.onError(throwable);
            } else {
                observer.onComplete();
            }
            return true;
        }
        Throwable throwable = this.error;
        if (throwable != null) {
            this.queue.clear();
            this.actual.lazySet(null);
            observer.onError(throwable);
            return true;
        }
        if (!bl2) return false;
        this.actual.lazySet(null);
        observer.onComplete();
        return true;
    }

    public void dispose() {
        if (!this.cancelled.compareAndSet(false, true)) return;
        if (this.getAndIncrement() != 0) return;
        this.actual.lazySet(null);
        this.parent.cancel(this.key);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean bl = this.delayError;
        Observer<? super T> observer = this.actual.get();
        int n = 1;
        while (true) {
            int n2;
            if (observer != null) {
                while (true) {
                    Object object;
                    boolean bl2;
                    boolean bl3;
                    if (this.checkTerminated(bl3 = this.done, bl2 = (object = spscLinkedArrayQueue.poll()) == null, observer, bl)) {
                        return;
                    }
                    if (bl2) break;
                    observer.onNext(object);
                }
            }
            if ((n2 = this.addAndGet(-n)) == 0) {
                return;
            }
            n = n2;
            if (observer != null) continue;
            observer = this.actual.get();
            n = n2;
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
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
        this.queue.offer(t);
        this.drain();
    }

    public void subscribe(Observer<? super T> observer) {
        if (this.once.compareAndSet(false, true)) {
            observer.onSubscribe((Disposable)this);
            this.actual.lazySet(observer);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                this.drain();
            }
        } else {
            EmptyDisposable.error((Throwable)new IllegalStateException("Only one Observer allowed!"), observer);
        }
    }
}
