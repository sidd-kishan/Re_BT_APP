/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableTakeUntil$TakeUntilMainObserver$OtherObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTakeUntil.TakeUntilMainObserver<T, U>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 1418547743690811973L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final OtherObserver otherObserver;
    final AtomicReference<Disposable> upstream;

    ObservableTakeUntil.TakeUntilMainObserver(Observer<? super T> observer) {
        this.downstream = observer;
        this.upstream = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this.otherObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose((AtomicReference)this.otherObserver);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose((AtomicReference)this.otherObserver);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }
}
