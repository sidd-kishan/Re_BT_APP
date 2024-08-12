/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager$WakeLock
 *  android.text.TextUtils
 *  androidx.work.Logger
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.Processor
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$1
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$AddRunnable
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$CommandsCompletedListener
 *  androidx.work.impl.utils.SerialExecutor
 *  androidx.work.impl.utils.WakeLocks
 *  androidx.work.impl.utils.WorkTimer
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemAlarmDispatcher
implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = Logger.tagWithPrefix((String)"SystemAlarmDispatcher");
    final CommandHandler mCommandHandler;
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Handler mMainHandler;
    private final Processor mProcessor;
    private final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    SystemAlarmDispatcher(Context context) {
        this(context, null, null);
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mCommandHandler = new CommandHandler(this.mContext);
        this.mWorkTimer = new WorkTimer();
        if (workManagerImpl == null) {
            workManagerImpl = WorkManagerImpl.getInstance((Context)context);
        }
        this.mWorkManager = workManagerImpl;
        if (processor == null) {
            processor = workManagerImpl.getProcessor();
        }
        this.mProcessor = processor;
        this.mTaskExecutor = this.mWorkManager.getWorkTaskExecutor();
        this.mProcessor.addExecutionListener((ExecutionListener)this);
        this.mIntents = new ArrayList<Intent>();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    private boolean hasIntentWithAction(String string) {
        this.assertMainThread();
        List<Intent> list = this.mIntents;
        synchronized (list) {
            try {
                Iterator<Intent> iterator = this.mIntents.iterator();
                do {
                    if (!iterator.hasNext()) return false;
                } while (!string.equals(iterator.next().getAction()));
                return true;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void processCommand() {
        this.assertMainThread();
        PowerManager.WakeLock wakeLock = WakeLocks.newWakeLock((Context)this.mContext, (String)PROCESS_COMMAND_TAG);
        try {
            wakeLock.acquire();
            TaskExecutor taskExecutor = this.mWorkManager.getWorkTaskExecutor();
            1 var2_3 = new /* Unavailable Anonymous Inner Class!! */;
            taskExecutor.executeOnBackgroundThread((Runnable)var2_3);
            return;
        }
        finally {
            wakeLock.release();
        }
    }

    public boolean add(Intent intent, int n) {
        Object object = Logger.get();
        String string = TAG;
        int n2 = 0;
        object.debug(string, String.format("Adding command %s (%s)", intent, n), new Throwable[0]);
        this.assertMainThread();
        object = intent.getAction();
        if (TextUtils.isEmpty((CharSequence)object)) {
            Logger.get().warning(TAG, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(object) && this.hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra(KEY_START_ID, n);
        object = this.mIntents;
        synchronized (object) {
            n = n2;
            if (!this.mIntents.isEmpty()) {
                n = 1;
            }
            this.mIntents.add(intent);
            if (n != 0) return true;
            this.processCommand();
            return true;
        }
    }

    void dequeueAndCheckForCompletion() {
        Logger.get().debug(TAG, "Checking if commands are complete.", new Throwable[0]);
        this.assertMainThread();
        List<Intent> list = this.mIntents;
        synchronized (list) {
            if (this.mCurrentIntent != null) {
                Logger.get().debug(TAG, String.format("Removing command %s", this.mCurrentIntent), new Throwable[0]);
                if (!this.mIntents.remove(0).equals(this.mCurrentIntent)) {
                    IllegalStateException illegalStateException = new IllegalStateException("Dequeue-d command is not the first.");
                    throw illegalStateException;
                }
                this.mCurrentIntent = null;
            }
            SerialExecutor serialExecutor = this.mTaskExecutor.getBackgroundExecutor();
            if (!this.mCommandHandler.hasPendingCommands() && this.mIntents.isEmpty() && !serialExecutor.hasPendingTasks()) {
                Logger.get().debug(TAG, "No more commands & intents.", new Throwable[0]);
                if (this.mCompletedListener == null) return;
                this.mCompletedListener.onAllCommandsCompleted();
            } else {
                if (this.mIntents.isEmpty()) return;
                this.processCommand();
            }
            return;
        }
    }

    Processor getProcessor() {
        return this.mProcessor;
    }

    TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener((ExecutionListener)this);
        this.mWorkTimer.onDestroy();
        this.mCompletedListener = null;
    }

    public void onExecuted(String string, boolean bl) {
        this.postOnMainThread((Runnable)new AddRunnable(this, CommandHandler.createExecutionCompletedIntent((Context)this.mContext, (String)string, (boolean)bl), 0));
    }

    void postOnMainThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    void setCompletedListener(CommandsCompletedListener commandsCompletedListener) {
        if (this.mCompletedListener != null) {
            Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
            return;
        }
        this.mCompletedListener = commandsCompletedListener;
    }
}
