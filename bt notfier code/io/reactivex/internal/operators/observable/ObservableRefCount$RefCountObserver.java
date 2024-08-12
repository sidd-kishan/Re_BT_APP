/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableRefCount
 *  io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableRefCount.RefCountObserver<T>
extends AtomicBoolean
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -7419642935409022375L;
    final ObservableRefCount.RefConnection connection;
    final Observer<? super T> downstream;
    final ObservableRefCount<T> parent;
    Disposable upstream;

    ObservableRefCount.RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, ObservableRefCount.RefConnection refConnection) {
        this.downstream = observer;
        this.parent = observableRefCount;
        this.connection = refConnection;
    }

    public void dispose() {
        this.upstream.dispose();
        if (!this.compareAndSet(false, true)) return;
        this.parent.cancel(this.connection);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (!this.compareAndSet(false, true)) return;
        this.parent.terminated(this.connection);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.compareAndSet(false, true)) {
            this.parent.terminated(this.connection);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
