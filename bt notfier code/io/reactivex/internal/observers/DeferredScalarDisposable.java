/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T>
extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final Observer<? super T> downstream;
    protected T value;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public final void clear() {
        this.lazySet(32);
        this.value = null;
    }

    public final void complete() {
        if ((this.get() & 0x36) != 0) {
            return;
        }
        this.lazySet(2);
        this.downstream.onComplete();
    }

    public final void complete(T t) {
        int n = this.get();
        if ((n & 0x36) != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream;
        if (n == 8) {
            this.value = t;
            this.lazySet(16);
            observer.onNext(null);
        } else {
            this.lazySet(2);
            observer.onNext(t);
        }
        if (this.get() == 4) return;
        observer.onComplete();
    }

    public void dispose() {
        this.set(4);
        this.value = null;
    }

    public final void error(Throwable throwable) {
        if ((this.get() & 0x36) != 0) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.lazySet(2);
        this.downstream.onError(throwable);
    }

    public final boolean isDisposed() {
        boolean bl = this.get() == 4;
        return bl;
    }

    public final boolean isEmpty() {
        boolean bl = this.get() != 16;
        return bl;
    }

    public final T poll() throws Exception {
        if (this.get() != 16) return null;
        T t = this.value;
        this.value = null;
        this.lazySet(32);
        return t;
    }

    public final int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        boolean bl = this.getAndSet(4) != 4;
        return bl;
    }
}
