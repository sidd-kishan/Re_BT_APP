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

public abstract class DefaultObserver<T>
implements Observer<T> {
    private Disposable upstream;

    protected final void cancel() {
        Disposable disposable = this.upstream;
        this.upstream = DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    protected void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (!EndConsumerHelper.validate((Disposable)this.upstream, (Disposable)disposable, this.getClass())) return;
        this.upstream = disposable;
        this.onStart();
    }
}
