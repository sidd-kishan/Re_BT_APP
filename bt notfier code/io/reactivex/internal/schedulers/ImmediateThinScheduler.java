/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.internal.schedulers.ImmediateThinScheduler$ImmediateThinWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler
extends Scheduler {
    static final Disposable DISPOSED;
    public static final Scheduler INSTANCE;
    static final Scheduler.Worker WORKER;

    static {
        Disposable disposable;
        INSTANCE = new ImmediateThinScheduler();
        WORKER = new ImmediateThinWorker();
        DISPOSED = disposable = Disposables.empty();
        disposable.dispose();
    }

    private ImmediateThinScheduler() {
    }

    public Scheduler.Worker createWorker() {
        return WORKER;
    }

    public Disposable scheduleDirect(Runnable runnable) {
        runnable.run();
        return DISPOSED;
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
