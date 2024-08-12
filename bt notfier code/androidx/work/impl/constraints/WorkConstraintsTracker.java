/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.WorkConstraintsCallback
 *  androidx.work.impl.constraints.controllers.BatteryChargingController
 *  androidx.work.impl.constraints.controllers.BatteryNotLowController
 *  androidx.work.impl.constraints.controllers.ConstraintController
 *  androidx.work.impl.constraints.controllers.ConstraintController$OnConstraintUpdatedCallback
 *  androidx.work.impl.constraints.controllers.NetworkConnectedController
 *  androidx.work.impl.constraints.controllers.NetworkMeteredController
 *  androidx.work.impl.constraints.controllers.NetworkNotRoamingController
 *  androidx.work.impl.constraints.controllers.NetworkUnmeteredController
 *  androidx.work.impl.constraints.controllers.StorageNotLowController
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class WorkConstraintsTracker
implements ConstraintController.OnConstraintUpdatedCallback {
    private static final String TAG = Logger.tagWithPrefix((String)"WorkConstraintsTracker");
    private final WorkConstraintsCallback mCallback;
    private final ConstraintController<?>[] mConstraintControllers;
    private final Object mLock;

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        context = context.getApplicationContext();
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(context, taskExecutor), new BatteryNotLowController(context, taskExecutor), new StorageNotLowController(context, taskExecutor), new NetworkConnectedController(context, taskExecutor), new NetworkUnmeteredController(context, taskExecutor), new NetworkNotRoamingController(context, taskExecutor), new NetworkMeteredController(context, taskExecutor)};
        this.mLock = new Object();
    }

    WorkConstraintsTracker(WorkConstraintsCallback workConstraintsCallback, ConstraintController<?>[] constraintControllerArray) {
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = constraintControllerArray;
        this.mLock = new Object();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public boolean areAllConstraintsMet(String string) {
        Object object = this.mLock;
        synchronized (object) {
            ConstraintController<?>[] constraintControllerArray = this.mConstraintControllers;
            int n = constraintControllerArray.length;
            int n2 = 0;
            while (n2 < n) {
                ConstraintController<?> constraintController = constraintControllerArray[n2];
                {
                    if (constraintController.isWorkSpecConstrained(string)) {
                        Logger.get().debug(TAG, String.format("Work %s constrained by %s", string, constraintController.getClass().getSimpleName()), new Throwable[0]);
                        return false;
                    }
                    ++n2;
                }
            }
            return true;
        }
    }

    public void onConstraintMet(List<String> object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                ArrayList<String> arrayList = new ArrayList<String>();
                object = object.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        if (this.mCallback == null) return;
                        this.mCallback.onAllConstraintsMet(arrayList);
                        return;
                    }
                    String string = (String)object.next();
                    if (!this.areAllConstraintsMet(string)) continue;
                    Logger.get().debug(TAG, String.format("Constraints met for %s", string), new Throwable[0]);
                    arrayList.add(string);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void onConstraintNotMet(List<String> list) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mCallback == null) return;
            this.mCallback.onAllConstraintsNotMet(list);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public void replace(Iterable<WorkSpec> constraintControllerArray) {
        Object object = this.mLock;
        synchronized (object) {
            int n;
            ConstraintController<?>[] constraintControllerArray2 = this.mConstraintControllers;
            int n2 = constraintControllerArray2.length;
            int n3 = 0;
            for (n = 0; n < n2; ++n) {
                constraintControllerArray2[n].setCallback(null);
            }
            {
                constraintControllerArray2 = this.mConstraintControllers;
                n2 = constraintControllerArray2.length;
                for (n = 0; n < n2; ++n) {
                    constraintControllerArray2[n].replace(constraintControllerArray);
                }
            }
            {
                constraintControllerArray = this.mConstraintControllers;
                n2 = constraintControllerArray.length;
                n = n3;
                while (n < n2) {
                    constraintControllerArray[n].setCallback((ConstraintController.OnConstraintUpdatedCallback)this);
                    ++n;
                }
                return;
            }
        }
    }

    public void reset() {
        Object object = this.mLock;
        synchronized (object) {
            ConstraintController<?>[] constraintControllerArray = this.mConstraintControllers;
            int n = constraintControllerArray.length;
            int n2 = 0;
            while (n2 < n) {
                constraintControllerArray[n2].reset();
                ++n2;
            }
            return;
        }
    }
}
