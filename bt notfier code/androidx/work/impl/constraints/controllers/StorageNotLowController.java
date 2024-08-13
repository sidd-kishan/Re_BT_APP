/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.impl.constraints.controllers.ConstraintController
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 *  androidx.work.impl.constraints.trackers.Trackers
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class StorageNotLowController
extends ConstraintController<Boolean> {
    public StorageNotLowController(Context context, TaskExecutor taskExecutor) {
        super((ConstraintTracker)Trackers.getInstance((Context)context, (TaskExecutor)taskExecutor).getStorageNotLowTracker());
    }

    boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.requiresStorageNotLow();
    }

    boolean isConstrained(Boolean bl) {
        return bl ^ true;
    }
}