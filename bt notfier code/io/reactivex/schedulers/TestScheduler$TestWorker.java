/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.schedulers.TestScheduler
 *  io.reactivex.schedulers.TestScheduler$TestWorker$QueueRemove
 *  io.reactivex.schedulers.TestScheduler$TimedRunnable
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.schedulers.TestScheduler;
import java.util.concurrent.TimeUnit;

final class TestScheduler.TestWorker
extends Scheduler.Worker {
    volatile boolean disposed;
    final TestScheduler this$0;

    TestScheduler.TestWorker(TestScheduler testScheduler) {
        this.this$0 = testScheduler;
    }

    public void dispose() {
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public long now(TimeUnit timeUnit) {
        return this.this$0.now(timeUnit);
    }

    public Disposable schedule(Runnable runnable) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        TestScheduler testScheduler = this.this$0;
        long l = testScheduler.counter;
        testScheduler.counter = 1L + l;
        runnable = new TestScheduler.TimedRunnable(this, 0L, runnable, l);
        this.this$0.queue.add(runnable);
        return Disposables.fromRunnable((Runnable)new QueueRemove(this, (TestScheduler.TimedRunnable)runnable));
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        long l2 = this.this$0.time;
        l = timeUnit.toNanos(l);
        timeUnit = this.this$0;
        long l3 = ((TestScheduler)timeUnit).counter;
        ((TestScheduler)timeUnit).counter = 1L + l3;
        runnable = new TestScheduler.TimedRunnable(this, l2 + l, runnable, l3);
        this.this$0.queue.add(runnable);
        return Disposables.fromRunnable((Runnable)new QueueRemove(this, (TestScheduler.TimedRunnable)runnable));
    }
}
