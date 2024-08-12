/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ExecutorScheduler.ExecutorWorker.BooleanRunnable
extends AtomicBoolean
implements Runnable,
Disposable {
    private static final long serialVersionUID = -2421395018820541164L;
    final Runnable actual;

    ExecutorScheduler.ExecutorWorker.BooleanRunnable(Runnable runnable) {
        this.actual = runnable;
    }

    public void dispose() {
        this.lazySet(true);
    }

    public boolean isDisposed() {
        return this.get();
    }

    @Override
    public void run() {
        if (this.get()) {
            return;
        }
        try {
            this.actual.run();
            return;
        }
        finally {
            this.lazySet(true);
        }
    }
}
