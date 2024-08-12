/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 */
package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;

static class SystemAlarmDispatcher.AddRunnable
implements Runnable {
    private final SystemAlarmDispatcher mDispatcher;
    private final Intent mIntent;
    private final int mStartId;

    SystemAlarmDispatcher.AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int n) {
        this.mDispatcher = systemAlarmDispatcher;
        this.mIntent = intent;
        this.mStartId = n;
    }

    @Override
    public void run() {
        this.mDispatcher.add(this.mIntent, this.mStartId);
    }
}
