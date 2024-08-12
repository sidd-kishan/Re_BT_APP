/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Cancellable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable
extends AtomicReference<Cancellable>
implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(Cancellable cancellable) {
        super(cancellable);
    }

    public void dispose() {
        if (this.get() == null) return;
        Cancellable cancellable = this.getAndSet(null);
        if (cancellable == null) return;
        try {
            cancellable.cancel();
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            RxJavaPlugins.onError((Throwable)exception);
        }
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }
}
