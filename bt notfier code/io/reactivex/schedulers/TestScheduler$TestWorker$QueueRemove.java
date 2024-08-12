/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.schedulers.TestScheduler$TestWorker
 *  io.reactivex.schedulers.TestScheduler$TimedRunnable
 */
package io.reactivex.schedulers;

import io.reactivex.schedulers.TestScheduler;

final class TestScheduler.TestWorker.QueueRemove
implements Runnable {
    final TestScheduler.TestWorker this$1;
    final TestScheduler.TimedRunnable timedAction;

    TestScheduler.TestWorker.QueueRemove(TestScheduler.TestWorker testWorker, TestScheduler.TimedRunnable timedRunnable) {
        this.this$1 = testWorker;
        this.timedAction = timedRunnable;
    }

    @Override
    public void run() {
        this.this$1.this$0.queue.remove(this.timedAction);
    }
}
