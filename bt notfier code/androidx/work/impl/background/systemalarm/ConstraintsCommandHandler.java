/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.background.systemalarm.ConstraintProxy
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$AddRunnable
 *  androidx.work.impl.constraints.WorkConstraintsTracker
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

class ConstraintsCommandHandler {
    private static final String TAG = Logger.tagWithPrefix((String)"ConstraintsCmdHandler");
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTracker mWorkConstraintsTracker;

    ConstraintsCommandHandler(Context context, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = n;
        this.mDispatcher = systemAlarmDispatcher;
        context = systemAlarmDispatcher.getTaskExecutor();
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(this.mContext, (TaskExecutor)context, null);
    }

    void handleConstraintsChanged() {
        String string;
        List list2 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll((Context)this.mContext, (List)list2);
        this.mWorkConstraintsTracker.replace((Iterable)list2);
        Object object = new ArrayList(list2.size());
        long l = System.currentTimeMillis();
        for (List list2 : list2) {
            string = ((WorkSpec)list2).id;
            if (l < list2.calculateNextRunTime() || list2.hasConstraints() && !this.mWorkConstraintsTracker.areAllConstraintsMet(string)) continue;
            object.add(list2);
        }
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.mWorkConstraintsTracker.reset();
                return;
            }
            string = ((WorkSpec)object.next()).id;
            list2 = CommandHandler.createDelayMetIntent((Context)this.mContext, (String)string);
            Logger.get().debug(TAG, String.format("Creating a delay_met command for workSpec with id (%s)", string), new Throwable[0]);
            string = this.mDispatcher;
            string.postOnMainThread((Runnable)new SystemAlarmDispatcher.AddRunnable((SystemAlarmDispatcher)string, (Intent)list2, this.mStartId));
        }
    }
}
