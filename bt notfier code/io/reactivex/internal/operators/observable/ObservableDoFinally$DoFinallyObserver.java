/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueDisposable
 *  io.reactivex.internal.observers.BasicIntQueueDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableDoFinally.DoFinallyObserver<T>
extends BasicIntQueueDisposable<T>
implements Observer<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final Observer<? super T> downstream;
    final Action onFinally;
    QueueDisposable<T> qd;
    boolean syncFused;
    Disposable upstream;

    ObservableDoFinally.DoFinallyObserver(Observer<? super T> observer, Action action) {
        this.downstream = observer;
        this.onFinally = action;
    }

    public void clear() {
        this.qd.clear();
    }

    public void dispose() {
        this.upstream.dispose();
        this.runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return this.qd.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.runFinally();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        if (disposable instanceof QueueDisposable) {
            this.qd = (QueueDisposable)disposable;
        }
        this.downstream.onSubscribe((Disposable)this);
    }

    public T poll() throws Exception {
        Object object = this.qd.poll();
        if (object != null) return (T)object;
        if (!this.syncFused) return (T)object;
        this.runFinally();
        return (T)object;
    }

    public int requestFusion(int n) {
        QueueDisposable<T> queueDisposable = this.qd;
        boolean bl = false;
        if (queueDisposable == null) return 0;
        if ((n & 4) != 0) return 0;
        if ((n = queueDisposable.requestFusion(n)) == 0) return n;
        if (n == 1) {
            bl = true;
        }
        this.syncFused = bl;
        return n;
    }

    void runFinally() {
        if (!this.compareAndSet(0, 1)) return;
        try {
            this.onFinally.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
