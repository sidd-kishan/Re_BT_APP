/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableTimer.TimerDisposable
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = 3167244060586201109L;
    final CompletableObserver downstream;

    CompletableTimer.TimerDisposable(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    @Override
    public void run() {
        this.downstream.onComplete();
    }

    void setFuture(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
