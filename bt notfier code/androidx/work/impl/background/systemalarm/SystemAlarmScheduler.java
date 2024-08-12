/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.model.WorkSpec;

public class SystemAlarmScheduler
implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix((String)"SystemAlarmScheduler");
    private final Context mContext;

    public SystemAlarmScheduler(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void scheduleWorkSpec(WorkSpec workSpec) {
        Logger.get().debug(TAG, String.format("Scheduling work with workSpecId %s", workSpec.id), new Throwable[0]);
        workSpec = CommandHandler.createScheduleWorkIntent((Context)this.mContext, (String)workSpec.id);
        this.mContext.startService((Intent)workSpec);
    }

    public void cancel(String string) {
        string = CommandHandler.createStopWorkIntent((Context)this.mContext, (String)string);
        this.mContext.startService((Intent)string);
    }

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public void schedule(WorkSpec ... workSpecArray) {
        int n = workSpecArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.scheduleWorkSpec(workSpecArray[n2]);
            ++n2;
        }
    }
}
