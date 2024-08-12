/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.RunnableScheduler
 *  androidx.work.impl.background.greedy.GreedyScheduler
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix((String)"DelayedWorkTracker");
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables;

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = greedyScheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mRunnables = new HashMap<String, Runnable>();
    }

    public void schedule(WorkSpec workSpec) {
        Runnable runnable = this.mRunnables.remove(workSpec.id);
        if (runnable != null) {
            this.mRunnableScheduler.cancel(runnable);
        }
        runnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mRunnables.put(workSpec.id, runnable);
        long l = System.currentTimeMillis();
        long l2 = workSpec.calculateNextRunTime();
        this.mRunnableScheduler.scheduleWithDelay(l2 - l, runnable);
    }

    public void unschedule(String object) {
        if ((object = this.mRunnables.remove(object)) == null) return;
        this.mRunnableScheduler.cancel((Runnable)object);
    }
}
