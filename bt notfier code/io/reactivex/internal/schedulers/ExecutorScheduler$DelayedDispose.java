/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.ExecutorScheduler
 *  io.reactivex.internal.schedulers.ExecutorScheduler$DelayedRunnable
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.ExecutorScheduler;

final class ExecutorScheduler.DelayedDispose
implements Runnable {
    private final ExecutorScheduler.DelayedRunnable dr;
    final ExecutorScheduler this$0;

    ExecutorScheduler.DelayedDispose(ExecutorScheduler executorScheduler, ExecutorScheduler.DelayedRunnable delayedRunnable) {
        this.this$0 = executorScheduler;
        this.dr = delayedRunnable;
    }

    @Override
    public void run() {
        this.dr.direct.replace(this.this$0.scheduleDirect((Runnable)this.dr));
    }
}
