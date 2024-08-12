/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.Configuration
 *  androidx.work.Constraints
 *  androidx.work.Data$Builder
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.Logger
 *  androidx.work.Operation
 *  androidx.work.Operation$State
 *  androidx.work.Operation$State$FAILURE
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkRequest
 *  androidx.work.impl.OperationImpl
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.Schedulers
 *  androidx.work.impl.WorkContinuationImpl
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.RescheduleReceiver
 *  androidx.work.impl.model.Dependency
 *  androidx.work.impl.model.WorkName
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpec$IdAndState
 *  androidx.work.impl.model.WorkTag
 *  androidx.work.impl.utils.CancelWorkRunnable
 *  androidx.work.impl.utils.PackageManagerHelper
 *  androidx.work.impl.workers.ConstraintTrackingWorker
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EnqueueRunnable
implements Runnable {
    private static final String TAG = Logger.tagWithPrefix((String)"EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = new OperationImpl();
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        Set set = WorkContinuationImpl.prerequisitesFor((WorkContinuationImpl)workContinuationImpl);
        boolean bl = EnqueueRunnable.enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), set.toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl var0, List<? extends WorkRequest> var1_1, String[] var2_2, String var3_3, ExistingWorkPolicy var4_4) {
        var15_5 = System.currentTimeMillis();
        var20_6 = var0.getWorkDatabase();
        var8_7 = var2_2 != null && ((String[])var2_2).length > 0 ? 1 : 0;
        if (var8_7 == 0) {
            var7_15 = 1;
            var6_14 = 0;
            var5_13 = 0;
        } else {
            var13_8 = ((String[])var2_2).length;
            var12_9 = 0;
            var11_10 = 1;
            var10_11 = 0;
            var9_12 = 0;
            while (true) {
                var7_15 = var11_10;
                var6_14 = var10_11;
                var5_13 = var9_12;
                if (var12_9 >= var13_8) break;
                var19_17 = var2_2[var12_9];
                var18_16 = var20_6.workSpecDao().getWorkSpec((String)var19_17);
                if (var18_16 == null) {
                    Logger.get().error(EnqueueRunnable.TAG, String.format("Prerequisite %s doesn't exist; not enqueuing", new Object[]{var19_17}), new Throwable[0]);
                    return false;
                }
                var18_16 = var18_16.state;
                var5_13 = var18_16 == WorkInfo.State.SUCCEEDED ? 1 : 0;
                var11_10 &= var5_13;
                if (var18_16 == WorkInfo.State.FAILED) {
                    var5_13 = 1;
                } else {
                    var5_13 = var9_12;
                    if (var18_16 == WorkInfo.State.CANCELLED) {
                        var10_11 = 1;
                        var5_13 = var9_12;
                    }
                }
                ++var12_9;
                var9_12 = var5_13;
            }
        }
        var13_8 = (var14_18 = TextUtils.isEmpty((CharSequence)var3_3) ^ true) != false && var8_7 == 0 ? 1 : 0;
        var18_16 = var2_2;
        var11_10 = var8_7;
        var10_11 = var7_15;
        var12_9 = var6_14;
        var9_12 = var5_13;
        if (var13_8 == 0) ** GOTO lbl108
        var21_19 = var20_6.workSpecDao().getWorkSpecIdAndStatesForName(var3_3);
        var18_16 = var2_2;
        var11_10 = var8_7;
        var10_11 = var7_15;
        var12_9 = var6_14;
        var9_12 = var5_13;
        if (var21_19.isEmpty()) ** GOTO lbl108
        if (var4_4 != ExistingWorkPolicy.APPEND && var4_4 != ExistingWorkPolicy.APPEND_OR_REPLACE) {
            if (var4_4 == ExistingWorkPolicy.KEEP) {
                var18_16 = var21_19.iterator();
                while (var18_16.hasNext()) {
                    var4_4 = (WorkSpec.IdAndState)var18_16.next();
                    if (var4_4.state == WorkInfo.State.ENQUEUED) return false;
                    if (var4_4.state != WorkInfo.State.RUNNING) continue;
                    return false;
                }
            }
            CancelWorkRunnable.forName((String)var3_3, (WorkManagerImpl)var0, (boolean)false).run();
            var4_4 = var20_6.workSpecDao();
            var18_16 = var21_19.iterator();
            while (var18_16.hasNext()) {
                var4_4.delete(((WorkSpec.IdAndState)var18_16.next()).id);
            }
            var17_20 = true;
        } else {
            var18_16 = var20_6.dependencyDao();
            var19_17 = new ArrayList<E>();
            var21_19 = var21_19.iterator();
            while (var21_19.hasNext()) {
                var22_21 = (WorkSpec.IdAndState)var21_19.next();
                if (!var18_16.hasDependents(var22_21.id)) {
                    var9_12 = var22_21.state == WorkInfo.State.SUCCEEDED ? 1 : 0;
                    if (var22_21.state == WorkInfo.State.FAILED) {
                        var5_13 = 1;
                        var8_7 = var6_14;
                        var6_14 = var5_13;
                    } else {
                        var8_7 = var6_14;
                        var6_14 = var5_13;
                        if (var22_21.state == WorkInfo.State.CANCELLED) {
                            var8_7 = 1;
                            var6_14 = var5_13;
                        }
                    }
                    var19_17.add(var22_21.id);
                    var7_15 = var9_12 & var7_15;
                    var5_13 = var6_14;
                } else {
                    var8_7 = var6_14;
                }
                var6_14 = var8_7;
            }
            if (var4_4 == ExistingWorkPolicy.APPEND_OR_REPLACE && (var6_14 != 0 || var5_13 != 0)) {
                var4_4 = var20_6.workSpecDao();
                var18_16 = var4_4.getWorkSpecIdAndStatesForName(var3_3).iterator();
                while (var18_16.hasNext()) {
                    var4_4.delete(((WorkSpec.IdAndState)var18_16.next()).id);
                }
                var4_4 = Collections.emptyList();
                var5_13 = 0;
                var6_14 = 0;
            } else {
                var4_4 = var19_17;
            }
            var18_16 = (String[])var4_4.toArray((T[])var2_2);
            var11_10 = ((Object)var18_16).length > 0 ? 1 : 0;
            var9_12 = var5_13;
            var12_9 = var6_14;
            var10_11 = var7_15;
lbl108:
            // 3 sources

            var17_20 = false;
            var5_13 = var9_12;
            var6_14 = var12_9;
            var7_15 = var10_11;
            var8_7 = var11_10;
            var2_2 = var18_16;
        }
        var1_1 = var1_1.iterator();
        while (var1_1.hasNext() != false) {
            var4_4 = (WorkRequest)var1_1.next();
            var18_16 = var4_4.getWorkSpec();
            if (var8_7 != 0 && var7_15 == 0) {
                var18_16.state = var5_13 != 0 ? WorkInfo.State.FAILED : (var6_14 != 0 ? WorkInfo.State.CANCELLED : WorkInfo.State.BLOCKED);
            } else {
                var18_16.periodStartTime = var18_16.isPeriodic() == false ? var15_5 : 0L;
            }
            if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 25) {
                EnqueueRunnable.tryDelegateConstrainedWorkSpec((WorkSpec)var18_16);
            } else if (Build.VERSION.SDK_INT <= 22 && EnqueueRunnable.usesScheduler(var0, "androidx.work.impl.background.gcm.GcmScheduler")) {
                EnqueueRunnable.tryDelegateConstrainedWorkSpec((WorkSpec)var18_16);
            }
            if (var18_16.state == WorkInfo.State.ENQUEUED) {
                var17_20 = true;
            }
            var20_6.workSpecDao().insertWorkSpec((WorkSpec)var18_16);
            if (var8_7 != 0) {
                for (Object var18_16 : var2_2) {
                    var18_16 = new Dependency(var4_4.getStringId(), (String)var18_16);
                    var20_6.dependencyDao().insertDependency((Dependency)var18_16);
                }
            }
            for (Object var18_16 : var4_4.getTags()) {
                var20_6.workTagDao().insert(new WorkTag((String)var18_16, var4_4.getStringId()));
            }
            if (!var14_18) continue;
            var20_6.workNameDao().insert(new WorkName(var3_3, var4_4.getStringId()));
        }
        return var17_20;
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List list = workContinuationImpl.getParents();
        boolean bl = false;
        if (list == null) return EnqueueRunnable.enqueueContinuation(workContinuationImpl) | bl;
        Iterator iterator = list.iterator();
        bl = false;
        while (iterator.hasNext()) {
            list = (WorkContinuationImpl)iterator.next();
            if (!list.isEnqueued()) {
                bl |= EnqueueRunnable.processContinuation((WorkContinuationImpl)list);
                continue;
            }
            Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", TextUtils.join((CharSequence)", ", (Iterable)list.getIds())), new Throwable[0]);
        }
        return EnqueueRunnable.enqueueContinuation(workContinuationImpl) | bl;
    }

    private static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        Constraints constraints = workSpec.constraints;
        String string = workSpec.workerClassName;
        if (string.equals(ConstraintTrackingWorker.class.getName())) return;
        if (!constraints.requiresBatteryNotLow()) {
            if (!constraints.requiresStorageNotLow()) return;
        }
        constraints = new Data.Builder();
        constraints.putAll(workSpec.input).putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", string);
        workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
        workSpec.input = constraints.build();
    }

    private static boolean usesScheduler(WorkManagerImpl object, String object2) {
        try {
            boolean bl;
            object2 = Class.forName((String)object2);
            object = object.getSchedulers().iterator();
            do {
                if (!object.hasNext()) return false;
            } while (!(bl = ((Class)object2).isAssignableFrom(((Scheduler)object.next()).getClass())));
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        return false;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean bl = EnqueueRunnable.processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return bl;
        }
        finally {
            workDatabase.endTransaction();
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override
    public void run() {
        try {
            if (this.mWorkContinuation.hasCycles()) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.mWorkContinuation));
                throw illegalStateException;
            }
            if (this.addToDatabase()) {
                PackageManagerHelper.setComponentEnabled((Context)this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, (boolean)true);
                this.scheduleWorkInBackground();
            }
            this.mOperation.setState((Operation.State)Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            this.mOperation.setState((Operation.State)new Operation.State.FAILURE(throwable));
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule((Configuration)workManagerImpl.getConfiguration(), (WorkDatabase)workManagerImpl.getWorkDatabase(), (List)workManagerImpl.getSchedulers());
    }
}
