/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestFromObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableWithLatestFromMany.WithLatestInnerObserver
extends AtomicReference<Disposable>
implements Observer<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> parent;

    ObservableWithLatestFromMany.WithLatestInnerObserver(ObservableWithLatestFromMany.WithLatestFromObserver<?, ?> withLatestFromObserver, int n) {
        this.parent = withLatestFromObserver;
        this.index = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this.index, throwable);
    }

    public void onNext(Object object) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, object);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
