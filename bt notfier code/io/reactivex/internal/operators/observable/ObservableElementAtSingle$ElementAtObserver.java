/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

static final class ObservableElementAtSingle.ElementAtObserver<T>
implements Observer<T>,
Disposable {
    long count;
    final T defaultValue;
    boolean done;
    final SingleObserver<? super T> downstream;
    final long index;
    Disposable upstream;

    ObservableElementAtSingle.ElementAtObserver(SingleObserver<? super T> singleObserver, long l, T t) {
        this.downstream = singleObserver;
        this.index = l;
        this.defaultValue = t;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        T t = this.defaultValue;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onError((Throwable)new NoSuchElementException());
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long l = this.count;
        if (l == this.index) {
            this.done = true;
            this.upstream.dispose();
            this.downstream.onSuccess(t);
            return;
        }
        this.count = l + 1L;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
