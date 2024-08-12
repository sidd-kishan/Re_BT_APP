/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableEmitter
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.internal.disposables.CancellableDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableCreate$SerializedEmitter
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableCreate.CreateEmitter<T>
extends AtomicReference<Disposable>
implements ObservableEmitter<T>,
Disposable {
    private static final long serialVersionUID = -3434801548987643227L;
    final Observer<? super T> observer;

    ObservableCreate.CreateEmitter(Observer<? super T> observer) {
        this.observer = observer;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.isDisposed()) return;
        try {
            this.observer.onComplete();
        }
        finally {
            this.dispose();
        }
    }

    public void onError(Throwable throwable) {
        if (this.tryOnError(throwable)) return;
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.isDisposed()) return;
        this.observer.onNext(t);
    }

    public ObservableEmitter<T> serialize() {
        return new ObservableCreate.SerializedEmitter((ObservableEmitter)this);
    }

    public void setCancellable(Cancellable cancellable) {
        this.setDisposable((Disposable)new CancellableDisposable(cancellable));
    }

    public void setDisposable(Disposable disposable) {
        DisposableHelper.set((AtomicReference)this, (Disposable)disposable);
    }

    @Override
    public String toString() {
        return String.format("%s{%s}", this.getClass().getSimpleName(), super.toString());
    }

    public boolean tryOnError(Throwable throwable) {
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.isDisposed()) return false;
        try {
            this.observer.onError(throwable2);
            return true;
        }
        finally {
            this.dispose();
        }
    }
}
