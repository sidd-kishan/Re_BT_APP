/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.TrampolineScheduler$SleepingRunnable
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TimedRunnable
 *  io.reactivex.internal.schedulers.TrampolineScheduler$TrampolineWorker$AppendToQueueTask
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

static final class TrampolineScheduler.TrampolineWorker
extends Scheduler.Worker
implements Disposable {
    final AtomicInteger counter;
    volatile boolean disposed;
    final PriorityBlockingQueue<TrampolineScheduler.TimedRunnable> queue = new PriorityBlockingQueue();
    private final AtomicInteger wip = new AtomicInteger();

    TrampolineScheduler.TrampolineWorker() {
        this.counter = new AtomicInteger();
    }

    public void dispose() {
        this.disposed = true;
    }

    Disposable enqueue(Runnable runnable, long l) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        runnable = new TrampolineScheduler.TimedRunnable(runnable, Long.valueOf(l), this.counter.incrementAndGet());
        this.queue.add((TrampolineScheduler.TimedRunnable)runnable);
        if (this.wip.getAndIncrement() != 0) return Disposables.fromRunnable((Runnable)new AppendToQueueTask(this, (TrampolineScheduler.TimedRunnable)runnable));
        int n = 1;
        while (true) {
            if (this.disposed) {
                this.queue.clear();
                return EmptyDisposable.INSTANCE;
            }
            runnable = this.queue.poll();
            if (runnable == null) {
                int n2;
                n = n2 = this.wip.addAndGet(-n);
                if (n2 != 0) continue;
                return EmptyDisposable.INSTANCE;
            }
            if (((TrampolineScheduler.TimedRunnable)runnable).disposed) continue;
            ((TrampolineScheduler.TimedRunnable)runnable).run.run();
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public Disposable schedule(Runnable runnable) {
        return this.enqueue(runnable, this.now(TimeUnit.MILLISECONDS));
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        l = this.now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(l);
        return this.enqueue((Runnable)new TrampolineScheduler.SleepingRunnable(runnable, this, l), l);
    }
}
