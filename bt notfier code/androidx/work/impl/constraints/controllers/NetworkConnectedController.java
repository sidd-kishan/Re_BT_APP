/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
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
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkConnectedController
extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super((ConstraintTracker)Trackers.getInstance((Context)context, (TaskExecutor)taskExecutor).getNetworkStateTracker());
    }

    boolean hasConstraint(WorkSpec workSpec) {
        boolean bl = workSpec.constraints.getRequiredNetworkType() == NetworkType.CONNECTED;
        return bl;
    }

    boolean isConstrained(NetworkState networkState) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n < 26) return networkState.isConnected() ^ true;
        boolean bl2 = bl;
        if (!networkState.isConnected()) return bl2;
        bl2 = !networkState.isValidated() ? bl : false;
        return bl2;
    }
}
