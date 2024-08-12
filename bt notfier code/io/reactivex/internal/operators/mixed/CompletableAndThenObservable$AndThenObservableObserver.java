/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableAndThenObservable.AndThenObservableObserver<R>
extends AtomicReference<Disposable>
implements Observer<R>,
CompletableObserver,
Disposable {
    private static final long serialVersionUID = -8948264376121066672L;
    final Observer<? super R> downstream;
    ObservableSource<? extends R> other;

    CompletableAndThenObservable.AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
        this.other = observableSource;
        this.downstream = observer;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        ObservableSource<? extends R> observableSource = this.other;
        if (observableSource == null) {
            this.downstream.onComplete();
        } else {
            this.other = null;
            observableSource.subscribe((Observer)this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
