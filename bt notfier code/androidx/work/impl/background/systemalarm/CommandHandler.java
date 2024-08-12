/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.work.Logger
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.Alarms
 *  androidx.work.impl.background.systemalarm.ConstraintsCommandHandler
 *  androidx.work.impl.background.systemalarm.DelayMetCommandHandler
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$AddRunnable
 *  androidx.work.impl.background.systemalarm.SystemAlarmService
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.Alarms;
import androidx.work.impl.background.systemalarm.ConstraintsCommandHandler;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler
implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = Logger.tagWithPrefix((String)"CommandHandler");
    static final long WORK_PROCESSING_TIME_IN_MS = 600000L;
    private final Context mContext;
    private final Object mLock;
    private final Map<String, ExecutionListener> mPendingDelayMet;

    CommandHandler(Context context) {
        this.mContext = context;
        this.mPendingDelayMet = new HashMap<String, ExecutionListener>();
        this.mLock = new Object();
    }

    static Intent createConstraintsChangedIntent(Context context) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_CONSTRAINTS_CHANGED);
        return context;
    }

    static Intent createDelayMetIntent(Context context, String string) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_DELAY_MET);
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    static Intent createExecutionCompletedIntent(Context context, String string, boolean bl) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_EXECUTION_COMPLETED);
        context.putExtra(KEY_WORKSPEC_ID, string);
        context.putExtra(KEY_NEEDS_RESCHEDULE, bl);
        return context;
    }

    static Intent createRescheduleIntent(Context context) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_RESCHEDULE);
        return context;
    }

    static Intent createScheduleWorkIntent(Context context, String string) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_SCHEDULE_WORK);
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    static Intent createStopWorkIntent(Context context, String string) {
        context = new Intent(context, SystemAlarmService.class);
        context.setAction(ACTION_STOP_WORK);
        context.putExtra(KEY_WORKSPEC_ID, string);
        return context;
    }

    private void handleConstraintsChanged(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new ConstraintsCommandHandler(this.mContext, n, systemAlarmDispatcher).handleConstraintsChanged();
    }

    private void handleDelayMet(Intent object, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle bundle = object.getExtras();
        object = this.mLock;
        synchronized (object) {
            String string = bundle.getString(KEY_WORKSPEC_ID);
            Logger.get().debug(TAG, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.mPendingDelayMet.containsKey(string)) {
                bundle = new DelayMetCommandHandler(this.mContext, n, string, systemAlarmDispatcher);
                this.mPendingDelayMet.put(string, (ExecutionListener)bundle);
                bundle.handleProcessWork();
            } else {
                Logger.get().debug(TAG, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
            return;
        }
    }

    private void handleExecutionCompleted(Intent intent, int n) {
        Bundle bundle = intent.getExtras();
        String string = bundle.getString(KEY_WORKSPEC_ID);
        boolean bl = bundle.getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", intent, n), new Throwable[0]);
        this.onExecuted(string, bl);
    }

    private void handleReschedule(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", intent, n), new Throwable[0]);
        systemAlarmDispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(Intent intent, int n, SystemAlarmDispatcher object) {
        String string = intent.getExtras().getString(KEY_WORKSPEC_ID);
        Logger.get().debug(TAG, String.format("Handling schedule work for %s", string), new Throwable[0]);
        intent = object.getWorkManager().getWorkDatabase();
        intent.beginTransaction();
        try {
            WorkSpec workSpec = intent.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                workSpec = Logger.get();
                object = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Skipping scheduling ");
                stringBuilder.append(string);
                stringBuilder.append(" because it's no longer in the DB");
                workSpec.warning((String)object, stringBuilder.toString(), new Throwable[0]);
                return;
            }
            if (workSpec.state.isFinished()) {
                workSpec = Logger.get();
                object = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Skipping scheduling ");
                stringBuilder.append(string);
                stringBuilder.append("because it is finished.");
                workSpec.warning((String)object, stringBuilder.toString(), new Throwable[0]);
                return;
            }
            long l = workSpec.calculateNextRunTime();
            if (!workSpec.hasConstraints()) {
                Logger.get().debug(TAG, String.format("Setting up Alarms for %s at %s", string, l), new Throwable[0]);
                Alarms.setAlarm((Context)this.mContext, (WorkManagerImpl)object.getWorkManager(), (String)string, (long)l);
            } else {
                Logger.get().debug(TAG, String.format("Opportunistically setting an alarm for %s at %s", string, l), new Throwable[0]);
                Alarms.setAlarm((Context)this.mContext, (WorkManagerImpl)object.getWorkManager(), (String)string, (long)l);
                workSpec = CommandHandler.createConstraintsChangedIntent(this.mContext);
                string = new SystemAlarmDispatcher.AddRunnable(object, (Intent)workSpec, n);
                object.postOnMainThread((Runnable)((Object)string));
            }
            intent.setTransactionSuccessful();
            return;
        }
        finally {
            intent.endTransaction();
        }
    }

    private void handleStopWork(Intent object, SystemAlarmDispatcher systemAlarmDispatcher) {
        object = object.getExtras().getString(KEY_WORKSPEC_ID);
        Logger.get().debug(TAG, String.format("Handing stopWork work for %s", object), new Throwable[0]);
        systemAlarmDispatcher.getWorkManager().stopWork((String)object);
        Alarms.cancelAlarm((Context)this.mContext, (WorkManagerImpl)systemAlarmDispatcher.getWorkManager(), (String)object);
        systemAlarmDispatcher.onExecuted((String)object, false);
    }

    private static boolean hasKeys(Bundle bundle, String ... stringArray) {
        if (bundle == null) return false;
        if (bundle.isEmpty()) {
            return false;
        }
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (bundle.get(stringArray[n2]) == null) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    boolean hasPendingCommands() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = !this.mPendingDelayMet.isEmpty();
            return bl;
        }
    }

    public void onExecuted(String string, boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            ExecutionListener executionListener = this.mPendingDelayMet.remove(string);
            if (executionListener == null) return;
            executionListener.onExecuted(string, bl);
            return;
        }
    }

    void onHandleIntent(Intent intent, int n, SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(string)) {
            this.handleConstraintsChanged(intent, n, systemAlarmDispatcher);
        } else if (ACTION_RESCHEDULE.equals(string)) {
            this.handleReschedule(intent, n, systemAlarmDispatcher);
        } else if (!CommandHandler.hasKeys(intent.getExtras(), KEY_WORKSPEC_ID)) {
            Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", string, KEY_WORKSPEC_ID), new Throwable[0]);
        } else if (ACTION_SCHEDULE_WORK.equals(string)) {
            this.handleScheduleWorkIntent(intent, n, systemAlarmDispatcher);
        } else if (ACTION_DELAY_MET.equals(string)) {
            this.handleDelayMet(intent, n, systemAlarmDispatcher);
        } else if (ACTION_STOP_WORK.equals(string)) {
            this.handleStopWork(intent, systemAlarmDispatcher);
        } else if (ACTION_EXECUTION_COMPLETED.equals(string)) {
            this.handleExecutionCompleted(intent, n);
        } else {
            Logger.get().warning(TAG, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
