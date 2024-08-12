/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  androidx.core.app.JobIntentService$GenericWorkItem
 */
package androidx.core.app;

import android.os.IBinder;
import androidx.core.app.JobIntentService;

static interface JobIntentService.CompatJobEngine {
    public IBinder compatGetBinder();

    public JobIntentService.GenericWorkItem dequeueWork();
}
