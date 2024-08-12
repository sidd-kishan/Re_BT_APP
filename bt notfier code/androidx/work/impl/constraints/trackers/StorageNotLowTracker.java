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

public class StorageNotLowTracker
extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = Logger.tagWithPrefix((String)"StorageNotLowTracker");

    public StorageNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public Boolean getInitialState() {
        Object object = this.mAppContext.registerReceiver(null, this.getIntentFilter());
        if (object == null) return true;
        if (object.getAction() == null) {
            return true;
        }
        object = object.getAction();
        int n = -1;
        int n2 = ((String)object).hashCode();
        if (n2 != -1181163412) {
            if (n2 == -730838620 && ((String)object).equals("android.intent.action.DEVICE_STORAGE_OK")) {
                n = 0;
            }
        } else if (((String)object).equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            n = 1;
        }
        if (n == 0) return true;
        if (n == 1) return false;
        return null;
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
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
        if (n2 != -1181163412) {
            if (n2 == -730838620 && ((String)object).equals("android.intent.action.DEVICE_STORAGE_OK")) {
                n = 0;
            }
        } else if (((String)object).equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            n = 1;
        }
        if (n != 0) {
            if (n != 1) return;
            this.setState(false);
        } else {
            this.setState(true);
        }
    }
}
