/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatMap.SourceObserver.InnerObserver<U>
extends AtomicReference<Disposable>
implements Observer<U> {
    private static final long serialVersionUID = -7449079488798789337L;
    final Observer<? super U> downstream;
    final ObservableConcatMap.SourceObserver<?, ?> parent;

    ObservableConcatMap.SourceObserver.InnerObserver(Observer<? super U> observer, ObservableConcatMap.SourceObserver<?, ?> sourceObserver) {
        this.downstream = observer;
        this.parent = sourceObserver;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(U u) {
        this.downstream.onNext(u);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
