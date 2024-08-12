/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  androidx.work.Logger
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.CommandHandler
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.CommandHandler;

public class RescheduleReceiver
extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix((String)"RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                WorkManagerImpl.getInstance((Context)context).setReschedulePendingResult(this.goAsync());
            }
            catch (IllegalStateException illegalStateException) {
                Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[]{illegalStateException});
            }
        } else {
            context.startService(CommandHandler.createRescheduleIntent((Context)context));
        }
    }
}
