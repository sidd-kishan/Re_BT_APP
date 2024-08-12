/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.schedulers.SchedulerRunnableIntrospection
 */
package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.atomic.AtomicReference;

static final class ExecutorScheduler.DelayedRunnable
extends AtomicReference<Runnable>
implements Runnable,
Disposable,
SchedulerRunnableIntrospection {
    private static final long serialVersionUID = -4101336210206799084L;
    final SequentialDisposable direct;
    final SequentialDisposable timed = new SequentialDisposable();

    ExecutorScheduler.DelayedRunnable(Runnable runnable) {
        super(runnable);
        this.direct = new SequentialDisposable();
    }

    public void dispose() {
        if (this.getAndSet(null) == null) return;
        this.timed.dispose();
        this.direct.dispose();
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable)this.get();
        if (runnable != null) return runnable;
        runnable = Functions.EMPTY_RUNNABLE;
        return runnable;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == null;
        return bl;
    }

    @Override
    public void run() {
        Runnable runnable = (Runnable)this.get();
        if (runnable == null) return;
        try {
            runnable.run();
        }
        finally {
            this.lazySet(null);
            this.timed.lazySet((Object)DisposableHelper.DISPOSED);
            this.direct.lazySet((Object)DisposableHelper.DISPOSED);
        }
    }
}
