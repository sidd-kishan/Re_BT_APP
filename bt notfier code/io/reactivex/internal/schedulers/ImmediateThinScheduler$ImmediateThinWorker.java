/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.ImmediateThinScheduler
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import java.util.concurrent.TimeUnit;

static final class ImmediateThinScheduler.ImmediateThinWorker
extends Scheduler.Worker {
    ImmediateThinScheduler.ImmediateThinWorker() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }

    public Disposable schedule(Runnable runnable) {
        runnable.run();
        return ImmediateThinScheduler.DISPOSED;
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    public Disposable schedulePeriodically(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
