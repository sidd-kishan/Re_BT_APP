/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.WorkManager
 *  androidx.work.WorkRequest
 *  androidx.work.impl.workers.DiagnosticsWorker
 */
package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver
extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix((String)"DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger.get().debug(TAG, "Requesting diagnostics", new Throwable[0]);
        try {
            WorkManager.getInstance((Context)context).enqueue((WorkRequest)OneTimeWorkRequest.from(DiagnosticsWorker.class));
        }
        catch (IllegalStateException illegalStateException) {
            Logger.get().error(TAG, "WorkManager is not initialized", new Throwable[]{illegalStateException});
        }
    }
}
