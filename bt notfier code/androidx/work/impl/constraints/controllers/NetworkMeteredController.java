/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.work.Logger
 *  androidx.work.NetworkType
 *  androidx.work.impl.constraints.NetworkState
 *  androidx.work.impl.constraints.controllers.ConstraintController
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 *  androidx.work.impl.constraints.trackers.Trackers
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkMeteredController
extends ConstraintController<NetworkState> {
    private static final String TAG = Logger.tagWithPrefix((String)"NetworkMeteredCtrlr");

    public NetworkMeteredController(Context context, TaskExecutor taskExecutor) {
        super((ConstraintTracker)Trackers.getInstance((Context)context, (TaskExecutor)taskExecutor).getNetworkStateTracker());
    }

    boolean hasConstraint(WorkSpec workSpec) {
        boolean bl = workSpec.constraints.getRequiredNetworkType() == NetworkType.METERED;
        return bl;
    }

    boolean isConstrained(NetworkState networkState) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n < 26) {
            Logger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return networkState.isConnected() ^ true;
        }
        boolean bl2 = bl;
        if (!networkState.isConnected()) return bl2;
        bl2 = !networkState.isMetered() ? bl : false;
        return bl2;
    }
}
