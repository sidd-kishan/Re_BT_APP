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
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeoutTimed.FallbackObserver<T>
implements Observer<T> {
    final AtomicReference<Disposable> arbiter;
    final Observer<? super T> downstream;

    ObservableTimeoutTimed.FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
        this.downstream = observer;
        this.arbiter = atomicReference;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.arbiter, (Disposable)disposable);
    }
}
