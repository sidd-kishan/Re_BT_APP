/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R>
implements Observer<T>,
QueueDisposable<R> {
    protected boolean done;
    protected final Observer<? super R> downstream;
    protected QueueDisposable<T> qd;
    protected int sourceMode;
    protected Disposable upstream;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    protected void afterDownstream() {
    }

    protected boolean beforeDownstream() {
        return true;
    }

    public void clear() {
        this.qd.clear();
    }

    public void dispose() {
        this.upstream.dispose();
    }

    protected final void fail(Throwable throwable) {
        Exceptions.throwIfFatal((Throwable)throwable);
        this.upstream.dispose();
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public final void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        if (disposable instanceof QueueDisposable) {
            this.qd = (QueueDisposable)disposable;
        }
        if (!this.beforeDownstream()) return;
        this.downstream.onSubscribe((Disposable)this);
        this.afterDownstream();
    }

    protected final int transitiveBoundaryFusion(int n) {
        QueueDisposable<T> queueDisposable = this.qd;
        if (queueDisposable == null) return 0;
        if ((n & 4) != 0) return 0;
        if ((n = queueDisposable.requestFusion(n)) == 0) return n;
        this.sourceMode = n;
        return n;
    }
}
