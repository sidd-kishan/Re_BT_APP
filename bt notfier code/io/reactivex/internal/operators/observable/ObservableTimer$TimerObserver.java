/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimer.TimerObserver
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final Observer<? super Long> downstream;

    ObservableTimer.TimerObserver(Observer<? super Long> observer) {
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
        if (this.isDisposed()) return;
        this.downstream.onNext((Object)0L);
        this.lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onComplete();
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.trySet((AtomicReference)this, (Disposable)disposable);
    }
}
