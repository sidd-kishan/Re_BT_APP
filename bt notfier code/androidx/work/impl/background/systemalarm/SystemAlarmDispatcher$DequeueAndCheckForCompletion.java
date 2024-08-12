/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 */
package androidx.work.impl.background.systemalarm;

import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;

static class SystemAlarmDispatcher.DequeueAndCheckForCompletion
implements Runnable {
    private final SystemAlarmDispatcher mDispatcher;

    SystemAlarmDispatcher.DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mDispatcher = systemAlarmDispatcher;
    }

    @Override
    public void run() {
        this.mDispatcher.dequeueAndCheckForCompletion();
    }
}
