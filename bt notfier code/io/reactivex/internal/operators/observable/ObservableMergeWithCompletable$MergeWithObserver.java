/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableMergeWithCompletable$MergeWithObserver$OtherObserver
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableMergeWithCompletable.MergeWithObserver<T>
extends AtomicInteger
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = -4592979584110982903L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final OtherObserver otherObserver;

    ObservableMergeWithCompletable.MergeWithObserver(Observer<? super T> observer) {
        this.downstream = observer;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose((AtomicReference)this.otherObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        if (!this.otherDone) return;
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.mainDisposable);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.mainDisposable, (Disposable)disposable);
    }

    void otherComplete() {
        this.otherDone = true;
        if (!this.mainDone) return;
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void otherError(Throwable throwable) {
        DisposableHelper.dispose(this.mainDisposable);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }
}
