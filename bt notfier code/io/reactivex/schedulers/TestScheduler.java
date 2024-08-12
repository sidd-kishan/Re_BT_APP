/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.schedulers.TestScheduler$TestWorker
 *  io.reactivex.schedulers.TestScheduler$TimedRunnable
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler
extends Scheduler {
    long counter;
    final Queue<TimedRunnable> queue = new PriorityBlockingQueue<TimedRunnable>(11);
    volatile long time;

    public TestScheduler() {
    }

    public TestScheduler(long l, TimeUnit timeUnit) {
        this.time = timeUnit.toNanos(l);
    }

    private void triggerActions(long l) {
        TimedRunnable timedRunnable;
        while ((timedRunnable = this.queue.peek()) != null && timedRunnable.time <= l) {
            long l2 = timedRunnable.time == 0L ? this.time : timedRunnable.time;
            this.time = l2;
            this.queue.remove(timedRunnable);
            if (timedRunnable.scheduler.disposed) continue;
            timedRunnable.run.run();
        }
        this.time = l;
    }

    public void advanceTimeBy(long l, TimeUnit timeUnit) {
        this.advanceTimeTo(this.time + timeUnit.toNanos(l), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long l, TimeUnit timeUnit) {
        this.triggerActions(timeUnit.toNanos(l));
    }

    public Scheduler.Worker createWorker() {
        return new TestWorker(this);
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        this.triggerActions(this.time);
    }
}
