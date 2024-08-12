/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  androidx.work.Logger
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$AddRunnable
 *  androidx.work.impl.constraints.WorkConstraintsCallback
 *  androidx.work.impl.constraints.WorkConstraintsTracker
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.WakeLocks
 *  androidx.work.impl.utils.WorkTimer$TimeLimitExceededListener
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collections;
import java.util.List;

public class DelayMetCommandHandler
implements WorkConstraintsCallback,
ExecutionListener,
WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = Logger.tagWithPrefix((String)"DelayMetCommandHandler");
    private final Context mContext;
    private int mCurrentState;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints;
    private final Object mLock;
    private final int mStartId;
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final String mWorkSpecId;

    DelayMetCommandHandler(Context context, int n, String string, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = n;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkSpecId = string;
        context = systemAlarmDispatcher.getTaskExecutor();
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(this.mContext, (TaskExecutor)context, (WorkConstraintsCallback)this);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    private void cleanUp() {
        Object object = this.mLock;
        synchronized (object) {
            this.mWorkConstraintsTracker.reset();
            this.mDispatcher.getWorkTimer().stopTimer(this.mWorkSpecId);
            if (this.mWakeLock == null) return;
            if (!this.mWakeLock.isHeld()) return;
            Logger.get().debug(TAG, String.format("Releasing wakelock %s for WorkSpec %s", this.mWakeLock, this.mWorkSpecId), new Throwable[0]);
            this.mWakeLock.release();
            return;
        }
    }

    private void stopWork() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger.get().debug(TAG, String.format("Stopping work for WorkSpec %s", this.mWorkSpecId), new Throwable[0]);
                Intent intent = CommandHandler.createStopWorkIntent((Context)this.mContext, (String)this.mWorkSpecId);
                SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
                SystemAlarmDispatcher.AddRunnable addRunnable = new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, intent, this.mStartId);
                systemAlarmDispatcher.postOnMainThread((Runnable)addRunnable);
                if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkSpecId)) {
                    Logger.get().debug(TAG, String.format("WorkSpec %s needs to be rescheduled", this.mWorkSpecId), new Throwable[0]);
                    intent = CommandHandler.createScheduleWorkIntent((Context)this.mContext, (String)this.mWorkSpecId);
                    systemAlarmDispatcher = this.mDispatcher;
                    addRunnable = new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, intent, this.mStartId);
                    systemAlarmDispatcher.postOnMainThread((Runnable)addRunnable);
                } else {
                    Logger.get().debug(TAG, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.mWorkSpecId), new Throwable[0]);
                }
            } else {
                Logger.get().debug(TAG, String.format("Already stopped work for %s", this.mWorkSpecId), new Throwable[0]);
            }
            return;
        }
    }

    void handleProcessWork() {
        boolean bl;
        this.mWakeLock = WakeLocks.newWakeLock((Context)this.mContext, (String)String.format("%s (%s)", this.mWorkSpecId, this.mStartId));
        Logger.get().debug(TAG, String.format("Acquiring wakelock %s for WorkSpec %s", this.mWakeLock, this.mWorkSpecId), new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(this.mWorkSpecId);
        if (workSpec == null) {
            this.stopWork();
            return;
        }
        this.mHasConstraints = bl = workSpec.hasConstraints();
        if (!bl) {
            Logger.get().debug(TAG, String.format("No constraints for %s", this.mWorkSpecId), new Throwable[0]);
            this.onAllConstraintsMet(Collections.singletonList(this.mWorkSpecId));
        } else {
            this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
        }
    }

    public void onAllConstraintsMet(List<String> list) {
        if (!list.contains(this.mWorkSpecId)) {
            return;
        }
        Object object = this.mLock;
        synchronized (object) {
            if (this.mCurrentState == 0) {
                this.mCurrentState = 1;
                Logger.get().debug(TAG, String.format("onAllConstraintsMet for %s", this.mWorkSpecId), new Throwable[0]);
                if (this.mDispatcher.getProcessor().startWork(this.mWorkSpecId)) {
                    this.mDispatcher.getWorkTimer().startTimer(this.mWorkSpecId, 600000L, (WorkTimer.TimeLimitExceededListener)this);
                } else {
                    this.cleanUp();
                }
            } else {
                Logger.get().debug(TAG, String.format("Already started work for %s", this.mWorkSpecId), new Throwable[0]);
            }
            return;
        }
    }

    public void onAllConstraintsNotMet(List<String> list) {
        this.stopWork();
    }

    public void onExecuted(String string, boolean bl) {
        SystemAlarmDispatcher systemAlarmDispatcher;
        Logger.get().debug(TAG, String.format("onExecuted %s, %s", string, bl), new Throwable[0]);
        this.cleanUp();
        if (bl) {
            string = CommandHandler.createScheduleWorkIntent((Context)this.mContext, (String)this.mWorkSpecId);
            systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.postOnMainThread((Runnable)new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, (Intent)string, this.mStartId));
        }
        if (!this.mHasConstraints) return;
        string = CommandHandler.createConstraintsChangedIntent((Context)this.mContext);
        systemAlarmDispatcher = this.mDispatcher;
        systemAlarmDispatcher.postOnMainThread((Runnable)new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, (Intent)string, this.mStartId));
    }

    public void onTimeLimitExceeded(String string) {
        Logger.get().debug(TAG, String.format("Exceeded time limits on execution for %s", string), new Throwable[0]);
        this.stopWork();
    }
}
