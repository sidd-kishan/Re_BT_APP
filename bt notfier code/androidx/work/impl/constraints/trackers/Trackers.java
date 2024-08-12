/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.impl.constraints.trackers.BatteryChargingTracker
 *  androidx.work.impl.constraints.trackers.BatteryNotLowTracker
 *  androidx.work.impl.constraints.trackers.NetworkStateTracker
 *  androidx.work.impl.constraints.trackers.StorageNotLowTracker
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.BatteryChargingTracker;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;
import androidx.work.impl.constraints.trackers.StorageNotLowTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class Trackers {
    private static Trackers sInstance;
    private BatteryChargingTracker mBatteryChargingTracker;
    private BatteryNotLowTracker mBatteryNotLowTracker;
    private NetworkStateTracker mNetworkStateTracker;
    private StorageNotLowTracker mStorageNotLowTracker;

    private Trackers(Context context, TaskExecutor taskExecutor) {
        context = context.getApplicationContext();
        this.mBatteryChargingTracker = new BatteryChargingTracker(context, taskExecutor);
        this.mBatteryNotLowTracker = new BatteryNotLowTracker(context, taskExecutor);
        this.mNetworkStateTracker = new NetworkStateTracker(context, taskExecutor);
        this.mStorageNotLowTracker = new StorageNotLowTracker(context, taskExecutor);
    }

    public static Trackers getInstance(Context object, TaskExecutor taskExecutor) {
        synchronized (Trackers.class) {
            if (sInstance == null) {
                Trackers trackers;
                sInstance = trackers = new Trackers((Context)object, taskExecutor);
            }
            object = sInstance;
            return object;
        }
    }

    public static void setInstance(Trackers trackers) {
        synchronized (Trackers.class) {
            sInstance = trackers;
            return;
        }
    }

    public BatteryChargingTracker getBatteryChargingTracker() {
        return this.mBatteryChargingTracker;
    }

    public BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.mBatteryNotLowTracker;
    }

    public NetworkStateTracker getNetworkStateTracker() {
        return this.mNetworkStateTracker;
    }

    public StorageNotLowTracker getStorageNotLowTracker() {
        return this.mStorageNotLowTracker;
    }
}
