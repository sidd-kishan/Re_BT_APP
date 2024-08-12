/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TimedRunnable
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TrampolineWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.TrampolineScheduler;

final class TrampolineScheduler.TrampolineWorker.AppendToQueueTask
implements Runnable {
    final TrampolineScheduler.TrampolineWorker this$0;
    final TrampolineScheduler.TimedRunnable timedRunnable;

    TrampolineScheduler.TrampolineWorker.AppendToQueueTask(TrampolineScheduler.TrampolineWorker trampolineWorker, TrampolineScheduler.TimedRunnable timedRunnable) {
        this.this$0 = trampolineWorker;
        this.timedRunnable = timedRunnable;
    }

    @Override
    public void run() {
        this.timedRunnable.disposed = true;
        this.this$0.queue.remove(this.timedRunnable);
    }
}
