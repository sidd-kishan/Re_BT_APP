/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.fuseable.QueueDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public static final class ObservableScalarXMap.ScalarDisposable<T>
extends AtomicInteger
implements QueueDisposable<T>,
Runnable {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final Observer<? super T> observer;
    final T value;

    public ObservableScalarXMap.ScalarDisposable(Observer<? super T> observer, T t) {
        this.observer = observer;
        this.value = t;
    }

    public void clear() {
        this.lazySet(3);
    }

    public void dispose() {
        this.set(3);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == 3;
        return bl;
    }

    public boolean isEmpty() {
        int n = this.get();
        boolean bl = true;
        if (n != 1) return bl;
        bl = false;
        return bl;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() throws Exception {
        if (this.get() != 1) return null;
        this.lazySet(3);
        return this.value;
    }

    public int requestFusion(int n) {
        if ((n & 1) == 0) return 0;
        this.lazySet(1);
        return 1;
    }

    @Override
    public void run() {
        if (this.get() != 0) return;
        if (!this.compareAndSet(0, 2)) return;
        this.observer.onNext(this.value);
        if (this.get() != 2) return;
        this.lazySet(3);
        this.observer.onComplete();
    }
}
