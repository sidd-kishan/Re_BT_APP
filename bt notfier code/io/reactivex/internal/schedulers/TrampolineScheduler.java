/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TrampolineWorker
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

public final class TrampolineScheduler
extends Scheduler {
    private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    TrampolineScheduler() {
    }

    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    public Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    public Disposable scheduleDirect(Runnable runnable) {
        RxJavaPlugins.onSchedule((Runnable)runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(l);
            RxJavaPlugins.onSchedule((Runnable)runnable).run();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError((Throwable)interruptedException);
        }
        return EmptyDisposable.INSTANCE;
    }
}
