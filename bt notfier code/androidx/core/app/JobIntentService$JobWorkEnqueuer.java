/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.app.job.JobWorkItem
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  androidx.core.app.JobIntentService$WorkEnqueuer
 */
package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;

static final class JobIntentService.JobWorkEnqueuer
extends JobIntentService.WorkEnqueuer {
    private final JobInfo mJobInfo;
    private final JobScheduler mJobScheduler;

    JobIntentService.JobWorkEnqueuer(Context context, ComponentName componentName, int n) {
        super(componentName);
        this.ensureJobId(n);
        this.mJobInfo = new JobInfo.Builder(n, this.mComponentName).setOverrideDeadline(0L).build();
        this.mJobScheduler = (JobScheduler)context.getApplicationContext().getSystemService("jobscheduler");
    }

    void enqueueWork(Intent intent) {
        this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
    }
}
