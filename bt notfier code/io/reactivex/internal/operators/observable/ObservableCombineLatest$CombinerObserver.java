/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableCombineLatest.CombinerObserver<T, R>
extends AtomicReference<Disposable>
implements Observer<T> {
    private static final long serialVersionUID = -4823716997131257941L;
    final int index;
    final ObservableCombineLatest.LatestCoordinator<T, R> parent;

    ObservableCombineLatest.CombinerObserver(ObservableCombineLatest.LatestCoordinator<T, R> latestCoordinator, int n) {
        this.parent = latestCoordinator;
        this.index = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this.index, throwable);
    }

    public void onNext(T t) {
        this.parent.innerNext(this.index, t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
