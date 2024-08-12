/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatWithMaybe.ConcatWithObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inMaybe;
    MaybeSource<? extends T> other;

    ObservableConcatWithMaybe.ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
        this.downstream = observer;
        this.other = maybeSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.inMaybe) {
            this.downstream.onComplete();
        } else {
            this.inMaybe = true;
            DisposableHelper.replace((AtomicReference)this, null);
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.subscribe((MaybeObserver)this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        if (this.inMaybe) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onNext(t);
        this.downstream.onComplete();
    }
}
