/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

final class FutureDisposable
extends AtomicReference<Future<?>>
implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    FutureDisposable(Future<?> future, boolean bl) {
        super(future);
        this.allowInterrupt = bl;
    }

    public void dispose() {
        Future future = this.getAndSet(null);
        if (future == null) return;
        future.cancel(this.allowInterrupt);
    }

    public boolean isDisposed() {
        Future future = (Future)this.get();
        boolean bl = future == null || future.isDone();
        return bl;
    }
}
