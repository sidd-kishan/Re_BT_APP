/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

static abstract class JobIntentService.WorkEnqueuer {
    final ComponentName mComponentName;
    boolean mHasJobId;
    int mJobId;

    JobIntentService.WorkEnqueuer(ComponentName componentName) {
        this.mComponentName = componentName;
    }

    abstract void enqueueWork(Intent var1);

    void ensureJobId(int n) {
        if (this.mHasJobId) {
            if (this.mJobId == n) return;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Given job ID ");
            stringBuilder.append(n);
            stringBuilder.append(" is different than previous ");
            stringBuilder.append(this.mJobId);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mHasJobId = true;
        this.mJobId = n;
    }

    public void serviceProcessingFinished() {
    }

    public void serviceProcessingStarted() {
    }

    public void serviceStartReceived() {
    }
}
