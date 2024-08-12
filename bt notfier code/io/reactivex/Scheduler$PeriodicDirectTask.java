/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.schedulers.SchedulerRunnableIntrospection
 */
package io.reactivex;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;

static final class Scheduler.PeriodicDirectTask
implements Disposable,
Runnable,
SchedulerRunnableIntrospection {
    volatile boolean disposed;
    final Runnable run;
    final Scheduler.Worker worker;

    Scheduler.PeriodicDirectTask(Runnable runnable, Scheduler.Worker worker) {
        this.run = runnable;
        this.worker = worker;
    }

    public void dispose() {
        this.disposed = true;
        this.worker.dispose();
    }

    public Runnable getWrappedRunnable() {
        return this.run;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    @Override
    public void run() {
        if (this.disposed) return;
        try {
            this.run.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.worker.dispose();
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }
}
