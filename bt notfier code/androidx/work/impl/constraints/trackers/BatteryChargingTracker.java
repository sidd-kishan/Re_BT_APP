/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryChargingTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = Logger.tagWithPrefix((String)"BatteryChrgTracker");

    public BatteryChargingTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    /*
     * Enabled force condition propagation
     */
    private boolean isBatteryChangedIntentCharging(Intent intent) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n >= 23) {
            n = intent.getIntExtra("status", -1);
            boolean bl2 = bl;
            if (n == 2) return bl2;
            if (n != 5) return false;
            return bl;
        }
        if (intent.getIntExtra("plugged", 0) != 0) return bl;
        return false;
    }

    public Boolean getInitialState() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if ((intentFilter = this.mAppContext.registerReceiver(null, intentFilter)) != null) return this.isBatteryChangedIntentCharging((Intent)intentFilter);
        Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    public void onBroadcastReceive(Context object, Intent intent) {
        object = intent.getAction();
        if (object == null) {
            return;
        }
        Logger.get().debug(TAG, String.format("Received %s", object), new Throwable[0]);
        int n = -1;
        switch (((String)object).hashCode()) {
            default: {
                break;
            }
            case 1019184907: {
                if (!((String)object).equals("android.intent.action.ACTION_POWER_CONNECTED")) break;
                n = 2;
                break;
            }
            case 948344062: {
                if (!((String)object).equals("android.os.action.CHARGING")) break;
                n = 0;
                break;
            }
            case -54942926: {
                if (!((String)object).equals("android.os.action.DISCHARGING")) break;
                n = 1;
                break;
            }
            case -1886648615: {
                if (!((String)object).equals("android.intent.action.ACTION_POWER_DISCONNECTED")) break;
                n = 3;
            }
        }
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) return;
                    this.setState(false);
                } else {
                    this.setState(true);
                }
            } else {
                this.setState(false);
            }
        } else {
            this.setState(true);
        }
    }
}
