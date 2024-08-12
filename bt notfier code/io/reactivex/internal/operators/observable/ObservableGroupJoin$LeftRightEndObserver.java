/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin$JoinSupport
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableGroupJoin.LeftRightEndObserver
extends AtomicReference<Disposable>
implements Observer<Object>,
Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final ObservableGroupJoin.JoinSupport parent;

    ObservableGroupJoin.LeftRightEndObserver(ObservableGroupJoin.JoinSupport joinSupport, boolean bl, int n) {
        this.parent = joinSupport;
        this.isLeft = bl;
        this.index = n;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerCloseError(throwable);
    }

    public void onNext(Object object) {
        if (!DisposableHelper.dispose((AtomicReference)this)) return;
        this.parent.innerClose(this.isLeft, this);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
