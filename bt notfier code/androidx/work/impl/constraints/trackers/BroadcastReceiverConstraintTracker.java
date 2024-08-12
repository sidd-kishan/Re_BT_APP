/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public abstract class BroadcastReceiverConstraintTracker<T>
extends ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix((String)"BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver mBroadcastReceiver = new /* Unavailable Anonymous Inner Class!! */;

    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Context var1, Intent var2);

    public void startTracking() {
        Logger.get().debug(TAG, String.format("%s: registering receiver", ((Object)((Object)this)).getClass().getSimpleName()), new Throwable[0]);
        this.mAppContext.registerReceiver(this.mBroadcastReceiver, this.getIntentFilter());
    }

    public void stopTracking() {
        Logger.get().debug(TAG, String.format("%s: unregistering receiver", ((Object)((Object)this)).getClass().getSimpleName()), new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
    }
}
