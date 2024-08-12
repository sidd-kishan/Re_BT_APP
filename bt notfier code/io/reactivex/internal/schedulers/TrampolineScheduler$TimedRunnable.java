/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.ObjectHelper;

static final class TrampolineScheduler.TimedRunnable
implements Comparable<TrampolineScheduler.TimedRunnable> {
    final int count;
    volatile boolean disposed;
    final long execTime;
    final Runnable run;

    TrampolineScheduler.TimedRunnable(Runnable runnable, Long l, int n) {
        this.run = runnable;
        this.execTime = l;
        this.count = n;
    }

    @Override
    public int compareTo(TrampolineScheduler.TimedRunnable timedRunnable) {
        int n = ObjectHelper.compare((long)this.execTime, (long)timedRunnable.execTime);
        if (n != 0) return n;
        return ObjectHelper.compare((int)this.count, (int)timedRunnable.count);
    }
}
