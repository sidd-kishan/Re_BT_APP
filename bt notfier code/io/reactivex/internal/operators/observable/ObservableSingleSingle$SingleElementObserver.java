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

static final class ObservableSingleSingle.SingleElementObserver<T>
implements Observer<T>,
Disposable {
    final T defaultValue;
    boolean done;
    final SingleObserver<? super T> downstream;
    Disposable upstream;
    T value;

    ObservableSingleSingle.SingleElementObserver(SingleObserver<? super T> singleObserver, T t) {
        this.downstream = singleObserver;
        this.defaultValue = t;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        T t = this.value;
        this.value = null;
        T t2 = t;
        if (t == null) {
            t2 = this.defaultValue;
        }
        if (t2 != null) {
            this.downstream.onSuccess(t2);
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
        if (this.value != null) {
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError((Throwable)new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
