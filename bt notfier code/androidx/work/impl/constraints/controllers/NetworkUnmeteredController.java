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

public class NetworkUnmeteredController
extends ConstraintController<NetworkState> {
    public NetworkUnmeteredController(Context context, TaskExecutor taskExecutor) {
        super((ConstraintTracker)Trackers.getInstance((Context)context, (TaskExecutor)taskExecutor).getNetworkStateTracker());
    }

    boolean hasConstraint(WorkSpec workSpec) {
        boolean bl = workSpec.constraints.getRequiredNetworkType() == NetworkType.UNMETERED || Build.VERSION.SDK_INT >= 30 && workSpec.constraints.getRequiredNetworkType() == NetworkType.TEMPORARILY_UNMETERED;
        return bl;
    }

    boolean isConstrained(NetworkState networkState) {
        boolean bl = !networkState.isConnected() || networkState.isMetered();
        return bl;
    }
}
