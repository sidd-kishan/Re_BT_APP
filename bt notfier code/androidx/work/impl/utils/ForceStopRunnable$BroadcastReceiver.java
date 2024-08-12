/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.utils.ForceStopRunnable
 */
package androidx.work.impl.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.utils.ForceStopRunnable;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ForceStopRunnable.BroadcastReceiver
extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix((String)"ForceStopRunnable$Rcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        if (!"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) return;
        Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
        ForceStopRunnable.setAlarm((Context)context);
    }
}
