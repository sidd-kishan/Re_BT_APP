/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobWorkItem
 *  android.content.Intent
 *  androidx.core.app.JobIntentService$GenericWorkItem
 *  androidx.core.app.JobIntentService$JobServiceEngineImpl
 */
package androidx.core.app;

import android.app.job.JobWorkItem;
import android.content.Intent;
import androidx.core.app.JobIntentService;

final class JobIntentService.JobServiceEngineImpl.WrapperWorkItem
implements JobIntentService.GenericWorkItem {
    final JobWorkItem mJobWork;
    final JobIntentService.JobServiceEngineImpl this$0;

    JobIntentService.JobServiceEngineImpl.WrapperWorkItem(JobIntentService.JobServiceEngineImpl jobServiceEngineImpl, JobWorkItem jobWorkItem) {
        this.this$0 = jobServiceEngineImpl;
        this.mJobWork = jobWorkItem;
    }

    public void complete() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            if (this.this$0.mParams == null) return;
            this.this$0.mParams.completeWork(this.mJobWork);
            return;
        }
    }

    public Intent getIntent() {
        return this.mJobWork.getIntent();
    }
}
