/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable
extends AtomicReference<Disposable>
implements Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(Disposable disposable) {
        this.lazySet(disposable);
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }

    public boolean update(Disposable disposable) {
        return DisposableHelper.set((AtomicReference)this, (Disposable)disposable);
    }
}
