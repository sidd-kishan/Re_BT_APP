/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.Logger
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.WorkManagerImpl
 */
package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService
extends JobService
implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix((String)"SystemJobService");
    private final Map<String, JobParameters> mJobParameters = new HashMap<String, JobParameters>();
    private WorkManagerImpl mWorkManagerImpl;

    private static String getWorkSpecIdFromJobParameters(JobParameters object) {
        try {
            object = object.getExtras();
            if (object == null) return null;
            if (!object.containsKey("EXTRA_WORK_SPEC_ID")) return null;
            object = object.getString("EXTRA_WORK_SPEC_ID");
            return object;
        }
        catch (NullPointerException nullPointerException) {
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImpl;
            this.mWorkManagerImpl = workManagerImpl = WorkManagerImpl.getInstance((Context)this.getApplicationContext());
            workManagerImpl.getProcessor().addExecutionListener((ExecutionListener)this);
        }
        catch (IllegalStateException illegalStateException) {
            if (!Application.class.equals(this.getApplication().getClass())) throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl == null) return;
        workManagerImpl.getProcessor().removeExecutionListener((ExecutionListener)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onExecuted(String string, boolean bl) {
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", string), new Throwable[0]);
        Map<String, JobParameters> map = this.mJobParameters;
        synchronized (map) {
            string = this.mJobParameters.remove(string);
        }
        if (string == null) return;
        this.jobFinished((JobParameters)string, bl);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            this.jobFinished(jobParameters, true);
            return false;
        }
        String string = SystemJobService.getWorkSpecIdFromJobParameters(jobParameters);
        if (TextUtils.isEmpty((CharSequence)string)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        WorkerParameters.RuntimeExtras runtimeExtras = this.mJobParameters;
        synchronized (runtimeExtras) {
            if (this.mJobParameters.containsKey(string)) {
                Logger.get().debug(TAG, String.format("Job is already being executed by SystemJobService: %s", string), new Throwable[0]);
                return false;
            }
            Logger.get().debug(TAG, String.format("onStartJob for %s", string), new Throwable[0]);
            this.mJobParameters.put(string, jobParameters);
        }
        runtimeExtras = null;
        if (Build.VERSION.SDK_INT >= 24) {
            WorkerParameters.RuntimeExtras runtimeExtras2 = new WorkerParameters.RuntimeExtras();
            if (jobParameters.getTriggeredContentUris() != null) {
                runtimeExtras2.triggeredContentUris = Arrays.asList(jobParameters.getTriggeredContentUris());
            }
            if (jobParameters.getTriggeredContentAuthorities() != null) {
                runtimeExtras2.triggeredContentAuthorities = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
            }
            runtimeExtras = runtimeExtras2;
            if (Build.VERSION.SDK_INT >= 28) {
                runtimeExtras2.network = jobParameters.getNetwork();
                runtimeExtras = runtimeExtras2;
            }
        }
        this.mWorkManagerImpl.startWork(string, runtimeExtras);
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean onStopJob(JobParameters object) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String string = SystemJobService.getWorkSpecIdFromJobParameters(object);
        if (TextUtils.isEmpty((CharSequence)string)) {
            Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger.get().debug(TAG, String.format("onStopJob for %s", string), new Throwable[0]);
        object = this.mJobParameters;
        synchronized (object) {
            this.mJobParameters.remove(string);
        }
        this.mWorkManagerImpl.stopWork(string);
        return this.mWorkManagerImpl.getProcessor().isCancelled(string) ^ true;
    }
}
