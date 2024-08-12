/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.NewThreadWorker
 *  io.reactivex.schedulers.SchedulerRunnableIntrospection
 */
package io.reactivex;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;

static final class Scheduler.DisposeTask
implements Disposable,
Runnable,
SchedulerRunnableIntrospection {
    final Runnable decoratedRun;
    Thread runner;
    final Scheduler.Worker w;

    Scheduler.DisposeTask(Runnable runnable, Scheduler.Worker worker) {
        this.decoratedRun = runnable;
        this.w = worker;
    }

    public void dispose() {
        Scheduler.Worker worker;
        if (this.runner == Thread.currentThread() && (worker = this.w) instanceof NewThreadWorker) {
            ((NewThreadWorker)worker).shutdown();
        } else {
            this.w.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        return this.decoratedRun;
    }

    public boolean isDisposed() {
        return this.w.isDisposed();
    }

    @Override
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.decoratedRun.run();
            return;
        }
        finally {
            this.dispose();
            this.runner = null;
        }
    }
}
