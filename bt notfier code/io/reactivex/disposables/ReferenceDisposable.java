/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T>
extends AtomicReference<T>
implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    ReferenceDisposable(T t) {
        super(ObjectHelper.requireNonNull(t, (String)"value is null"));
    }

    public final void dispose() {
        if (this.get() == null) return;
        T t = this.getAndSet(null);
        if (t == null) return;
        this.onDisposed(t);
    }

    public final boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }

    protected abstract void onDisposed(T var1);
}
