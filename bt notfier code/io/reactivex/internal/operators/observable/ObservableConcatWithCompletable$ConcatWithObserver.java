/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatWithCompletable.ConcatWithObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
CompletableObserver,
Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;

    ObservableConcatWithCompletable.ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
        this.downstream = observer;
        this.other = completableSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.inCompletable) {
            this.downstream.onComplete();
        } else {
            this.inCompletable = true;
            DisposableHelper.replace((AtomicReference)this, null);
            CompletableSource completableSource = this.other;
            this.other = null;
            completableSource.subscribe((CompletableObserver)this);
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
        if (this.inCompletable) return;
        this.downstream.onSubscribe((Disposable)this);
    }
}
