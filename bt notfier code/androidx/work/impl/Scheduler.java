/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;

public interface Scheduler {
    public static final int MAX_GREEDY_SCHEDULER_LIMIT = 200;
    public static final int MAX_SCHEDULER_LIMIT = 50;

    public void cancel(String var1);

    public boolean hasLimitedSchedulingSlots();

    public void schedule(WorkSpec ... var1);
}
