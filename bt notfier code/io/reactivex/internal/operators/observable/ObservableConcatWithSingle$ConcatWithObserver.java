/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatWithSingle.ConcatWithObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inSingle;
    SingleSource<? extends T> other;

    ObservableConcatWithSingle.ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
        this.downstream = observer;
        this.other = singleSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.inSingle = true;
        DisposableHelper.replace((AtomicReference)this, null);
        SingleSource<? extends T> singleSource = this.other;
        this.other = null;
        singleSource.subscribe((SingleObserver)this);
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        if (this.inSingle) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onNext(t);
        this.downstream.onComplete();
    }
}
