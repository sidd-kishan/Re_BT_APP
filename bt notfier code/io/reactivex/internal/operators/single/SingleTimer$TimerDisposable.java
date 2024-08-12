/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleTimer.TimerDisposable
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = 8465401857522493082L;
    final SingleObserver<? super Long> downstream;

    SingleTimer.TimerDisposable(SingleObserver<? super Long> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    @Override
    public void run() {
        this.downstream.onSuccess((Object)0L);
    }

    void setFuture(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
