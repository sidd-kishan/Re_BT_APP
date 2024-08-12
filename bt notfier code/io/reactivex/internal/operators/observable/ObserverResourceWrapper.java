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

public final class ObserverResourceWrapper<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream = new AtomicReference();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.upstream.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce(this.upstream, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set((AtomicReference)this, (Disposable)disposable);
    }
}
