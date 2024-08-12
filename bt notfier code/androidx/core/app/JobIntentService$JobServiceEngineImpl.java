/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.app.job.JobParameters
 *  android.app.job.JobServiceEngine
 *  android.app.job.JobWorkItem
 *  android.os.IBinder
 *  androidx.core.app.JobIntentService
 *  androidx.core.app.JobIntentService$CompatJobEngine
 *  androidx.core.app.JobIntentService$GenericWorkItem
 *  androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
 */
package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.os.IBinder;
import androidx.core.app.JobIntentService;

static final class JobIntentService.JobServiceEngineImpl
extends JobServiceEngine
implements JobIntentService.CompatJobEngine {
    static final boolean DEBUG = false;
    static final String TAG = "JobServiceEngineImpl";
    final Object mLock = new Object();
    JobParameters mParams;
    final JobIntentService mService;

    JobIntentService.JobServiceEngineImpl(JobIntentService jobIntentService) {
        super((Service)jobIntentService);
        this.mService = jobIntentService;
    }

    public IBinder compatGetBinder() {
        return this.getBinder();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public JobIntentService.GenericWorkItem dequeueWork() {
        JobWorkItem jobWorkItem;
        Object object = this.mLock;
        synchronized (object) {
            if (this.mParams == null) {
                return null;
            }
            jobWorkItem = this.mParams.dequeueWork();
        }
        if (jobWorkItem == null) return null;
        jobWorkItem.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
        return new WrapperWorkItem(this, jobWorkItem);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        this.mParams = jobParameters;
        this.mService.ensureProcessorRunningLocked(false);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean bl = this.mService.doStopCurrentWork();
        Object object = this.mLock;
        synchronized (object) {
            this.mParams = null;
            return bl;
        }
    }
}
