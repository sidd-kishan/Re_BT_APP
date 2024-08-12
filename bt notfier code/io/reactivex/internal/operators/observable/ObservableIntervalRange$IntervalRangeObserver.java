/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableIntervalRange.IntervalRangeObserver
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final Observer<? super Long> downstream;
    final long end;

    ObservableIntervalRange.IntervalRangeObserver(Observer<? super Long> observer, long l, long l2) {
        this.downstream = observer;
        this.count = l;
        this.end = l2;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    @Override
    public void run() {
        if (this.isDisposed()) return;
        long l = this.count;
        this.downstream.onNext((Object)l);
        if (l == this.end) {
            DisposableHelper.dispose((AtomicReference)this);
            this.downstream.onComplete();
            return;
        }
        this.count = l + 1L;
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
