/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.impl.background.greedy.DelayedWorkTracker
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.model.WorkSpec;

class DelayedWorkTracker.1
implements Runnable {
    final DelayedWorkTracker this$0;
    final WorkSpec val$workSpec;

    DelayedWorkTracker.1(DelayedWorkTracker delayedWorkTracker, WorkSpec workSpec) {
        this.this$0 = delayedWorkTracker;
        this.val$workSpec = workSpec;
    }

    @Override
    public void run() {
        Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", this.val$workSpec.id), new Throwable[0]);
        this.this$0.mGreedyScheduler.schedule(new WorkSpec[]{this.val$workSpec});
    }
}
