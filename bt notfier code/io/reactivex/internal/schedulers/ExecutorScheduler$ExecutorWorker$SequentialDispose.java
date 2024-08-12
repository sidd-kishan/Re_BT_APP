/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;

final class ExecutorScheduler.ExecutorWorker.SequentialDispose
implements Runnable {
    private final Runnable decoratedRun;
    private final SequentialDisposable mar;
    final ExecutorScheduler.ExecutorWorker this$0;

    ExecutorScheduler.ExecutorWorker.SequentialDispose(ExecutorScheduler.ExecutorWorker executorWorker, SequentialDisposable sequentialDisposable, Runnable runnable) {
        this.this$0 = executorWorker;
        this.mar = sequentialDisposable;
        this.decoratedRun = runnable;
    }

    @Override
    public void run() {
        this.mar.replace(this.this$0.schedule(this.decoratedRun));
    }
}
