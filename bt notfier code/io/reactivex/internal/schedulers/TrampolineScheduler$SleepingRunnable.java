/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TrampolineWorker
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

static final class TrampolineScheduler.SleepingRunnable
implements Runnable {
    private final long execTime;
    private final Runnable run;
    private final TrampolineScheduler.TrampolineWorker worker;

    TrampolineScheduler.SleepingRunnable(Runnable runnable, TrampolineScheduler.TrampolineWorker trampolineWorker, long l) {
        this.run = runnable;
        this.worker = trampolineWorker;
        this.execTime = l;
    }

    @Override
    public void run() {
        if (this.worker.disposed) return;
        long l = this.execTime;
        long l2 = this.worker.now(TimeUnit.MILLISECONDS);
        if (l > l2) {
            try {
                Thread.sleep(l - l2);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                RxJavaPlugins.onError((Throwable)interruptedException);
                return;
            }
        }
        if (this.worker.disposed) return;
        this.run.run();
    }
}
