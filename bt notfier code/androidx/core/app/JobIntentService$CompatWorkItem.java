/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.core.app.JobIntentService
 *  androidx.core.app.JobIntentService$GenericWorkItem
 */
package androidx.core.app;

import android.content.Intent;
import androidx.core.app.JobIntentService;

final class JobIntentService.CompatWorkItem
implements JobIntentService.GenericWorkItem {
    final Intent mIntent;
    final int mStartId;
    final JobIntentService this$0;

    JobIntentService.CompatWorkItem(JobIntentService jobIntentService, Intent intent, int n) {
        this.this$0 = jobIntentService;
        this.mIntent = intent;
        this.mStartId = n;
    }

    public void complete() {
        this.this$0.stopSelf(this.mStartId);
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}
