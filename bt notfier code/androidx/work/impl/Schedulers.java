/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.work.Configuration
 *  androidx.work.Logger
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.SystemAlarmScheduler
 *  androidx.work.impl.background.systemalarm.SystemAlarmService
 *  androidx.work.impl.background.systemjob.SystemJobScheduler
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.PackageManagerHelper
 */
package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;

public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = Logger.tagWithPrefix((String)"Schedulers");

    private Schedulers() {
    }

    static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkManagerImpl workManagerImpl) {
        if (Build.VERSION.SDK_INT >= 23) {
            workManagerImpl = new SystemJobScheduler(context, workManagerImpl);
            PackageManagerHelper.setComponentEnabled((Context)context, SystemJobService.class, (boolean)true);
            Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        } else {
            Scheduler scheduler = Schedulers.tryCreateGcmBasedScheduler(context);
            workManagerImpl = scheduler;
            if (scheduler != null) return workManagerImpl;
            workManagerImpl = new SystemAlarmScheduler(context);
            PackageManagerHelper.setComponentEnabled((Context)context, SystemAlarmService.class, (boolean)true);
            Logger.get().debug(TAG, "Created SystemAlarmScheduler", new Throwable[0]);
        }
        return workManagerImpl;
    }

    public static void schedule(Configuration object, WorkDatabase workDatabase, List<Scheduler> object2) {
        block8: {
            if (object2 == null) return;
            if (object2.size() == 0) {
                return;
            }
            WorkSpec[] workSpecArray = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            Object object3 = workSpecArray.getEligibleWorkForScheduling(object.getMaxSchedulerLimit());
            object = workSpecArray.getAllEligibleWorkSpecsForScheduling(200);
            if (object3 != null && object3.size() > 0) {
                long l = System.currentTimeMillis();
                Iterator iterator = object3.iterator();
                while (iterator.hasNext()) {
                    workSpecArray.markWorkSpecScheduled(((WorkSpec)iterator.next()).id, l);
                }
            }
            workDatabase.setTransactionSuccessful();
            if (object3 == null || object3.size() <= 0) break block8;
            workSpecArray = object3.toArray(new WorkSpec[object3.size()]);
            object3 = object2.iterator();
            while (object3.hasNext()) {
                workDatabase = (Scheduler)object3.next();
                if (!workDatabase.hasLimitedSchedulingSlots()) continue;
                workDatabase.schedule(workSpecArray);
            }
        }
        if (object == null) return;
        if (object.size() <= 0) return;
        object = object.toArray(new WorkSpec[object.size()]);
        object2 = object2.iterator();
        while (object2.hasNext()) {
            workDatabase = (Scheduler)object2.next();
            if (workDatabase.hasLimitedSchedulingSlots()) continue;
            workDatabase.schedule((WorkSpec[])object);
        }
        return;
        finally {
            workDatabase.endTransaction();
        }
    }

    private static Scheduler tryCreateGcmBasedScheduler(Context context) {
        try {
            context = (Scheduler)Class.forName(GCM_SCHEDULER).getConstructor(Context.class).newInstance(context);
            Logger.get().debug(TAG, String.format("Created %s", GCM_SCHEDULER), new Throwable[0]);
            return context;
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to create GCM Scheduler", new Throwable[]{throwable});
            return null;
        }
    }
}
