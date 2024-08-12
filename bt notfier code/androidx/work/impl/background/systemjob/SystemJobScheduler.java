/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.Logger
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemjob.SystemJobInfoConverter
 *  androidx.work.impl.background.systemjob.SystemJobService
 *  androidx.work.impl.model.SystemIdInfo
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.IdGenerator
 */
package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobInfoConverter;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler
implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix((String)"SystemJobScheduler");
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler)context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mWorkManager = workManagerImpl;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    public static void cancelAll(Context object) {
        JobScheduler jobScheduler = (JobScheduler)object.getSystemService("jobscheduler");
        if (jobScheduler == null) return;
        if ((object = SystemJobScheduler.getPendingJobs((Context)object, jobScheduler)) == null) return;
        if (object.isEmpty()) return;
        object = object.iterator();
        while (object.hasNext()) {
            SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo)object.next()).getId());
        }
    }

    private static void cancelJobById(JobScheduler jobScheduler, int n) {
        try {
            jobScheduler.cancel(n);
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", n), new Throwable[]{throwable});
        }
    }

    private static List<Integer> getPendingJobIds(Context object, JobScheduler object2, String string) {
        if ((object2 = SystemJobScheduler.getPendingJobs((Context)object, (JobScheduler)object2)) == null) {
            return null;
        }
        object = new ArrayList(2);
        object2 = object2.iterator();
        while (object2.hasNext()) {
            JobInfo jobInfo = (JobInfo)object2.next();
            if (!string.equals(SystemJobScheduler.getWorkSpecIdFromJobInfo(jobInfo))) continue;
            object.add(jobInfo.getId());
        }
        return object;
    }

    private static List<JobInfo> getPendingJobs(Context context, JobScheduler object) {
        try {
            object = object.getAllPendingJobs();
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", new Throwable[]{throwable});
            object = null;
        }
        if (object == null) {
            return null;
        }
        ArrayList<JobInfo> arrayList = new ArrayList<JobInfo>(object.size());
        context = new ComponentName(context, SystemJobService.class);
        object = object.iterator();
        while (object.hasNext()) {
            JobInfo jobInfo = (JobInfo)object.next();
            if (!context.equals((Object)jobInfo.getService())) continue;
            arrayList.add(jobInfo);
        }
        return arrayList;
    }

    private static String getWorkSpecIdFromJobInfo(JobInfo object) {
        if ((object = object.getExtras()) == null) return null;
        try {
            if (!object.containsKey("EXTRA_WORK_SPEC_ID")) return null;
            object = object.getString("EXTRA_WORK_SPEC_ID");
            return object;
        }
        catch (NullPointerException nullPointerException) {
        }
        return null;
    }

    public static boolean reconcileJobs(Context object, WorkManagerImpl workManagerImpl) {
        boolean bl;
        Object object2;
        block8: {
            object2 = (JobScheduler)object.getSystemService("jobscheduler");
            Object object3 = SystemJobScheduler.getPendingJobs((Context)object, (JobScheduler)object2);
            object = workManagerImpl.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
            boolean bl2 = false;
            int n = object3 != null ? object3.size() : 0;
            HashSet<String> hashSet = new HashSet<String>(n);
            if (object3 != null && !object3.isEmpty()) {
                object3 = object3.iterator();
                while (object3.hasNext()) {
                    JobInfo jobInfo = (JobInfo)object3.next();
                    String string = SystemJobScheduler.getWorkSpecIdFromJobInfo(jobInfo);
                    if (!TextUtils.isEmpty((CharSequence)string)) {
                        hashSet.add(string);
                        continue;
                    }
                    SystemJobScheduler.cancelJobById((JobScheduler)object2, jobInfo.getId());
                }
            }
            object2 = object.iterator();
            do {
                bl = bl2;
                if (!object2.hasNext()) break block8;
            } while (hashSet.contains((String)object2.next()));
            Logger.get().debug(TAG, "Reconciling jobs", new Throwable[0]);
            bl = true;
        }
        if (!bl) return bl;
        workManagerImpl = workManagerImpl.getWorkDatabase();
        workManagerImpl.beginTransaction();
        try {
            object2 = workManagerImpl.workSpecDao();
            object = object.iterator();
            while (object.hasNext()) {
                object2.markWorkSpecScheduled((String)object.next(), -1L);
            }
            workManagerImpl.setTransactionSuccessful();
        }
        finally {
            workManagerImpl.endTransaction();
        }
        return bl;
    }

    public void cancel(String string) {
        List<Integer> list = SystemJobScheduler.getPendingJobIds(this.mContext, this.mJobScheduler, string);
        if (list == null) return;
        if (list.isEmpty()) return;
        list = list.iterator();
        while (true) {
            if (!list.hasNext()) {
                this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(string);
                return;
            }
            int n = (Integer)list.next();
            SystemJobScheduler.cancelJobById(this.mJobScheduler, n);
        }
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public void schedule(WorkSpec ... workSpecArray) {
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        int n = workSpecArray.length;
        int n2 = 0;
        while (n2 < n) {
            StringBuilder stringBuilder;
            Object object;
            WorkSpec workSpec = workSpecArray[n2];
            workDatabase.beginTransaction();
            Object object2 = workDatabase.workSpecDao().getWorkSpec(workSpec.id);
            if (object2 == null) {
                object = Logger.get();
                object2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Skipping scheduling ");
                stringBuilder.append(workSpec.id);
                stringBuilder.append(" because it's no longer in the DB");
                object.warning((String)object2, stringBuilder.toString(), new Throwable[0]);
                workDatabase.setTransactionSuccessful();
            } else if (((WorkSpec)object2).state != WorkInfo.State.ENQUEUED) {
                stringBuilder = Logger.get();
                object2 = TAG;
                object = new StringBuilder();
                ((StringBuilder)object).append("Skipping scheduling ");
                ((StringBuilder)object).append(workSpec.id);
                ((StringBuilder)object).append(" because it is no longer enqueued");
                stringBuilder.warning((String)object2, ((StringBuilder)object).toString(), new Throwable[0]);
                workDatabase.setTransactionSuccessful();
            } else {
                object2 = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.id);
                int n3 = object2 != null ? ((SystemIdInfo)object2).systemId : idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                if (object2 == null) {
                    object2 = new SystemIdInfo(workSpec.id, n3);
                    this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo((SystemIdInfo)object2);
                }
                this.scheduleInternal(workSpec, n3);
                if (Build.VERSION.SDK_INT == 23 && (object2 = SystemJobScheduler.getPendingJobIds(this.mContext, this.mJobScheduler, workSpec.id)) != null) {
                    if ((n3 = object2.indexOf(n3)) >= 0) {
                        object2.remove(n3);
                    }
                    n3 = !object2.isEmpty() ? ((Integer)object2.get(0)).intValue() : idGenerator.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());
                    this.scheduleInternal(workSpec, n3);
                }
                workDatabase.setTransactionSuccessful();
            }
            ++n2;
        }
        return;
        finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleInternal(WorkSpec workSpec, int n) {
        Object object = this.mSystemJobInfoConverter.convert(workSpec, n);
        Logger.get().debug(TAG, String.format("Scheduling work ID %s Job ID %s", workSpec.id, n), new Throwable[0]);
        try {
            if (this.mJobScheduler.schedule((JobInfo)object) != 0) return;
            Logger.get().warning(TAG, String.format("Unable to schedule work ID %s", workSpec.id), new Throwable[0]);
            if (!workSpec.expedited) return;
            if (workSpec.outOfQuotaPolicy != OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) return;
            workSpec.expedited = false;
            object = String.format("Scheduling a non-expedited job (work ID %s)", workSpec.id);
            Logger.get().debug(TAG, (String)object, new Throwable[0]);
            this.scheduleInternal(workSpec, n);
        }
        catch (Throwable throwable) {
            Logger.get().error(TAG, String.format("Unable to schedule %s", workSpec), new Throwable[]{throwable});
        }
        catch (IllegalStateException illegalStateException) {
            object = SystemJobScheduler.getPendingJobs(this.mContext, this.mJobScheduler);
            n = object != null ? object.size() : 0;
            object = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", n, this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size(), this.mWorkManager.getConfiguration().getMaxSchedulerLimit());
            Logger.get().error(TAG, (String)object, new Throwable[0]);
            throw new IllegalStateException((String)object, illegalStateException);
        }
    }
}
