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

static final class ObservableSubscribeOn.SubscribeOnObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 8094547886072529208L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream;

    ObservableSubscribeOn.SubscribeOnObserver(Observer<? super T> observer) {
        this.downstream = observer;
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
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
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    void setDisposable(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
