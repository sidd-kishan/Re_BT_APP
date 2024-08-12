/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryNotLowTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    static final float BATTERY_LOW_THRESHOLD = 0.15f;
    private static final String TAG = Logger.tagWithPrefix((String)"BatteryNotLowTracker");

    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public Boolean getInitialState() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter = this.mAppContext.registerReceiver(null, intentFilter);
        boolean bl = false;
        if (intentFilter == null) {
            Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int n = intentFilter.getIntExtra("status", -1);
        int n2 = intentFilter.getIntExtra("level", -1);
        int n3 = intentFilter.getIntExtra("scale", -1);
        float f = (float)n2 / (float)n3;
        if (n != 1) {
            if (!(f > 0.15f)) return bl;
        }
        bl = true;
        return bl;
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public void onBroadcastReceive(Context object, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        Logger.get().debug(TAG, String.format("Received %s", intent.getAction()), new Throwable[0]);
        object = intent.getAction();
        int n = -1;
        int n2 = ((String)object).hashCode();
        if (n2 != -1980154005) {
            if (n2 == 490310653 && ((String)object).equals("android.intent.action.BATTERY_LOW")) {
                n = 1;
            }
        } else if (((String)object).equals("android.intent.action.BATTERY_OKAY")) {
            n = 0;
        }
        if (n != 0) {
            if (n != 1) return;
            this.setState(false);
        } else {
            this.setState(true);
        }
    }
}
