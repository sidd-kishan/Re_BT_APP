/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeTimer.TimerDisposable
extends AtomicReference<Disposable>
implements Disposable,
Runnable {
    private static final long serialVersionUID = 2875964065294031672L;
    final MaybeObserver<? super Long> downstream;

    MaybeTimer.TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
        this.downstream = maybeObserver;
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
