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

static final class ObservableInterval.IntervalObserver
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = 346773832286157679L;
    long count;
    final Observer<? super Long> downstream;

    ObservableInterval.IntervalObserver(Observer<? super Long> observer) {
        this.downstream = observer;
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
        if (this.get() == DisposableHelper.DISPOSED) return;
        Observer<? super Long> observer = this.downstream;
        long l = this.count;
        this.count = 1L + l;
        observer.onNext((Object)l);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
