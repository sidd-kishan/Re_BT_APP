/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.ArrayCompositeDisposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableSkipUntil.SkipUntilObserver<T>
implements Observer<T> {
    final Observer<? super T> downstream;
    final ArrayCompositeDisposable frc;
    volatile boolean notSkipping;
    boolean notSkippingLocal;
    Disposable upstream;

    ObservableSkipUntil.SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.downstream = observer;
        this.frc = arrayCompositeDisposable;
    }

    public void onComplete() {
        this.frc.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.frc.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.notSkippingLocal) {
            this.downstream.onNext(t);
        } else {
            if (!this.notSkipping) return;
            this.notSkippingLocal = true;
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.frc.setResource(0, disposable);
    }
}
