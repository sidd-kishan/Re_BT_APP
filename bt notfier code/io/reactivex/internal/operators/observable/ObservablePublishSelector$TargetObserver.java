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

static final class ObservablePublishSelector.TargetObserver<T, R>
extends AtomicReference<Disposable>
implements Observer<R>,
Disposable {
    private static final long serialVersionUID = 854110278590336484L;
    final Observer<? super R> downstream;
    Disposable upstream;

    ObservablePublishSelector.TargetObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        DisposableHelper.dispose((AtomicReference)this);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose((AtomicReference)this);
        this.downstream.onError(throwable);
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
