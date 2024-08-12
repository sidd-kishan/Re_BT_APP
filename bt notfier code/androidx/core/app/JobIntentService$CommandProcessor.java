/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  androidx.core.app.JobIntentService
 */
package androidx.core.app;

import android.os.AsyncTask;
import androidx.core.app.JobIntentService;

final class JobIntentService.CommandProcessor
extends AsyncTask<Void, Void, Void> {
    final JobIntentService this$0;

    JobIntentService.CommandProcessor(JobIntentService jobIntentService) {
        this.this$0 = jobIntentService;
    }

    protected Void doInBackground(Void ... genericWorkItem) {
        while ((genericWorkItem = this.this$0.dequeueWork()) != null) {
            this.this$0.onHandleWork(genericWorkItem.getIntent());
            genericWorkItem.complete();
        }
        return null;
    }

    protected void onCancelled(Void void_) {
        this.this$0.processorFinished();
    }

    protected void onPostExecute(Void void_) {
        this.this$0.processorFinished();
    }
}
