/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.util.EndConsumerHelper
 */
package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T>
implements Observer<T>,
Disposable {
    final AtomicReference<Disposable> upstream = new AtomicReference();

    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    public final boolean isDisposed() {
        boolean bl = this.upstream.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    protected void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (!EndConsumerHelper.setOnce(this.upstream, (Disposable)disposable, this.getClass())) return;
        this.onStart();
    }
}
