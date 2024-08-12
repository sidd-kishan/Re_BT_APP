/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableTakeLastOne.TakeLastOneObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    Disposable upstream;
    T value;

    ObservableTakeLastOne.TakeLastOneObserver(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.value = null;
        this.upstream.dispose();
    }

    void emit() {
        T t = this.value;
        if (t != null) {
            this.value = null;
            this.downstream.onNext(t);
        }
        this.downstream.onComplete();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.emit();
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.value = t;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
