/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.schedulers.TestScheduler$TestWorker
 */
package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.schedulers.TestScheduler;

static final class TestScheduler.TimedRunnable
implements Comparable<TestScheduler.TimedRunnable> {
    final long count;
    final Runnable run;
    final TestScheduler.TestWorker scheduler;
    final long time;

    TestScheduler.TimedRunnable(TestScheduler.TestWorker testWorker, long l, Runnable runnable, long l2) {
        this.time = l;
        this.run = runnable;
        this.scheduler = testWorker;
        this.count = l2;
    }

    @Override
    public int compareTo(TestScheduler.TimedRunnable timedRunnable) {
        long l = this.time;
        long l2 = timedRunnable.time;
        if (l != l2) return ObjectHelper.compare((long)l, (long)l2);
        return ObjectHelper.compare((long)this.count, (long)timedRunnable.count);
    }

    public String toString() {
        return String.format("TimedRunnable(time = %d, run = %s)", this.time, this.run.toString());
    }
}
