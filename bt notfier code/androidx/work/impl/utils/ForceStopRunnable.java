/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.AlarmManager
 *  android.app.ApplicationExitInfo
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.database.sqlite.SQLiteAccessPermException
 *  android.database.sqlite.SQLiteCantOpenDatabaseException
 *  android.database.sqlite.SQLiteConstraintException
 *  android.database.sqlite.SQLiteDatabaseCorruptException
 *  android.database.sqlite.SQLiteDatabaseLockedException
 *  android.database.sqlite.SQLiteTableLockedException
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.core.os.BuildCompat
 *  androidx.work.Configuration
 *  androidx.work.InitializationExceptionHandler
 *  androidx.work.Logger
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.Schedulers
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkDatabasePathHelper
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemjob.SystemJobScheduler
 *  androidx.work.impl.model.WorkProgressDao
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver
 *  androidx.work.impl.utils.ProcessUtils
 */
package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.ProcessUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable
implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300L;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = Logger.tagWithPrefix((String)"ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650L);
    private final Context mContext;
    private int mRetryCount;
    private final WorkManagerImpl mWorkManager;

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mRetryCount = 0;
    }

    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int n) {
        return PendingIntent.getBroadcast((Context)context, (int)-1, (Intent)ForceStopRunnable.getIntent(context), (int)n);
    }

    static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        int n = BuildCompat.isAtLeastS() ? 0xA000000 : 0x8000000;
        context = ForceStopRunnable.getPendingIntent(context, n);
        long l = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager == null) return;
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, l, (PendingIntent)context);
        } else {
            alarmManager.set(0, l, (PendingIntent)context);
        }
    }

    public boolean cleanUp() {
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        boolean bl2 = n >= 23 ? SystemJobScheduler.reconcileJobs((Context)this.mContext, (WorkManagerImpl)this.mWorkManager) : false;
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List list2 = workSpecDao.getRunningWork();
            n = list2 != null && !list2.isEmpty() ? 1 : 0;
            if (n != 0) {
                for (List list2 : list2) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{((WorkSpec)list2).id});
                    workSpecDao.markWorkSpecScheduled(((WorkSpec)list2).id, -1L);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
        }
        finally {
            workDatabase.endTransaction();
        }
        if (n == 0) {
            if (!bl2) return bl;
        }
        bl = true;
        return bl;
    }

    public void forceStopRunnable() {
        boolean bl = this.cleanUp();
        if (this.shouldRescheduleWorkers()) {
            Logger.get().debug(TAG, "Rescheduling Workers.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
            this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        } else if (this.isForceStopped()) {
            Logger.get().debug(TAG, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
        } else {
            if (!bl) return;
            Logger.get().debug(TAG, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.schedule((Configuration)this.mWorkManager.getConfiguration(), (WorkDatabase)this.mWorkManager.getWorkDatabase(), (List)this.mWorkManager.getSchedulers());
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean isForceStopped() {
        void var2_5;
        block11: {
            block10: {
                Object object;
                int n;
                block9: {
                    n = 0x20000000;
                    try {
                        if (BuildCompat.isAtLeastS()) {
                            n = 0x22000000;
                        }
                        object = ForceStopRunnable.getPendingIntent(this.mContext, n);
                        if (Build.VERSION.SDK_INT >= 30) {
                            if (object != null) {
                                object.cancel();
                            }
                            if ((object = ((ActivityManager)this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0)) == null) return false;
                            if (object.isEmpty()) return false;
                            n = 0;
                            break block9;
                        }
                        if (object != null) return false;
                        break block10;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        break block11;
                    }
                    catch (SecurityException securityException) {
                        // empty catch block
                        break block11;
                    }
                }
                while (n < object.size()) {
                    if (((ApplicationExitInfo)object.get(n)).getReason() == 10) {
                        return true;
                    }
                    ++n;
                }
                return false;
            }
            ForceStopRunnable.setAlarm(this.mContext);
            return true;
        }
        Logger.get().warning(TAG, "Ignoring exception", new Throwable[]{var2_5});
        return true;
    }

    public boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty((CharSequence)configuration.getDefaultProcessName())) {
            Logger.get().debug(TAG, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean bl = ProcessUtils.isDefaultProcess((Context)this.mContext, (Configuration)configuration);
        Logger.get().debug(TAG, String.format("Is default app process = %s", bl), new Throwable[0]);
        return bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        try {
            boolean bl = this.multiProcessChecks();
            if (!bl) {
                return;
            }
            while (true) {
                InitializationExceptionHandler initializationExceptionHandler;
                int n;
                WorkDatabasePathHelper.migrateDatabase((Context)this.mContext);
                Logger.get().debug(TAG, "Performing cleanup operations.", new Throwable[0]);
                try {
                    this.forceStopRunnable();
                    return;
                }
                catch (SQLiteAccessPermException sQLiteAccessPermException) {
                }
                catch (SQLiteConstraintException sQLiteConstraintException) {
                }
                catch (SQLiteTableLockedException sQLiteTableLockedException) {
                }
                catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
                }
                catch (SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException) {
                }
                catch (SQLiteCantOpenDatabaseException sQLiteCantOpenDatabaseException) {
                    // empty catch block
                }
                this.mRetryCount = n = this.mRetryCount + 1;
                if (n >= 3) {
                    Logger.get().error(TAG, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", new Throwable[]{initializationExceptionHandler});
                    IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", (Throwable)initializationExceptionHandler);
                    initializationExceptionHandler = this.mWorkManager.getConfiguration().getExceptionHandler();
                    if (initializationExceptionHandler == null) throw illegalStateException;
                    Logger.get().debug(TAG, "Routing exception to the specified exception handler", new Throwable[]{illegalStateException});
                    initializationExceptionHandler.handleException((Throwable)illegalStateException);
                    return;
                }
                long l = n;
                Logger.get().debug(TAG, String.format("Retrying after %s", l * 300L), new Throwable[]{initializationExceptionHandler});
                this.sleep((long)this.mRetryCount * 300L);
            }
        }
        finally {
            this.mWorkManager.onForceStopRunnableCompleted();
        }
    }

    boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    /*
     * Enabled force condition propagation
     */
    public void sleep(long l) {
        try {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }
}
