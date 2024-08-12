/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.lifecycle.LifecycleService
 *  androidx.work.Logger
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$CommandsCompletedListener
 *  androidx.work.impl.utils.WakeLocks
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

public class SystemAlarmService
extends LifecycleService
implements SystemAlarmDispatcher.CommandsCompletedListener {
    private static final String TAG = Logger.tagWithPrefix((String)"SystemAlarmService");
    private SystemAlarmDispatcher mDispatcher;
    private boolean mIsShutdown;

    private void initializeDispatcher() {
        SystemAlarmDispatcher systemAlarmDispatcher;
        this.mDispatcher = systemAlarmDispatcher = new SystemAlarmDispatcher((Context)this);
        systemAlarmDispatcher.setCompletedListener((SystemAlarmDispatcher.CommandsCompletedListener)this);
    }

    public void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.checkWakeLocks();
        this.stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        this.initializeDispatcher();
        this.mIsShutdown = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            this.initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) return 3;
        this.mDispatcher.add(intent, n2);
        return 3;
    }
}
